# Frontend-Backend Integration Guide

This guide shows how to integrate your React frontend with the Spring Boot backend.

## Architecture Overview

```
┌─────────────────────┐
│   React Frontend    │
│   (Port 5173)       │
└──────────┬──────────┘
           │ HTTP Requests
           ↓
┌─────────────────────┐
│  Spring Boot API    │
│  (Port 8080)        │
└──────────┬──────────┘
           │ Database Operations
           ↓
┌─────────────────────┐
│  H2 Database        │
│  (In-Memory)        │
└─────────────────────┘
```

## Step 1: Create API Service File

Create a new file: `FRONT-END/SRC/services/api.js`

```javascript
const API_BASE_URL = "http://localhost:8080/api";

// Book APIs
export const bookAPI = {
  getAll: async () => {
    const res = await fetch(`${API_BASE_URL}/books`);
    return res.json();
  },

  getById: async (id) => {
    const res = await fetch(`${API_BASE_URL}/books/${id}`);
    return res.json();
  },

  getByCategory: async (category) => {
    const res = await fetch(`${API_BASE_URL}/books/category/${category}`);
    return res.json();
  },

  create: async (bookData) => {
    const res = await fetch(`${API_BASE_URL}/books`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(bookData),
    });
    return res.json();
  },

  update: async (id, bookData) => {
    const res = await fetch(`${API_BASE_URL}/books/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(bookData),
    });
    return res.json();
  },

  delete: async (id) => {
    return fetch(`${API_BASE_URL}/books/${id}`, { method: "DELETE" });
  },
};

