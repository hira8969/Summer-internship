package com.lms.Dao;

import com.lms.Util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class IssueBookDao {

    Scanner sc = new Scanner(System.in);

    public void issueBook() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Member Id : ");
            int memberId = sc.nextInt();

            System.out.print("Book Id : ");
            int bookId = sc.nextInt();

            String sql =
                    "insert into issue_books(member_id,book_id) values(?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1,memberId);
            ps.setInt(2,bookId);

            ps.executeUpdate();

            System.out.println("Book Issued");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void returnBook() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Issue Book ID : ");
            int issueId = sc.nextInt();

            String sql = "delete from issue_books where issue_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, issueId);

            int result = ps.executeUpdate();

            if(result > 0) {
                System.out.println("Book Returned Successfully");
            } else {
                System.out.println("Issue record not found");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}