package com.ems.dao;

import com.ems.entity.Employee;
import com.ems.util.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class EmployeeDao {

    Scanner sc = new Scanner(System.in);

    // Add Employee
    public void addEmployee() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Employee ID : ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name : ");
            String name = sc.nextLine();

            System.out.print("Enter Department : ");
            String dept = sc.nextLine();

            System.out.print("Enter Salary : ");
            double salary = sc.nextDouble();

            String sql =
                    "insert into employee(id,name,department,salary) values(?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, dept);
            ps.setDouble(4, salary);

            int row = ps.executeUpdate();

            if(row > 0) {
                System.out.println("Employee Added Successfully");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // View Employees
    public void viewEmployees() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "select * from employee";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\nEmployee List");

            while(rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("department") + " | " +
                                rs.getDouble("salary")
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // Search Employee
    public void searchEmployee() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Employee ID : ");
            int id = sc.nextInt();

            String sql =
                    "select * from employee where id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("department") + " | " +
                                rs.getDouble("salary")
                );
            }
            else {
                System.out.println("Employee Not Found");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // Update Employee
    public void updateEmployee() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Employee ID : ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Department : ");
            String dept = sc.nextLine();

            System.out.print("Enter New Salary : ");
            double salary = sc.nextDouble();

            String sql =
                    "update employee set department=?,salary=? where id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, dept);
            ps.setDouble(2, salary);
            ps.setInt(3, id);

            int row = ps.executeUpdate();

            if(row > 0)
                System.out.println("Updated Successfully");
            else
                System.out.println("Employee Not Found");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Employee
    public void deleteEmployee() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Employee ID : ");
            int id = sc.nextInt();

            String sql =
                    "delete from employee where id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            int row = ps.executeUpdate();

            if(row > 0)
                System.out.println("Deleted Successfully");
            else
                System.out.println("Employee Not Found");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}