package com.lms.Service;

import com.lms.Dao.IssueBookDao;

public class IssueBookService {

    IssueBookDao dao = new IssueBookDao();

    public void issueBook() {
        dao.issueBook();
    }

    public void returnBook() {
        dao.returnBook();
    }
}