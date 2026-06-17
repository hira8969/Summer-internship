export default function Books({
  books,
  categories,
  category,
  setCategory,
  search,
  setSearch,
  openIssueModal,
  deleteBook,
  notify,
}) {
  return (
    <section className="books">
      <div className="filter-section">
        <input
          className="book-search"
          type="search"
          value={search}
          onChange={(event) => setSearch(event.target.value)}
          placeholder="Search by title, author, or ISBN"
        />
        <label>Category:</label>
        <select
          value={category}
          onChange={(event) => setCategory(event.target.value)}
        >
          {categories.map((item) => (
            <option key={item} value={item}>
              {item}
            </option>
          ))}
        </select>
      </div>

      <div className="books-grid">
        {books.length > 0 ? (
          books.map((book) => (
            <article key={book.id} className="book-card">
              <div
                className="book-header"
                style={{ backgroundColor: book.accent }}
              >
                <span className="book-title">{book.title}</span>
              </div>
              <div className="book-content">
                <p>
                  <strong>Author:</strong> {book.author}
                </p>
                <p>
                  <strong>ISBN:</strong> {book.isbn}
                </p>
                <p>
                  <strong>Available:</strong> {book.available} of {book.copies}
                </p>
                <div className="card-actions">
                  <button
                    type="button"
                    onClick={() => openIssueModal({ bookId: book.id })}
                    disabled={book.available === 0}
                  >
                    Issue
                  </button>
                  <button
                    type="button"
                    className="details-btn"
                    onClick={() =>
                      notify(`${book.title} was published in ${book.year}.`)
                    }
                  >
                    Details
                  </button>
                  <button
                    type="button"
                    className="danger-btn"
                    onClick={() => deleteBook(book.id)}
                  >
                    Delete
                  </button>
                </div>
              </div>
            </article>
          ))
        ) : (
          <div className="no-results">No books found matching your search.</div>
        )}
      </div>
    </section>
  );
}
