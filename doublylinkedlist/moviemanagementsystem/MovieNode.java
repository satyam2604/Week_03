package Week_03.Day_01.doublylinkedlist.moviemanagementsystem;

public class MovieNode {
    String title; // title of movie
    String director; // movie's director
    int year; //movie's release year
    double rating; // movie's rating
    MovieNode next; // pointer to next node
    MovieNode prev; // pointer to previous node

    // Constructor to initialize movie node
    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null; //by default pointers are null
    }
}