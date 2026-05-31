package com.lms.Main;

import com.lms.Service.BookService;
import com.lms.Service.IssueBookService;
import com.lms.Service.MemberService;

import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BookService bookService = new BookService();
        MemberService memberService = new MemberService();
        IssueBookService issueService = new IssueBookService();

        while(true) {

            System.out.println("\n------- LIBRARY MANAGEMENT SYSTEM ------");

            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add Member");
            System.out.println("4. View Members");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Search Book");
            System.out.println("8. Delete Book");
            System.out.println("0. Exit");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:
                    bookService.addBook();
                    break;

                case 2:
                    bookService.viewBooks();
                    break;

                case 3:
                    memberService.addMember();
                    break;

                case 4:
                    memberService.viewMembers();
                    break;

                case 5:
                    issueService.issueBook();
                    break;

                case 6:
                    issueService.returnBook();
                    break;

                case 7:
                    bookService.searchBook();
                    break;

                case 8:
                    bookService.deleteBook();
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}