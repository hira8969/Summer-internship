export default function Members({ members, loans, setModal, openIssueModal }) {
  return (
    <section className="members">
      <div className="section-toolbar">
        <h2>Library Members</h2>
        <button type="button" onClick={() => setModal("member")}>Register Member</button>
      </div>

      <div className="members-list">
        {members.length > 0 ? (
          members.map((member) => {
            const memberLoans = loans.filter((loan) => loan.memberId === member.id);
            return (
              <article key={member.id} className="member-card">
                <div className="member-header">
                  <h3>{member.name}</h3>
                  <span className="member-id">{member.id}</span>
                </div>
                <div className="member-content">
                  <p><strong>Email:</strong> {member.email}</p>
                  <p><strong>Registration:</strong> {member.registrationNumber}</p>
                  <p><strong>Joined:</strong> {member.joined}</p>
                  <p><strong>Active Loans:</strong> {memberLoans.length}</p>
                  <button
                    type="button"
                    className="section-action-btn"
                    onClick={() => openIssueModal({ memberId: member.id })}
                  >
                    Issue Book
                  </button>
                </div>
              </article>
            );
          })
        ) : (
          <div className="no-results">No members registered yet.</div>
        )}
      </div>
    </section>
  );
}
