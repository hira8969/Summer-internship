package com.lms.Dao;

import com.lms.Util.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class BookDao {

    Scanner sc = new Scanner(System.in);

    public void addBook() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Book Name : ");
            String title = sc.nextLine();

            System.out.print("Author : ");
            String author = sc.nextLine();

            System.out.print("Quantity : ");
            int qty = sc.nextInt();

            String sql =
                    "insert into books(title,author,quantity) values(?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1,title);
            ps.setString(2,author);
            ps.setInt(3,qty);

            ps.executeUpdate();

            System.out.println("Book Added");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void viewBooks() {

        try {

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs =
                    st.executeQuery("select * from books");

            while(rs.next()) {

                System.out.println(
                        rs.getInt("book_id")+" | "+
                                rs.getString("title")+" | "+
                                rs.getString("author")+" | "+
                                rs.getInt("quantity")
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void searchBook() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Book Title to Search : ");
            String title = sc.nextLine();

            String sql = "select * from books where title like ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "%" + title + "%");

            ResultSet rs = ps.executeQuery();

            if(!rs.isBeforeFirst()) {
                System.out.println("No books found");
                return;
            }

            while(rs.next()) {

                System.out.println(
                        rs.getInt("book_id")+" | "+
                                rs.getString("title")+" | "+
                                rs.getString("author")+" | "+
                                rs.getInt("quantity")
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBook() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Book ID to Delete : ");
            int bookId = sc.nextInt();

            String sql = "delete from books where book_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, bookId);

            int result = ps.executeUpdate();

            if(result > 0) {
                System.out.println("Book Deleted Successfully");
            } else {
                System.out.println("Book not found");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}