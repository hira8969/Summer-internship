export default function LibraryModal({
  modal,
  data,
  closeModal,
  addBook,
  addMember,
  issueBook,
  handleLoginSelect,
  handleStudentLogin,
  backToLoginOptions,
  selectedBookId,
  selectedMemberId,
}) {
  if (!modal) return null;

  return (
    <div className="modal-overlay active" onClick={closeModal}>
      <div className="modal-content" onClick={(event) => event.stopPropagation()}>
        <button className="close-btn" onClick={closeModal}>x</button>

        {modal === "login" && (
          <div className="login-selection">
            <h2>Member Login</h2>
            <p>Only registered library members can continue.</p>
            <div className="login-options">
              <button className="login-option student" onClick={() => handleLoginSelect("student")}>
                <span>M</span>
                <strong>Login as Registered Admin </strong>
                <p>Use the same details saved during registration</p>
              </button>
            </div>
          </div>
        )}

        {modal === "student-login" && (
          <form className="student-login-form" onSubmit={handleStudentLogin}>
            <h2>Member Login</h2>
            <p>Enter your registered member details to continue.</p>
            <label>
              Name
              <input type="text" name="name" placeholder="Full name" autoComplete="name" required />
            </label>
            <label>
              Email
              <input
                type="email"
                name="email"
                placeholder="student@example.com"
                autoComplete="email"
                required
              />
            </label>
            <label>
              Registration Number
              <input
                type="text"
                name="registrationNumber"
                placeholder="Registration number"
                minLength="3"
                autoComplete="off"
                required
              />
            </label>
            <label>
              Password
              <input
                type="password"
                name="password"
                placeholder="Password"
                minLength="6"
                autoComplete="current-password"
                required
              />
            </label>
            <div className="login-form-actions">
              <button type="button" className="secondary" onClick={backToLoginOptions}>
                Back
              </button>
              <button type="submit" className="primary">Login</button>
            </div>
          </form>
        )}

        {modal === "book" && (
          <form onSubmit={addBook}>
            <h2>Add New Book</h2>
            <input type="text" name="title" placeholder="Title" required />
            <input type="text" name="author" placeholder="Author" required />
            <input type="text" name="isbn" placeholder="ISBN" required />
            <input type="number" name="year" placeholder="Year" required />
            <input type="text" name="category" placeholder="Category" required />
            <input type="number" name="copies" placeholder="Number of Copies" required />
            <button type="submit" className="primary">Add Book</button>
          </form>
        )}

        {modal === "member" && (
          <form onSubmit={addMember}>
            <h2>Register New Member</h2>
            <input type="text" name="name" placeholder="Full Name" required />
            <input type="email" name="email" placeholder="Email" required />
            <input
              type="text"
              name="registrationNumber"
              placeholder="Registration number"
              minLength="3"
              required
            />
            <input
              type="password"
              name="password"
              placeholder="Create password"
              minLength="6"
              autoComplete="new-password"
              required
            />
            <input
              type="password"
              name="confirmPassword"
              placeholder="Confirm password"
              minLength="6"
              autoComplete="new-password"
              required
            />
            <button type="submit" className="primary">Register Member</button>
          </form>
        )}

        {modal === "loan" && (
          <form onSubmit={issueBook}>
            <h2>Issue Book</h2>
            <select name="bookId" defaultValue={selectedBookId} required>
              <option value="">Select Book</option>
              {data.books.map((book) => (
                <option key={book.id} value={book.id} disabled={book.available === 0}>
                  {book.title} (Available: {book.available})
                </option>
              ))}
            </select>
            <select name="memberId" defaultValue={selectedMemberId} required>
              <option value="">Select Member</option>
              {data.members.map((member) => (
                <option key={member.id} value={member.id}>
                  {member.name}
                </option>
              ))}
            </select>
            <button type="submit" className="primary">Issue Book</button>
          </form>
        )}
      </div>
    </div>
  );
}
