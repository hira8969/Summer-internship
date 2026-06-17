package src.com;
import src.com.DAO.Employee;
import src.com.DAO.EmployeeDAO;

import java.lang.classfile.instruction.SwitchCase;
//import src.com.DATABASE.DBconnection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO ED = new EmployeeDAO();
        Scanner sc= new Scanner(System.in);
        System.out.println("Welcome to Employee Management System");


         while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Get Employee by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int insertid = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    Employee employee = new Employee(insertid, name, email, department);
                    ED.addEmployee(employee);
                    System.out.println("Employee added successfully!");
                    break;
                case 2:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    ED.DeleteEmployee(deleteId);
                    System.out.println("Employee deleted successfully!");
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();
                    System.out.print("Enter New Department: ");
                    String newDepartment = sc.nextLine();

                    Employee updatedEmployee = new Employee(updateId, newName, newEmail, newDepartment);
                    ED.UpdateEmployee(updatedEmployee);
                    System.out.println("Employee updated successfully!");
                    break;
                case 4:
                    System.out.print("Enter ID to retrieve: ");
                    int getId = sc.nextInt();
                    Employee retrievedEmployee = ED.getEmployeeById(getId);
                    if (retrievedEmployee != null) {
                        System.out.println("ID: " + retrievedEmployee.getId());
                        System.out.println("Name: " + retrievedEmployee.getName());
                        System.out.println("Email: " + retrievedEmployee.getEmail());
                        System.out.println("Department: " + retrievedEmployee.getDepartment());
                    } else {
                        System.out.println("Employee not found!");
                    }
            }
        }

        
    }
}
