# Library Management System - Backend

A Spring Boot REST API backend for the Library Management System that handles book management, member registration, and loan tracking.

## Tech Stack

- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **H2 Database** (in-memory)
- **Maven**
- **Lombok**

## Project Structure

```
BACK-END/
├── SRC/
│   └── main/
│       ├── java/com/library/
│       │   ├── controller/       # REST API endpoints
│       │   ├── service/          # Business logic
│       │   ├── entity/           # JPA entities
│       │   ├── repository/       # Database access layer
│       │   ├── dto/              # Data Transfer Objects
│       │   ├── exception/        # Exception handling
│       │   ├── config/           # Configuration & initialization
│       │   └── LibraryManagementSystemApplication.java
│       └── resources/
│           └── application.properties
└── pom.xml
```

## API Endpoints

### Books API
- `GET /api/books` - Get all books
- `GET /api/books/{id}` - Get book by ID
- `GET /api/books/category/{category}` - Get books by category
- `POST /api/books` - Create new book
- `PUT /api/books/{id}` - Update book
- `DELETE /api/books/{id}` - Delete book

### Members API
- `GET /api/members` - Get all members
- `GET /api/members/{id}` - Get member by ID
- `POST /api/members` - Register new member
- `PUT /api/members/{id}` - Update member
- `DELETE /api/members/{id}` - Delete member

### Loans API
- `GET /api/loans` - Get all loans
- `GET /api/loans/active` - Get active loans (not returned)
- `GET /api/loans/{id}` - Get loan by ID
- `GET /api/loans/member/{memberId}` - Get loans by member
- `POST /api/loans` - Issue book (create loan)
- `PUT /api/loans/{id}/return` - Return book

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- Git

## Installation & Setup

### 1. Clone the Repository
```bash
cd "LIBRARY MANAGEMENT SYSTEM/BACK-END"
```

### 2. Build the Project
```bash
mvn clean install
```

### 3. Run the Application
```bash
mvn spring-boot:run
```

Or run the JAR file:
```bash
mvn clean package
java -jar target/library-management-system-1.0.0.jar
```

The server will start on `http://localhost:8080`

## API Base URL
```
http://localhost:8080/api
```

## Database

- **Type**: H2 In-Memory Database
- **Name**: librarydb
- **H2 Console**: `http://localhost:8080/api/h2-console`
  - JDBC URL: `jdbc:h2:mem:librarydb`
  - Username: `sa`
  - Password: (leave blank)

## Sample API Requests

### Create a Book
```bash
curl -X POST http://localhost:8080/api/books \
  -H "Content-Type: application/json" \
  -d '{
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "isbn": "978-0-7432-7356-5",
    "year": 1925,
    "category": "Fiction",
    "copies": 5,
    "available": 5
  }'
```

### Create a Member
```bash
curl -X POST http://localhost:8080/api/members \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Alice Johnson",
    "email": "alice@example.com"
  }'
```

### Issue a Book (Create Loan)
```bash
curl -X POST http://localhost:8080/api/loans \
  -H "Content-Type: application/json" \
  -d '{
    "bookId": 1,
    "memberId": 1
  }'
```

### Return a Book
```bash
curl -X PUT http://localhost:8080/api/loans/1/return \
  -H "Content-Type: application/json"
```

## Features

✅ Create, Read, Update, Delete Books
✅ Register and Manage Members
✅ Issue and Return Books (Loan Management)
✅ Book Availability Tracking
✅ 14-day loan period
✅ CORS enabled for frontend integration
✅ Global Exception Handling
✅ Sample Data Initialization
✅ RESTful API design

## Frontend Integration

The backend is already configured to work with the React frontend:
- CORS is enabled for all origins
- API runs on port 8080 with `/api` context path
- Update your frontend API base URL to: `http://localhost:8080/api`

## Error Handling

The API includes global exception handling with detailed error responses:

```json
{
  "timestamp": "2024-06-10T10:30:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Book is not available",
  "path": "/api/loans"
}
```

## Future Enhancements

- [ ] Authentication & Authorization
- [ ] User roles (Admin, Student, Librarian)
- [ ] Password hashing & JWT tokens
- [ ] Email notifications
- [ ] Fine management for overdue books
- [ ] Book reservations
- [ ] Advanced search & filtering
- [ ] Database migration scripts (Flyway/Liquibase)
- [ ] API documentation (Swagger/OpenAPI)
- [ ] Unit tests & Integration tests

## Running Tests
```bash
mvn test
```

## Troubleshooting

### Port 8080 already in use
```bash
# On Windows
netstat -ano | findstr :8080
taskkill /PID <PID> /F

# On Mac/Linux
lsof -i :8080
kill -9 <PID>
```

### Database connection issues
Check `application.properties` and ensure H2 driver is in classpath.

## License

This project is open source and available under the MIT License.

## Support

For issues and questions, please refer to the project documentation or create an issue in the repository.
