package com.ems.service;

import com.ems.dao.EmployeeDao;

import java.util.Scanner;

public class EmployeeService {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeDao dao = new EmployeeDao();

        int choice;

        do {

            System.out.println("\n===== EMPLOYEE MANAGEMENT =====");

            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    dao.addEmployee();
                    break;

                case 2:
                    dao.viewEmployees();
                    break;

                case 3:
                    dao.searchEmployee();
                    break;

                case 4:
                    dao.updateEmployee();
                    break;

                case 5:
                    dao.deleteEmployee();
                    break;

                case 6:
                    System.out.println("Thank You...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while(choice != 6);
    }
}