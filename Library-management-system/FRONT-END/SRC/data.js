export const initialBooks = [
  {
    id: 1,
    title: "To Kill a Mockingbird",
    author: "Harper Lee",
    category: "Fiction",
    isbn: "978-0-06-112008-4",
    year: 1960,
    copies: 5,
    available: 3,
    accent: "#e78259"
  },
  {
    id: 2,
    title: "1984",
    author: "George Orwell",
    category: "Fiction",
    isbn: "978-0-451-52493-2",
    year: 1949,
    copies: 4,
    available: 2,
    accent: "#4b7a6b"
  },
  {
    id: 3,
    title: "The Catcher in the Rye",
    author: "J.D. Salinger",
    category: "Fiction",
    isbn: "978-0-316-76948-0",
    year: 1951,
    copies: 3,
    available: 1,
    accent: "#405f89"
  }
];

export const initialMembers = [
  {
    id: "LM-101",
    name: "John Doe",
    email: "john@example.com",
    joined: "2024-01-15"
  },
  {
    id: "LM-102",
    name: "Jane Smith",
    email: "jane@example.com",
    joined: "2024-02-20"
  }
];

export const initialLoans = [
  {
    id: 1,
    bookId: 1,
    memberId: "LM-101",
    issued: "2024-06-01",
    due: "2024-06-15",
    returned: false
  }
];
