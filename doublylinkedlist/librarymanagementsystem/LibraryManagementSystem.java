package Week_03.Day_01.doublylinkedlist.librarymanagementsystem;

public class LibraryManagementSystem {
    private BookNode head;
    private BookNode tail;
    private int bookCount;

    // Constructor to initialize an empty list
    public LibraryManagementSystem() {
        head = null;
        tail = null;
        bookCount = 0;
    }

    // Method to add a book at the beginning of the doubly linked list
    public void addBookAtBeginning(int bookId, String bookTitle, String author, String genre, boolean isAvailable) {
        BookNode newNode = new BookNode(bookId, bookTitle, author, genre, isAvailable);
        if (head == null) { // If the list is empty
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        bookCount++;
    }

    // Method to add a book at the end of the doubly linked list
    public void addBookAtEnd(int bookId, String bookTitle, String author, String genre, boolean isAvailable) {
        BookNode newNode = new BookNode(bookId, bookTitle, author, genre, isAvailable);
        if (tail == null) { // If the list is empty
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        bookCount++;
    }

    // Method to remove a book by Book ID
    public void removeBook(int bookId) {
        if (head == null) {
            System.out.println("No books available to remove.");
            return;
        }
        BookNode current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                if (current == head) { // Removing the head node
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (current == tail) { // Removing the tail node
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else { // Removing a node from the middle
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                bookCount--;
                System.out.println("Book with ID " + bookId + " removed successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found.");
    }

    // Method to search for a book by Book Title or Author
    public void searchBook(String query) {
        if (head == null) {
            System.out.println("No books available.");
            return;
        }
        BookNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.bookTitle.equalsIgnoreCase(query) || current.author.equalsIgnoreCase(query)) {
                System.out.println("Found: " + current.bookTitle + " by " + current.author + " (Genre: " + current.genre + ", Available: " + current.isAvailable + ")");
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No book found with the given query.");
    }

    // Method to update a book’s Availability Status
    public void updateAvailability(int bookId, boolean newStatus) {
        if (head == null) {
            System.out.println("No books available.");
            return;
        }
        BookNode current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = newStatus;
                System.out.println("Book availability updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found.");
    }

    // Method to display all books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("No books available.");
            return;
        }
        BookNode current = head;
        System.out.println("Library Books:");
        while (current != null) {
            System.out.println("Book ID: " + current.bookId + ", Title: " + current.bookTitle + ", Author: " + current.author + ", Genre: " + current.genre + ", Available: " + current.isAvailable);
            current = current.next;
        }
    }

    // Method to display all books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("No books available.");
            return;
        }
        BookNode current = tail;
        System.out.println("Library Books (Reverse Order):");
        while (current != null) {
            System.out.println("Book ID: " + current.bookId + ", Title: " + current.bookTitle + ", Author: " + current.author + ", Genre: " + current.genre + ", Available: " + current.isAvailable);
            current = current.prev;
        }
    }

    // Method to count the total number of books
    public int countBooks() {
        return bookCount;
    }
}
