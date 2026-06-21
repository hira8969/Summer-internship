import { useEffect, useMemo, useState } from "react";
import Body from "./Body";
import Footer from "./Footer";
import Header from "./Header";
import Navbar from "./Navbar";
import LibraryModal from "./LibraryModal";
import { libraryApi } from "./api";

function App() {
  const [data, setData] = useState({ books: [], members: [], loans: [] });
  const [view, setView] = useState("dashboard");
  const [search, setSearch] = useState("");
  const [category, setCategory] = useState("All");
  const [modal, setModal] = useState(null);
  const [selectedBookId, setSelectedBookId] = useState("");
  const [selectedMemberId, setSelectedMemberId] = useState("");
  const [currentUser, setCurrentUser] = useState(() => {
    const savedUser = sessionStorage.getItem("library-current-user");
    return savedUser ? JSON.parse(savedUser) : null;
  });
  const [notice, setNotice] = useState("");

  const notify = (message) => {
    setNotice(message);
    window.setTimeout(() => setNotice(""), 2600);
  };

  const loadLibraryData = async () => {
    try {
      const [books, members, loans] = await Promise.all([
        libraryApi.getBooks(),
        libraryApi.getMembers(),
        libraryApi.getLoans(),
      ]);
      setData({ books, members, loans });
    } catch (error) {
      notify(`Backend error: ${error.message}`);
    }
  };

  useEffect(() => {
    loadLibraryData();
  }, []);

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
    const form = new FormData(event.currentTarget);
    const copies = Number(form.get("copies"));

    try {
      await libraryApi.addBook({
        title: form.get("title"),
        author: form.get("author"),
        category: form.get("category"),
        isbn: form.get("isbn"),
        year: Number(form.get("year")),
        copies,
        accent: ["#e78259", "#4b7a6b", "#405f89", "#675c8c"][data.books.length % 4],
      });
      await loadLibraryData();
      setModal(null);
      notify("Book added to the catalog.");
    } catch (error) {
      notify(`Could not add book: ${error.message}`);
    }
  };

  const addMember = async (event) => {
    event.preventDefault();
    const form = new FormData(event.currentTarget);
    const password = form.get("password");
    const confirmPassword = form.get("confirmPassword");

    if (password !== confirmPassword) {
      notify("Passwords do not match.");
      return;
    }

    try {
      await libraryApi.addMember({
        name: form.get("name"),
        email: form.get("email"),
        registrationNumber: form.get("registrationNumber"),
        password,
      });
      await loadLibraryData();
      setModal(null);
      notify("New member registered.");
    } catch (error) {
      notify(`Could not register member: ${error.message}`);
    }
  };

  const issueBook = async (event) => {
    event.preventDefault();
    const form = new FormData(event.currentTarget);
    const bookId = Number(form.get("bookId"));

    try {
      await libraryApi.issueBook({
        bookId,
        memberId: Number(form.get("memberId")),
      });
      await loadLibraryData();
      setModal(null);
      notify("Book issued successfully.");
    } catch (error) {
      notify(`Could not issue book: ${error.message}`);
    }
  };

  const returnBook = async (loanId) => {
    try {
      await libraryApi.returnBook(loanId);
      await loadLibraryData();
      notify("Book returned and inventory updated.");
    } catch (error) {
      notify(`Could not return book: ${error.message}`);
    }
  };

  const deleteBook = async (bookId) => {
    if (!window.confirm("Delete this book from the catalog?")) {
      return;
    }

    try {
      await libraryApi.deleteBook(bookId);
      await loadLibraryData();
      notify("Book deleted from the catalog.");
    } catch (error) {
      notify(`Could not delete book: ${error.message}`);
    }
  };

  const openIssueModal = ({ bookId = "", memberId = "" } = {}) => {
    setSelectedBookId(bookId);
    setSelectedMemberId(memberId);
    setModal("loan");
  };

  const openBookSearch = () => {
    setView("books");
    window.setTimeout(() => document.querySelector(".book-search")?.focus(), 0);
  };

  const handleLoginSelect = (loginType) => {
    if (loginType === "student") {
      setModal("student-login");
      return;
    }

    setModal("admin-login");
  };

  const handleAdminLogin = (event) => {
    event.preventDefault();
    const form = new FormData(event.currentTarget);
    const adminUser = {
      role: "admin",
      name: "CUTM Admin",
      email: form.get("email").trim(),
    };

    setCurrentUser(adminUser);
    sessionStorage.setItem("library-current-user", JSON.stringify(adminUser));
    setModal(null);
    notify("Logged in as Admin.");
  };

  const handleStudentLogin = async (event) => {
    event.preventDefault();
    const form = new FormData(event.currentTarget);
    try {
      const member = await libraryApi.loginStudent({
        name: form.get("name").trim(),
        email: form.get("email").trim(),
        registrationNumber: form.get("registrationNumber").trim(),
        password: form.get("password"),
      });
      const student = { ...member, role: "student" };

      setCurrentUser(student);
      sessionStorage.setItem("library-current-user", JSON.stringify(student));
      setModal(null);
      notify(`Welcome, ${student.name}.`);
    } catch (error) {
      notify(`Student login failed: ${error.message}`);
    }
  };

  return (
    <div className="app-shell">
      <Navbar 
        view={view} 
        setView={setView} 
        activeLoanCount={activeLoans.length}
        currentUser={currentUser}
        onRegisterClick={() => setModal("member")}
        onLoginClick={() => setModal("login")}
      />

      <main>
        <Header
          view={view}
          openSearch={openBookSearch}
          openAddBook={() => setModal("book")}
          openDeleteBooks={() => {
            setView("books");
            notify("Use Delete on the book you want to remove.");
          }}
        />

        <Body
          view={view}
          data={data}
          books={filteredBooks}
          activeLoans={activeLoans}
          categories={categories}
          category={category}
          search={search}
          setSearch={setSearch}
          setCategory={setCategory}
          setView={setView}
          setModal={setModal}
          openIssueModal={openIssueModal}
          deleteBook={deleteBook}
          notify={notify}
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
        handleAdminLogin={handleAdminLogin}
        handleStudentLogin={handleStudentLogin}
        backToLoginOptions={() => setModal("login")}
        selectedBookId={selectedBookId}
        selectedMemberId={selectedMemberId}
      />

      {notice && <div className="toast">Done: {notice}</div>}
    </div>
  );
}

export default App;
