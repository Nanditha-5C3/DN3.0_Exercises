package libraryManagementSystem;

import java.util.Arrays;
import java.util.Scanner;

public class LibraryManager {

    // Book class
    public static class Book {
        private int bookId;
        private String title;
        private String author;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public int getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "bookId=" + bookId +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }
    }

    private static Book[] libraryCollection = {
            new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book(2, "To Kill a Mockingbird", "Harper Lee"),
            new Book(3, "1984", "George Orwell"),
            new Book(4, "Pride and Prejudice", "Jane Austen"),
            new Book(5, "Moby Dick", "Herman Melville")
    };

    // Linear Search
    public static void linearSearch(String title) {
        for (Book book : libraryCollection) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book);
                return;
            }
        }
        System.out.println("Book with title '" + title + "' not found.");
    }

    // Binary Search (requires sorted array by title)
    public static void binarySearch(String title) {
        // Ensure libraryCollection is sorted by title
        Book[] sortedLibrary = Arrays.copyOf(libraryCollection, libraryCollection.length);
        Arrays.sort(sortedLibrary, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));

        int left = 0;
        int right = sortedLibrary.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = sortedLibrary[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                System.out.println("Book found: " + sortedLibrary[mid]);
                return;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Book with title '" + title + "' not found.");
    }

    // Main method to interact with the LibraryManager
    public static void main(String[] args) {
        Scanner scanVar = new Scanner(System.in);

        while (true) {
            System.out.println("----- Library Management System -----");
            System.out.println("1. Search Book by Title (Linear Search)");
            System.out.println("2. Search Book by Title (Binary Search)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanVar.nextInt();
            scanVar.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    String linearTitle = scanVar.nextLine();
                    linearSearch(linearTitle);
                    break;
                case 2:
                    System.out.print("Enter Book Title: ");
                    String binaryTitle = scanVar.nextLine();
                    binarySearch(binaryTitle);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanVar.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
