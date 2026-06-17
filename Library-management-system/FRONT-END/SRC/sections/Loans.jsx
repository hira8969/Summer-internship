export default function Loans({
  loans,
  title,
  bookById,
  memberById,
  returnBook,
  openIssueModal,
  today,
}) {
  return (
    <section className="loans">
      <div className="section-toolbar">
        <h2>{title}</h2>
        <button type="button" onClick={() => openIssueModal()}>Issue Book</button>
      </div>

      <div className="loans-list">
        {loans.length > 0 ? (
          loans.map((loan) => {
            const book = bookById(loan.bookId);
            const member = memberById(loan.memberId);
            const isOverdue = loan.due < today && !loan.returned;
            return (
              <article key={loan.id} className={`loan-card ${isOverdue ? "overdue" : ""}`}>
                <div className="loan-header">
                  <h3>{book?.title || loan.bookTitle || "Unknown Book"}</h3>
                  <span className={`status ${loan.returned ? "returned" : "active"}`}>
                    {loan.returned ? "Returned" : isOverdue ? "Overdue" : "Active"}
                  </span>
                </div>
                <div className="loan-content">
                  <p><strong>Member:</strong> {member?.name || loan.memberName || "Unknown Member"}</p>
                  <p><strong>Issued:</strong> {loan.issued}</p>
                  <p><strong>Due:</strong> {loan.due}</p>
                </div>
                {!loan.returned && (
                  <button type="button" onClick={() => returnBook(loan.id)} className="return-btn">
                    Return Book
                  </button>
                )}
              </article>
            );
          })
        ) : (
          <div className="no-results">No records in this section.</div>
        )}
      </div>
    </section>
  );
}
