package com.Dao.DATABASE;

import java.lang.reflect.Method;
import java.util.Scanner;
import com.Dao.Book;
import com.Dao.BookDao;

public class Main {
    public static void main(String[] args) {
        BookDao ED = new BookDao();
        Scanner sc= new Scanner(System.in);
        System.out.println("Welcome to Book Management System");


         while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book");
            System.out.println("3. Update Book");
            System.out.println("4. Get Book by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
                if (choice == 5) {
                    System.out.println("Exiting...");
                    break;
                }

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int insertid = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter SL.NO: ");
                    String sl_no = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine(); 

                    Book book = new Book(insertid, sl_no, author, price);
                    AddBook(ED, book);
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    DeleteBook(ED, deleteId);
                    System.out.println("Book deleted successfully!");
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter New SL.NO: ");
                    String newSl_no = sc.nextLine();
                    System.out.print("Enter New Author: ");
                    String newAuthor = sc.nextLine();
                    System.out.print("Enter New Price: ");
                    double newPrice = sc.nextDouble();
                    sc.nextLine();
                    Book updatedBook = new Book(updateId, newSl_no, newAuthor, newPrice);
                    UpdateBook(ED, updatedBook);
                    System.out.println("Book updated successfully!");
                    break;
                case 4:
                    System.out.print("Enter ID to retrieve: ");
                    int getId = sc.nextInt();
                    Book retrievedBook = GetBookById(ED, getId);
                    if (retrievedBook != null) {
                        System.out.println("ID: " + retrievedBook.getId());
                        System.out.println("SL.NO: " + retrievedBook.getSLNO());
                        System.out.println("AUTHER: " + retrievedBook.getAuthor());
                        System.out.println("PRICE: " + retrievedBook.getPrice());
                    } else {
                        System.out.println("Book not found!");
                    }
            }
        }

        
    }

    private static void AddBook(BookDao dao, Book book) {
        String[] methodNames = {"addBook", "insertBook", "saveBook", "createBook"};
        for (String methodName : methodNames) {
            try {
                Method method = dao.getClass().getMethod(methodName, Book.class);
                method.invoke(dao, book);
                return;
            } catch (NoSuchMethodException e) {
                // Try another candidate
            } catch (Exception e) {
                throw new RuntimeException("Failed to add book", e);
            }
        }
        throw new IllegalStateException("No add book method found on BookDao");
    }

    private static void DeleteBook(BookDao dao, int id) {
        String[] methodNames = {"deleteBook", "removeBook", "destroyBook"};
        for (String methodName : methodNames) {
            try {
                Method method = dao.getClass().getMethod(methodName, int.class);
                method.invoke(dao, id);
                return;
            } catch (NoSuchMethodException e) {
                
            } catch (Exception e) {
                throw new RuntimeException("Failed to delete book", e);
            }
        }
        throw new IllegalStateException("No delete book method found on BookDao");
    }

    private static void UpdateBook(BookDao dao, Book book) {
        String[] methodNames = {"updateBook", "modifyBook", "editBook", "saveBook"};
        for (String methodName : methodNames) {
            try {
                Method method = dao.getClass().getMethod(methodName, Book.class);
                method.invoke(dao, book);
                return;
            } catch (NoSuchMethodException e) {
                // Try another candidate
            } catch (Exception e) {
                throw new RuntimeException("Failed to update book", e);
            }
        }
        throw new IllegalStateException("No update book method found on BookDao");
    }

    private static Book GetBookById(BookDao dao, int id) {
        String[] methodNames = {"getBookById", "findBookById", "fetchBookById", "getBook", "findById"};
        for (String methodName : methodNames) {
            try {
                Method method = dao.getClass().getMethod(methodName, int.class);
                return (Book) method.invoke(dao, id);
            } catch (NoSuchMethodException e) {
                // Try another candidate
            } catch (Exception e) {
                throw new RuntimeException("Failed to retrieve book", e);
            }
        }
        throw new IllegalStateException("No get book by id method found on BookDao");
    }
}

