# Quick Start Guide - Backend Setup

## Prerequisites Check
Ensure you have the following installed:
- Java 17+ (`java -version`)
- Maven 3.6+ (`mvn -version`)
- Git

## Step 1: Navigate to Backend Directory
```bash
cd "LIBRARY MANAGEMENT SYSTEM/BACK-END"
```

## Step 2: Build the Project
```bash
mvn clean install
```

This command will:
- Download all dependencies
- Compile the Java code
- Run tests (if any)
- Package the application

## Step 3: Run the Backend Server
### Option A: Using Maven
```bash
mvn spring-boot:run
```

### Option B: Using JAR file
```bash
java -jar target/library-management-system-1.0.0.jar
```

## Step 4: Verify the Server is Running
Open your browser or terminal and test:
```bash
curl http://localhost:8080/api/books
```

You should see a JSON response with books data.

## Step 5: Access H2 Console (Optional)
- Open: http://localhost:8080/api/h2-console
- JDBC URL: `jdbc:h2:mem:librarydb`
- Username: `sa`
- Password: (leave blank)
- Click "Connect"

## Testing the API

### Get All Books
```bash
curl http://localhost:8080/api/books
```

### Get All Members
```bash
curl http://localhost:8080/api/members
```

### Create a Book
```bash
curl -X POST http://localhost:8080/api/books \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Sample Book",
    "author": "Author Name",
    "isbn": "123-456-789",
    "year": 2024,
    "category": "Fiction",
    "copies": 3,
    "available": 3
  }'
```

## Connecting Frontend to Backend

In your React frontend, update the API base URL:

```javascript
const API_BASE_URL = "http://localhost:8080/api";

// Example API call
fetch(`${API_BASE_URL}/books`)
  .then(res => res.json())
  .then(data => console.log(data));
```

## Troubleshooting

### Error: "Port 8080 already in use"
1. Find the process using port 8080:
   - Windows: `netstat -ano | findstr :8080`
   - Mac/Linux: `lsof -i :8080`
2. Kill the process or change the port in `application.properties`

### Error: "Maven command not found"
Ensure Maven is installed and added to PATH:
```bash
mvn -version
```

### Database connection issues
1. Check that H2 driver is included in `pom.xml`
2. Verify `application.properties` settings
3. Look for error logs in console

## Project Structure Summary

```
BACK-END/
├── src/main/java/com/library/
│   ├── controller/       # API endpoints (BookController, MemberController, LoanController)
│   ├── service/          # Business logic
│   ├── entity/           # Database models (Book, Member, Loan)
│   ├── repository/       # Data access layer
│   └── exception/        # Error handling
├── src/main/resources/
│   └── application.properties
└── pom.xml              # Maven configuration
```

## Key Features Ready to Use

✅ Books Management (CRUD operations)
✅ Members Management (CRUD operations)
✅ Loan Management (Issue & Return books)
✅ Automatic data initialization on startup
✅ CORS enabled for frontend
✅ Global exception handling
✅ H2 in-memory database with sample data

## Next Steps

1. ✅ Backend is running on http://localhost:8080
2. ⏳ Update frontend to call the backend API
3. ⏳ Test all API endpoints
4. ⏳ (Optional) Add authentication/authorization
5. ⏳ (Optional) Deploy to production

## Stopping the Server

Press `Ctrl+C` in the terminal where the server is running.

## Common API Base URLs for Requests

```
http://localhost:8080/api/books
http://localhost:8080/api/members
http://localhost:8080/api/loans
http://localhost:8080/api/loans/active
```

## Need Help?

Check the detailed README.md for:
- Complete API documentation
- Sample cURL requests
- Database schema details
- Future enhancement plans