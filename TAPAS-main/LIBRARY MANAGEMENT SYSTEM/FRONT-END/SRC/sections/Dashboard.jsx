export default function Dashboard({
  data,
  activeLoans,
  overdueCount,
  setView,
  openIssueModal,
  notify,
}) {
  const today = new Date().toISOString().slice(0, 10);

  return (
    <section className="dashboard">
      <div className="dashboard-grid">
        <button type="button" className="stat-card" onClick={() => setView("books")}>
          <h3>Books</h3>
          <p className="stat-number">{data.books.length}</p>
          <span className="more-info">View catalog</span>
        </button>
        <button type="button" className="stat-card" onClick={() => setView("members")}>
          <h3>Members</h3>
          <p className="stat-number">{data.members.length}</p>
          <span className="more-info">View members</span>
        </button>
        <button
          type="button"
          className="stat-card"
          onClick={() => notify("Magazine management is not available yet.")}
        >
          <h3>Magazines</h3>
          <p className="stat-number">0</p>
          <span className="more-info">More info</span>
        </button>
        <button
          type="button"
          className="stat-card"
          onClick={() => notify("Newspaper management is not available yet.")}
        >
          <h3>Newspapers</h3>
          <p className="stat-number">0</p>
          <span className="more-info">More info</span>
        </button>
      </div>

      <div className="info-cards-row">
        <button type="button" className="info-card" onClick={() => setView("loans")}>
          <div className="info-icon">I</div>
          <div className="info-content">
            <h4>ISSUED</h4>
            <p>{activeLoans.length}</p>
          </div>
        </button>
        <button type="button" className="info-card" onClick={() => setView("returned")}>
          <div className="info-icon">R</div>
          <div className="info-content">
            <h4>RETURNED</h4>
            <p>{data.loans.filter((loan) => loan.returned).length}</p>
          </div>
        </button>
        <button type="button" className="info-card" onClick={() => setView("not-returned")}>
          <div className="info-icon">N</div>
          <div className="info-content">
            <h4>NOT RETURNED</h4>
            <p>{overdueCount}</p>
          </div>
        </button>
        <button type="button" className="info-card" onClick={() => openIssueModal()}>
          <div className="info-icon">+</div>
          <div className="info-content">
            <h4>DATE TODAY</h4>
            <p>{today}</p>
          </div>
        </button>
      </div>
    </section>
  );
}
