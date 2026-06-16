const pageTitles = {
  books: "Book catalog",
  members: "Library members",
  loans: "Issue & returns",
  returned: "Returned books",
  "not-returned": "Books not returned",
};

function Header({ view, openSearch, openAddBook, openDeleteBooks }) {
  const title = view === "dashboard" ? "CUTM Library Control panel" : pageTitles[view];

  return (
    <>
      <header className="new-header">
        <div className="header-top">
          <div className="header-brand">
            <h2>CUTM LIBRARY</h2>
            <button className="menu">☰</button>
          </div>
          
        </div>
        <div className="header-bottom">
          <span className="control-panel">{title}</span>
        </div>
      </header>
      
      <div className="header-actions-bar">
        <button className="action-btn search-btn" onClick={openSearch}>
          <span className="action-icon">🔍</span>
          Search Books
        </button>
        <button className="action-btn add-btn" onClick={openAddBook}>
          <span className="action-icon">➕</span>
          Add Books
        </button>
        <button className="action-btn delete-btn" onClick={openDeleteBooks}>
          <span className="action-icon">🗑️</span>
          Delete Books
        </button>
      </div>
    </>
  );
}

export default Header;
