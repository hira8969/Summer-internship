function Footer() {
  const handleHelp = () => {
    alert('Help Section:\n\n📚 Books: Manage and search library books\n👥 Members: Register and manage library members\n📤 Issued: Track issued books\n✓ Returned: View returned books\n✕ Not Returned: Track overdue books\n\nFor more assistance, contact the library administrator.');
  };

  return (
    <footer className="footer">
      <p>CUTM Library Management System</p>
      <button className="help-btn" onClick={handleHelp} title="Click for help">
        <span>❓</span> Help
      </button>
    </footer>
  );
}

export default Footer;