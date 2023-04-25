import java.util.Scanner;

public class HomeScreen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // create an array to hold the inventory of books
        Book[] inventory = new Book[5];
        inventory[0] = new Book(1, "1234567890", "Java Programming");
        inventory[1] = new Book(2, "0987654321", "Introduction to Algorithms");
        inventory[2] = new Book(3, "1357924680", "The Art of Computer Programming");
        inventory[3] = new Book(4, "2468013579", "Clean Code");
        inventory[4] = new Book(5, "3692581470", "Design Patterns");

        while (true) {
            System.out.println("Welcome to the Neighborhood Library!");
            System.out.println("Please select an option:");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");

            // read user input from the scanner
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showAvailableBooks(scanner, inventory);  // call the method to show available books
                    break;
                case 2:
                    showCheckedOutBooks(scanner, inventory); // call the method to show checked out books
                    break;
                case 3:
                    System.out.println("Thank you for using the Neighborhood Library!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    // method to show available books
    public static void showAvailableBooks(Scanner scanner, Book[] inventory) {
        System.out.println("Available Books:");
        for (Book book : inventory) {
            if (!book.isCheckedOut()) {
                System.out.println(book.getId() + ". " + book.getIsbn() + " - " + book.getTitle());
            }
        }

        System.out.println("Enter the ID of the book you want to check out, or enter 0 to go back to the home screen");
        int bookId = scanner.nextInt();  // read user input from the scanner

        if (bookId == 0) {
            return;
        }

        for (Book book : inventory) {
            if (book.getId() == bookId) {   // find the book with the matching ID
                System.out.println("Enter your name:");
                scanner.nextLine(); // consume the remaining newline character from nextInt()
                String name = scanner.nextLine();
                book.checkOut(name);
                System.out.println("Thank you, " + name + "! The book " + book.getTitle() + " has been checked out.");
                return;
            }
        }

        System.out.println("Invalid book ID. Please try again.");
    }

    // method to show checked out books
    public static void showCheckedOutBooks(Scanner scanner, Book[] inventory) {
        System.out.println("Checked Out Books:");
        for (Book book : inventory) {
            if (book.isCheckedOut()) {
                System.out.println(book.getId() + ". " + book.getIsbn() + " - " + book.getTitle() + " (" + book.getCheckedOutTo() + ")");
            }
        }

        // ask the user if they want to check in a book or go back to the home screen
        System.out.println("Enter 'C' to check in a book, or 'X' to go back to the home screen");
        String choice = scanner.next();


        if (choice.equalsIgnoreCase("X")) {
            return;
        } else if (choice.equalsIgnoreCase("C")) {
            System.out.println("Enter the ID of the book you want to check in:");
            int bookId = scanner.nextInt();

            for (Book book : inventory) {
                if (book.getId() == bookId) {
                    book.checkIn();
                    System.out.println("Thank you! The book");
                }
            }
        }
    }
}