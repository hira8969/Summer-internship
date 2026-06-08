package org.example;

import org.example.dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        AppConfig.class);

        StudentDao dao =
                context.getBean(StudentDao.class);

        Scanner sc =
                new Scanner(System.in);

        while(true) {

            System.out.println("\n================================================");
            System.out.println("         STUDENT MANAGEMENT SYSTEM");
            System.out.println("================================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("================================================");
            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.println("\nAdd Student");

                    System.out.print("Enter ID : ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course : ");
                    String course = sc.nextLine();

                    dao.addStudent(id,name,course);
                    break;

                case 2:

                    dao.viewStudents();
                    break;

                case 3:

                    System.out.print("Enter Student ID : ");
                    id = sc.nextInt();

                    dao.searchStudent(id);
                    break;

                case 4:

                    System.out.print("Enter Student ID : ");
                    id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter New Name : ");
                    name = sc.nextLine();

                    System.out.print("Enter New Course : ");
                    course = sc.nextLine();

                    dao.updateStudent(
                            id,
                            name,
                            course);

                    break;

                case 5:

                    System.out.print("Enter Student ID : ");
                    id = sc.nextInt();

                    dao.deleteStudent(id);
                    break;

                case 6:

                    System.out.println("\nThank You ❤");
                    System.out.println("Exiting Application...");
                    System.exit(0);

                default:

                    System.out.println(" Invalid Choice");
            }
        }
    }
}