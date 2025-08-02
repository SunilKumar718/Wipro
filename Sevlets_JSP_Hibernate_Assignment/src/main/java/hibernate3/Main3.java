package hibernate3;

import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        AuthorBookDAO dao = new AuthorBookDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Management ---");
            System.out.println("1. Add Book with Authors");
            System.out.println("2. View All Books");
            System.out.println("3. Delete Book");
            System.out.println("4. Add Author");
            System.out.println("5. View All Authors");
            System.out.println("6. Update Book");
            System.out.println("7. Delete Author");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            int opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    Book book = new Book(title);
                    System.out.print("How many authors? ");
                    int count = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter author name: ");
                        String name = sc.nextLine();
                        Author author = new Author(name);
                        book.addAuthor(author);
                    }
                    dao.saveBook(book);
                    System.out.println("Saved.");
                    break;

                case 2:
                    List<Book> books = dao.getAllBooks();
                    for (Book b : books) {
                        System.out.println("\nBook: " + b.getTitle() + " [ID: " + b.getId() + "]");
                        for (Author a : b.getAuthors()) {
                            System.out.println("  Author: " + a.getName() + " [ID: " + a.getId() + "]");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter book ID to delete: ");
                    int bookId = sc.nextInt(); sc.nextLine();
                    Book delBook = dao.getBookById(bookId);
                    if (delBook != null) {
                        dao.deleteBook(delBook);
                        System.out.println("Deleted.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter author name: ");
                    String authName = sc.nextLine();
                    dao.saveAuthor(new Author(authName));
                    System.out.println("Author saved.");
                    break;

               

                case 6:
                    System.out.print("Enter author ID to delete: ");
                    int authorId = sc.nextInt(); sc.nextLine();
                    Author delAuthor = dao.getAuthorById(authorId);
                    if (delAuthor != null) {
                        dao.deleteAuthor(delAuthor);
                        System.out.println("Deleted.");
                    } else {
                        System.out.println("Author not found.");
                    }
                    break;
                case 7:
                    System.out.print("Enter book ID to update: ");
                    int bookIdToUpdate = sc.nextInt(); sc.nextLine();
                    Book bookToUpdate = dao.getBookById(bookIdToUpdate);

                    if (bookToUpdate != null) {
                        System.out.println("Current title: " + bookToUpdate.getTitle());
                        System.out.print("Enter new title (press Enter to keep the same): ");
                        String newTitle = sc.nextLine();
                        if (!newTitle.isEmpty()) {
                            bookToUpdate.setTitle(newTitle);
                        }

                        System.out.print("Do you want to update authors? (yes/no): ");
                        String choice = sc.nextLine();

                        if (choice.equalsIgnoreCase("yes")) {
                            bookToUpdate.getAuthors().clear();  // Remove old authors

                            System.out.print("How many new authors? ");
                            int n = sc.nextInt(); sc.nextLine();
                            for (int i = 0; i < n; i++) {
                                System.out.print("Enter author name: ");
                                String name = sc.nextLine();
                                Author author = new Author(name);
                                bookToUpdate.addAuthor(author);
                            }
                        }

                        dao.updateBook(bookToUpdate);
                        System.out.println("Book updated.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;


                case 0:
                    dao.closeFactory();
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
