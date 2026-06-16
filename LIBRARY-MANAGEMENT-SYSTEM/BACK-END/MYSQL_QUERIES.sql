CREATE DATABASE IF NOT EXISTS library_management;
USE library_management;

SELECT * FROM books;
SELECT * FROM members;
SELECT * FROM loans;

-- Sample Postman payloads use these same API paths:
-- GET    http://localhost:8080/api/books
-- POST   http://localhost:8080/api/books
-- GET    http://localhost:8080/api/members
-- POST   http://localhost:8080/api/members
-- POST   http://localhost:8080/api/auth/student/login
-- GET    http://localhost:8080/api/loans
-- POST   http://localhost:8080/api/loans
-- PUT    http://localhost:8080/api/loans/{id}/return
