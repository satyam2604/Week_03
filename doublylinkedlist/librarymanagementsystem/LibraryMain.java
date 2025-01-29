package Week_03.Day_01.doublylinkedlist.librarymanagementsystem;

public class LibraryMain {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        // Adding books
        library.addBookAtBeginning(1, "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", true);
        library.addBookAtEnd(2, "1984", "George Orwell", "Dystopian", true);

        // Display books
        library.displayBooksForward();

        // Search for a book
        library.searchBook("1984");

        // Update availability
        library.updateAvailability(2, false);

        // Remove a book
        library.removeBook(1);

        // Display books again
        library.displayBooksForward();
    }
}
