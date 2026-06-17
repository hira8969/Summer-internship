# Library Management API Tests

Base URL:

```text
http://localhost:8080/api
```

## Books

```http
GET http://localhost:8080/api/books
```

```http
POST http://localhost:8080/api/books
Content-Type: application/json

{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "978-0132350884",
  "year": 2008,
  "category": "Programming",
  "copies": 3,
  "accent": "#4b7a6b"
}
```

```http
DELETE http://localhost:8080/api/books/1
```

## Members

```http
GET http://localhost:8080/api/members
```

```http
POST http://localhost:8080/api/members
Content-Type: application/json

{
  "name": "Asha Patel",
  "email": "asha@example.com",
  "registrationNumber": "REG-203",
  "password": "student123"
}
```

## Student Login

```http
POST http://localhost:8080/api/auth/student/login
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john@example.com",
  "registrationNumber": "REG-101",
  "password": "student123"
}
```

## Loans

```http
GET http://localhost:8080/api/loans
```

```http
GET http://localhost:8080/api/loans/active
```

```http
POST http://localhost:8080/api/loans
Content-Type: application/json

{
  "bookId": 1,
  "memberId": 1
}
```

```http
PUT http://localhost:8080/api/loans/1/return
```
