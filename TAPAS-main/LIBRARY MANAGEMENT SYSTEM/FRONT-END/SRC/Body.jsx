import Books from "./sections/Books";
import Dashboard from "./sections/Dashboard";
import Loans from "./sections/Loans";
import Members from "./sections/Members";

function Body({
  view,
  data,
  books,
  activeLoans,
  categories,
  category,
  search,
  setSearch,
  setCategory,
  setView,
  setModal,
  openIssueModal,
  deleteBook,
  notify,
  returnBook,
}) {
  const bookById = (id) => data.books.find((book) => book.id === id);
  const memberById = (id) => data.members.find((member) => member.id === id);
  const today = new Date().toISOString().slice(0, 10);
  const overdueCount = activeLoans.filter((loan) => loan.due < today).length;

  return (
    <div className="body-content">
      {view === "dashboard" && (
        <Dashboard
          data={data}
          activeLoans={activeLoans}
          overdueCount={overdueCount}
          bookById={bookById}
          memberById={memberById}
          setView={setView}
          setModal={setModal}
          openIssueModal={openIssueModal}
          notify={notify}
        />
      )}

      {view === "books" && (
        <Books
          books={books}
          categories={categories}
          category={category}
          setCategory={setCategory}
          search={search}
          setSearch={setSearch}
          openIssueModal={openIssueModal}
          deleteBook={deleteBook}
          notify={notify}
        />
      )}

      {view === "members" && (
        <Members
          members={data.members}
          loans={activeLoans}
          setModal={setModal}
          openIssueModal={openIssueModal}
        />
      )}

      {["loans", "returned", "not-returned"].includes(view) && (
        <Loans
          loans={
            view === "returned"
              ? data.loans.filter((loan) => loan.returned)
              : view === "not-returned"
                ? data.loans.filter((loan) => !loan.returned)
                : data.loans
          }
          title={
            view === "returned"
              ? "Returned Books"
              : view === "not-returned"
                ? "Books Not Returned"
                : "Issued Books"
          }
          bookById={bookById}
          memberById={memberById}
          returnBook={returnBook}
          openIssueModal={openIssueModal}
          today={today}
        />
      )}
    </div>
  );
}

export default Body;
