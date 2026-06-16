package com.lms.Dao;

import com.lms.Util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MemberDao {

    Scanner sc = new Scanner(System.in);

    public void addMember() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Name : ");
            String name = sc.nextLine();

            System.out.print("Email : ");
            String email = sc.nextLine();

            String sql =
                    "insert into members(name,email) values(?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1,name);
            ps.setString(2,email);

            ps.executeUpdate();

            System.out.println("Member Added");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void viewMembers() {

        try {

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from members");

            while(rs.next()) {

                System.out.println(
                        rs.getInt("member_id")+" | "+
                                rs.getString("name")+" | "+
                                rs.getString("email")
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}