const menuItems = [
  { id: "dashboard", icon: "D", label: "Dashboard" },
  { id: "books", icon: "B", label: "Books" },
  { id: "members", icon: "M", label: "Members" },
  { id: "loans", icon: "I", label: "Issued" },
];

const additionalItems = [
  { id: "returned", icon: "R", label: "Returned" },
  { id: "not-returned", icon: "N", label: "Not Returned" },
];

function Navbar({
  view,
  setView,
  activeLoanCount,
  currentUser,
  onRegisterClick,
  onLoginClick,
  onLogout,
}) {
  const displayName = currentUser?.name || "Guest";
  const profileDetail = currentUser?.role === "student"
    ? currentUser.registrationNumber
    : "Please login";

  return (
    <aside className="new-sidebar">
      <div className="sidebar-profile">
        <div className="profile-avatar">{displayName.charAt(0).toUpperCase()}</div>
        <div className="profile-info">
          <strong>{displayName}</strong>
          <span className="online-status">{profileDetail}</span>
          {currentUser?.role === "student" && (
            <span className="profile-email">{currentUser.email}</span>
          )}
          {currentUser?.role === "admin" && currentUser.email && (
            <span className="profile-email">{currentUser.email}</span>
          )}
        </div>
      </div>

      <div className="auth-buttons">
        {currentUser ? (
          <>
            <div className="welcome-message">
              Welcome, <strong>{currentUser.name}</strong>
            </div>
            <button className="auth-btn-logout" onClick={onLogout}>
              Logout
            </button>
          </>
        ) : (
          <>
            <button className="auth-btn-register" onClick={onRegisterClick}>
              Register
            </button>
            <button className="auth-btn-login" onClick={onLoginClick}>
              Login
            </button>
          </>
        )}
      </div>

      {currentUser ? (
        <>
          <div className="sidebar-section">
            <h4 className="section-title">HEADER</h4>
            <nav className="sidebar-nav">
              {menuItems.map((item) => (
                <button
                  className={`nav-item ${view === item.id ? "active" : ""}`}
                  key={item.id}
                  onClick={() => setView(item.id)}
                >
                  <span className="nav-icon">{item.icon}</span>
                  {item.label}
                  {item.id === "loans" && activeLoanCount > 0 && (
                    <span className="nav-count">{activeLoanCount}</span>
                  )}
                </button>
              ))}
            </nav>
          </div>

          <div className="sidebar-section">
            <h4 className="section-title">ACTIONS</h4>
            <nav className="sidebar-nav">
              {additionalItems.map((item) => (
                <button
                  className={`nav-item ${view === item.id ? "active" : ""}`}
                  key={item.id}
                  onClick={() => setView(item.id)}
                >
                  <span className="nav-icon">{item.icon}</span>
                  {item.label}
                </button>
              ))}
            </nav>
          </div>
        </>
      ) : (
        <div className="login-required-sidebar">
          Login is required to access the library dashboard.
        </div>
      )}
    </aside>
  );
}

export default Navbar;
