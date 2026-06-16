package com.lms.Service;

import com.lms.Dao.BookDao;

public class BookService {

    BookDao dao = new BookDao();

    public void addBook() {
        dao.addBook();
    }

    public void viewBooks() {
        dao.viewBooks();
    }

    public void searchBook() {
        dao.searchBook();
    }

    public void deleteBook() {
        dao.deleteBook();
    }
}