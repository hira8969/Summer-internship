package com.lms.Entity;

public class IssueBook {

    private int issueId;
    private int memberId;
    private int bookId;

    public IssueBook() {}

    public IssueBook(int issueId,int memberId,int bookId) {
        this.issueId=issueId;
        this.memberId=memberId;
        this.bookId=bookId;
    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId=issueId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId=memberId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId=bookId;
    }
}