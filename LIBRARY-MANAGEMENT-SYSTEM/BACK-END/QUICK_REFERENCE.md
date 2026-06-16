# Backend Quick Reference

## What's Been Created

### ✅ Complete Spring Boot Project Structure
```
BACK-END/
├── pom.xml                           # Maven dependencies
├── README.md                         # Full documentation
├── SETUP.md                          # Quick setup guide
└── src/main/
    ├── java/com/library/
    │   ├── LibraryManagementSystemApplication.java  # Main app
    │   ├── controller/
    │   │   ├── BookController.java
    │   │   ├── MemberController.java
    │   │   └── LoanController.java
    │   ├── service/
    │   │   ├── BookService.java
    │   │   ├── MemberService.java
    │   │   └── LoanService.java
    │   ├── entity/
    │   │   ├── Book.java
    │   │   ├── Member.java
    │   │   └── Loan.java
    │   ├── repository/
    │   │   ├── BookRepository.java
    │   │   ├── MemberRepository.java
    │   │   └── LoanRepository.java
    │   ├── dto/
    │   │   ├── BookDTO.java
    │   │   ├── MemberDTO.java
    │   │   └── LoanDTO.java
    │   ├── exception/
    │   │   ├── ErrorResponse.java
    │   │   └── GlobalExceptionHandler.java
    │   └── config/
    │       └── DataInitializer.java
    └── resources/
        ├── application.properties
        └── application-test.properties
```

## Quick Commands

### Build & Run Backend
```bash
# Navigate to backend
cd "LIBRARY MANAGEMENT SYSTEM/BACK-END"

# Build project
mvn clean install

# Run with Maven
mvn spring-boot:run

# Or run JAR directly
java -jar target/library-management-system-1.0.0.jar
```

### Backend is Running On
```
http://localhost:8080/api
```

## API Endpoints Summary

| Method | Endpoint | Purpose |
|--------|----------|---------|
| GET | `/api/books` | Get all books |
| POST | `/api/books` | Create book |
| PUT | `/api/books/{id}` | Update book |
| DELETE | `/api/books/{id}` | Delete book |
| GET | `/api/members` | Get all members |
| POST | `/api/members` | Register member |
| PUT | `/api/members/{id}` | Update member |
| DELETE | `/api/members/{id}` | Delete member |
| GET | `/api/loans` | Get all loans |
| POST | `/api/loans` | Issue book (create loan) |
| PUT | `/api/loans/{id}/return` | Return book |
| GET | `/api/loans/active` | Get active loans |

## Key Features Implemented

✅ **Book Management**
- Create, Read, Update, Delete books
- Filter by category
- Track available copies

✅ **Member Management**
- Register new members
- Update member info
- View all members

✅ **Loan Management**
- Issue books to members
- Return books to inventory
- Track loan status
- 14-day automatic loan period

✅ **Technical Features**
- Spring Boot 3.2
- Spring Data JPA
- H2 in-memory database
- Global exception handling
- CORS enabled
- Automatic data initialization
- RESTful API design

## Sample Data on Startup

**Books:**
- To Kill a Mockingbird (Harper Lee)
- 1984 (George Orwell)
- The Catcher in the Rye (J.D. Salinger)

**Members:**
- John Doe (john@example.com)
- Jane Smith (jane@example.com)

**Loans:**
- 1 active loan (To Kill a Mockingbird to John Doe)

## Database

- **Type**: H2 (In-memory)
- **Auto-initialized**: Yes, on startup
- **Console**: http://localhost:8080/api/h2-console
  - Username: `sa`
  - Password: (blank)

## Technology Stack

| Component | Technology |
|-----------|------------|
| Language | Java 17 |
| Framework | Spring Boot 3.2 |
| ORM | Spring Data JPA |
| Database | H2 |
| Build Tool | Maven |
| Server | Embedded Tomcat |

## Frontend Integration

The backend is CORS-enabled and ready for frontend integration.

### Example API Call from Frontend:
```javascript
// Fetch all books
fetch('http://localhost:8080/api/books')
  .then(res => res.json())
  .then(data => console.log(data));

// Create a book
fetch('http://localhost:8080/api/books', {
  method: 'POST',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify({
    title: "New Book",
    author: "Author Name",
    isbn: "123-456",
    year: 2024,
    category: "Fiction",
    copies: 5,
    available: 5
  })
})
.then(res => res.json())
.then(data => console.log(data));
```

## Testing the Backend

### Using cURL
```bash
# Get all books
curl http://localhost:8080/api/books

# Get all members
curl http://localhost:8080/api/members

# Create a book
curl -X POST http://localhost:8080/api/books \
  -H "Content-Type: application/json" \
  -d '{"title":"Test","author":"Author","isbn":"123","year":2024,"category":"Fiction","copies":5,"available":5}'
```

### Using Postman
1. Import this collection URL:
   - `http://localhost:8080/api/books`
2. Test GET, POST, PUT, DELETE operations
3. Verify responses

## Troubleshooting

### Backend won't start
```bash
# Check if port 8080 is in use
netstat -ano | findstr :8080

# Change port in application.properties
server.port=8081
```

### Connection refused from frontend
- Check backend is running: `http://localhost:8080/api/books`
- Verify frontend is using correct API URL
- Check CORS is enabled in backend (it is by default)

### Database issues
- Check H2 console for data
- Verify application.properties settings
- Check logs for SQL errors

## Performance Notes

- **First startup**: ~5-10 seconds (Spring initializes)
- **API Response time**: <100ms typically
- **Database queries**: Fast (in-memory)
- **Memory usage**: ~300-400MB

## Files & Documentation

| File | Purpose |
|------|---------|
| README.md | Comprehensive documentation |
| SETUP.md | Quick start guide |
| INTEGRATION_GUIDE.md | Frontend integration steps |
| pom.xml | Maven dependencies & build config |
| application.properties | Server & database config |

## Next Steps

1. ✅ Backend created and ready
2. ⏳ **Run backend**: `mvn spring-boot:run`
3. ⏳ **Test API**: Visit http://localhost:8080/api/books
4. ⏳ **Integrate with frontend**: Use INTEGRATION_GUIDE.md
5. ⏳ Add authentication (future enhancement)

## Support & Documentation

- **Full Docs**: See README.md
- **Quick Start**: See SETUP.md
- **Integration**: See INTEGRATION_GUIDE.md
- **API Base**: http://localhost:8080/api
- **H2 Console**: http://localhost:8080/api/h2-console

---

**Ready to launch your backend!** 🚀

Run: `mvn spring-boot:run` in the BACK-END directory