// Member APIs
export const memberAPI = {
  getAll: async () => {
    const res = await fetch(`${API_BASE_URL}/members`);
    return res.json();
  },

  getById: async (id) => {
    const res = await fetch(`${API_BASE_URL}/members/${id}`);
    return res.json();
  },

  create: async (memberData) => {
    const res = await fetch(`${API_BASE_URL}/members`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(memberData),
    });
    return res.json();
  },

  update: async (id, memberData) => {
    const res = await fetch(`${API_BASE_URL}/members/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(memberData),
    });
    return res.json();
  },

  delete: async (id) => {
    return fetch(`${API_BASE_URL}/members/${id}`, { method: "DELETE" });
  },
};

// Loan APIs
export const loanAPI = {
  getAll: async () => {
    const res = await fetch(`${API_BASE_URL}/loans`);
    return res.json();
  },

  getActive: async () => {
    const res = await fetch(`${API_BASE_URL}/loans/active`);
    return res.json();
  },

  getById: async (id) => {
    const res = await fetch(`${API_BASE_URL}/loans/${id}`);
    return res.json();
  },

  getByMember: async (memberId) => {
    const res = await fetch(`${API_BASE_URL}/loans/member/${memberId}`);
    return res.json();
  },

  issue: async (loanData) => {
    const res = await fetch(`${API_BASE_URL}/loans`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(loanData),
    });
    return res.json();
  },

  return: async (id) => {
    const res = await fetch(`${API_BASE_URL}/loans/${id}/return`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
    });
    return res.json();
  },
};
```

## Step 2: Update App.jsx to Use Backend API

Replace your existing App.jsx with backend integration:

```javascript
import { useMemo, useState, useEffect } from "react";
import Body from "./Body";
import Footer from "./Footer";
import Header from "./Header";
import Navbar from "./Navbar";
import LibraryModal from "./LibraryModal";
import { bookAPI, memberAPI, loanAPI } from "./services/api";

function App() {
  const [data, setData] = useState({ books: [], members: [], loans: [] });
  const [view, setView] = useState("dashboard");
  const [search, setSearch] = useState("");
  const [category, setCategory] = useState("All");
  const [modal, setModal] = useState(null);
  const [notice, setNotice] = useState("");
  const [loading, setLoading] = useState(true);

  // Load data from backend on component mount
  useEffect(() => {
    loadDataFromBackend();
  }, []);

  const loadDataFromBackend = async () => {
    try {
      setLoading(true);
      const [books, members, loans] = await Promise.all([
        bookAPI.getAll(),
        memberAPI.getAll(),
        loanAPI.getAll(),
      ]);
      setData({ books, members, loans });
    } catch (error) {
      console.error("Error loading data:", error);
      notify("Error loading data from server");
    } finally {
      setLoading(false);
    }
  };

  const notify = (message) => {
    setNotice(message);
    window.setTimeout(() => setNotice(""), 2600);
  };

  const activeLoans = data.loans.filter((loan) => !loan.returned);
  const categories = ["All", ...new Set(data.books.map((book) => book.category))];

  const filteredBooks = useMemo(() => {
    const query = search.toLowerCase().trim();
    return data.books.filter((book) => {
      const details = [book.title, book.author, book.isbn].join(" ").toLowerCase();
      const matchesCategory = category === "All" || book.category === category;
      return details.includes(query) && matchesCategory;
    });
  }, [data.books, search, category]);

  const addBook = async (event) => {
    event.preventDefault();
    try {
      const form = new FormData(event.currentTarget);
      const copies = Number(form.get("copies"));
      const newBook = {
        title: form.get("title"),
        author: form.get("author"),
        category: form.get("category"),
        isbn: form.get("isbn"),
        year: Number(form.get("year")),
        copies,
        available: copies,
      };

      const savedBook = await bookAPI.create(newBook);
      setData({ ...data, books: [savedBook, ...data.books] });
      setModal(null);
      notify("Book added to the catalog.");
    } catch (error) {
      console.error("Error adding book:", error);
      notify("Error adding book");
    }
  };

  const addMember = async (event) => {
    event.preventDefault();
    try {
      const form = new FormData(event.currentTarget);
      const member = {
        name: form.get("name"),
        email: form.get("email"),
      };

      const savedMember = await memberAPI.create(member);
      setData({ ...data, members: [...data.members, savedMember] });
      setModal(null);
      notify("New member registered.");
    } catch (error) {
      console.error("Error adding member:", error);
      notify("Error registering member");
    }
  };

  const issueBook = async (event) => {
    event.preventDefault();
    try {
      const form = new FormData(event.currentTarget);
      const bookId = Number(form.get("bookId"));
      const memberId = Number(form.get("memberId"));

      const loanData = {
        bookId,
        memberId,
      };

      const savedLoan = await loanAPI.issue(loanData);

      // Update local data
      const updatedBooks = data.books.map((book) =>
        book.id === bookId ? { ...book, available: book.available - 1 } : book
      );

      setData({
        ...data,
        books: updatedBooks,
        loans: [savedLoan, ...data.loans],
      });

      setModal(null);
      notify("Book issued successfully.");
    } catch (error) {
      console.error("Error issuing book:", error);
      notify("Error issuing book: " + error.message);
    }
  };

  const returnBook = async (loanId) => {
    try {
      const loan = data.loans.find((item) => item.id === loanId);
      await loanAPI.return(loanId);

      const updatedBooks = data.books.map((book) =>
        book.id === loan.bookId ? { ...book, available: book.available + 1 } : book
      );

      const updatedLoans = data.loans.map((item) =>
        item.id === loanId ? { ...item, returned: true } : item
      );

      setData({
        ...data,
        books: updatedBooks,
        loans: updatedLoans,
      });

      notify("Book returned and inventory updated.");
    } catch (error) {
      console.error("Error returning book:", error);
      notify("Error returning book");
    }
  };

  const handleLoginSelect = (loginType) => {
    setModal(null);
    notify(`Logging in as ${loginType.charAt(0).toUpperCase() + loginType.slice(1)}...`);
    console.log("User selected:", loginType);
    // TODO: Implement actual login logic
  };

  if (loading) {
    return <div className="loading">Loading...</div>;
  }

  return (
    <div className="app-shell">
      <Navbar
        view={view}
        setView={setView}
        activeLoanCount={activeLoans.length}
        onLoginClick={() => setModal("login")}
      />

      <main>
        <Header
          view={view}
          search={search}
          setSearch={setSearch}
          setView={setView}
          openAddBook={() => setModal("book")}
        />

        <Body
          view={view}
          data={data}
          books={filteredBooks}
          activeLoans={activeLoans}
          categories={categories}
          category={category}
          search={search}
          setCategory={setCategory}
          setView={setView}
          setModal={setModal}
          returnBook={returnBook}
        />

        <Footer />
      </main>

      <LibraryModal
        modal={modal}
        data={data}
        closeModal={() => setModal(null)}
        addBook={addBook}
        addMember={addMember}
        issueBook={issueBook}
        handleLoginSelect={handleLoginSelect}
      />

      {notice && <div className="toast">Done: {notice}</div>}
    </div>
  );
}

export default App;
```

## Step 3: Running Both Frontend and Backend

### Terminal 1: Start Backend
```bash
cd "LIBRARY MANAGEMENT SYSTEM/BACK-END"
mvn spring-boot:run
```

### Terminal 2: Start Frontend
```bash
cd "LIBRARY MANAGEMENT SYSTEM"
npm run dev
```

The applications will be available at:
- Frontend: http://localhost:5173
- Backend API: http://localhost:8080/api

## Data Flow Example

1. **User adds a book in frontend**
   - Frontend Form → Book Modal
   - POST request to `http://localhost:8080/api/books`
   - Backend creates Book in H2 database
   - Response sent back to frontend
   - Frontend updates UI with new book

2. **User searches for books**
   - Frontend sends GET request to backend
   - Backend queries H2 database
   - Returns matching books as JSON
   - Frontend displays results

3. **User issues a book**
   - Frontend sends POST to `/api/loans` with bookId and memberId
   - Backend updates:
     - Creates Loan record
     - Decreases available count in Book
   - Response includes updated loan info
   - Frontend updates UI

## Important Notes

✅ **CORS is enabled** - Frontend can access backend from different port
✅ **Auto-reload enabled** - Changes reflect immediately
✅ **Sample data initialized** - Data loads on backend startup
✅ **Error handling** - Bad requests show user-friendly messages
✅ **Async operations** - All API calls are non-blocking

## Debugging Tips

1. **Check Network Tab in Browser**
   - Open DevTools (F12) → Network tab
   - See actual API requests/responses

2. **Backend Logs**
   - Watch terminal where backend is running
   - Logs show all SQL queries and errors

3. **H2 Console**
   - Visit http://localhost:8080/api/h2-console
   - Execute SQL queries directly to debug database

## Common Issues & Solutions

### CORS Error
**Problem**: "Access to XMLHttpRequest has been blocked by CORS policy"
**Solution**: Backend already has CORS enabled. Check network tab to see actual error.

### 404 Not Found
**Problem**: API endpoint returns 404
**Solution**: Ensure backend is running and check spelling of API endpoint

### Data Not Persisting
**Problem**: Data disappears after restart
**Solution**: This is normal for in-memory H2 database. Add database configuration to persistence if needed.

### Slow API Responses
**Problem**: First request is slow
**Solution**: Normal - Spring Boot needs time to initialize

## Next Steps

1. ✅ Both frontend and backend running
2. ✅ Data flowing between them
3. ⏳ Test all CRUD operations
4. ⏳ Add user authentication
5. ⏳ Deploy to production (AWS, Azure, etc.)

## Production Deployment Considerations

- Switch from H2 to PostgreSQL/MySQL
- Add proper authentication (JWT/OAuth)
- Configure CORS for specific domains
- Add database migrations
- Set up CI/CD pipeline
- Configure environment variables
