package Week_03.Day_01.doublylinkedlist.librarymanagementsystem;

// Class representing a node in the doubly linked list
class BookNode {
    String bookTitle;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    BookNode next;
    BookNode prev;

    // Constructor to initialize a book node
    public BookNode(int bookId, String bookTitle, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}