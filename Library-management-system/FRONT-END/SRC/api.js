const POSTMAN_API_BASE_URL = "http://localhost:8080/api";
const API_BASE_URL = (import.meta.env.VITE_API_URL || POSTMAN_API_BASE_URL).replace(/\/$/, "");

async function request(path, options = {}) {
  const response = await fetch(`${API_BASE_URL}${path}`, {
    headers: {
      "Content-Type": "application/json",
      ...options.headers,
    },
    ...options,
  });

  if (!response.ok) {
    let message = `Request failed with status ${response.status}`;

    try {
      const error = await response.json();
      message = error.message || message;
    } catch {
      // Keep the HTTP status message when the response has no JSON body.
    }

    throw new Error(message);
  }

  return response.status === 204 ? null : response.json();
}

export const libraryApi = {
  getBooks: () => request("/books"),
  getMembers: () => request("/members"),
  getLoans: () => request("/loans"),
  getActiveLoans: () => request("/loans/active"),
  addBook: (book) =>
    request("/books", {
      method: "POST",
      body: JSON.stringify(book),
    }),
  deleteBook: (bookId) =>
    request(`/books/${bookId}`, {
      method: "DELETE",
    }),
  addMember: (member) =>
    request("/members", {
      method: "POST",
      body: JSON.stringify(member),
    }),
  loginStudent: (credentials) =>
    request("/auth/student/login", {
      method: "POST",
      body: JSON.stringify(credentials),
    }),
  issueBook: (loan) =>
    request("/loans", {
      method: "POST",
      body: JSON.stringify(loan),
    }),
  returnBook: (loanId) =>
    request(`/loans/${loanId}/return`, {
      method: "PUT",
    }),
};
