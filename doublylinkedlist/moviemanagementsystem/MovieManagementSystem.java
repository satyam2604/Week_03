package Week_03.Day_01.doublylinkedlist.moviemanagementsystem;

public class MovieManagementSystem {
    private MovieNode head;
    private MovieNode tail;

    // Constructor to initialize an empty list
    public MovieManagementSystem() {
        this.head = null;
        this.tail = null;
    }

    // Method to add movie at the beginning of the list
    public void addMovieAtBeginning(String title, String director, int year, double rating){
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if(head == null){ // if the list is empty
            head = tail = newNode;
        }else{
            newNode.next =head;
            head.prev = newNode;
            head = newNode;
        }
    }

    //Method to add movie at the end of the list
    public void addMovieAtEnd(String title, String director, int year, double rating){
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if(tail == null){
            head = tail = newNode;
        }else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Method to remove movie by title
    public void removeMovie(String title){
        MovieNode current = head;
        while(current != null){
            if(current.title.equalsIgnoreCase(title)){
                if(current == head){ // removing head node
                    head = head.next;
                    if(head!=null) head.prev = null;
                } else if (current == tail) { // removing tail node
                    tail = tail.prev;
                    if(tail!= null) tail.next = null;
                }else{ // removing node from middle
                    current.prev.next =current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Movie: "+ title+ " removed successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found!!");
    }

    // Movie to search for movies by director
    public void searchByDirector(String director){
        MovieNode current = head;
        boolean found = false;
        while(current != null){
            if(current.director.equalsIgnoreCase(director)){
                System.out.println("Found: "+ current.title+ " ("+ current.year+ ") - Rating: "+ current.rating);
                found = true;
            }
            current = current.next;
        }
        if(!found){
            System.out.println("No movies found by the director: "+ director);
        }
    }

    // Method to search movies by rating
    public void searchByRating(double rating){
        MovieNode current = head;
        boolean found = false;
        while(current != null){
            if(current.rating == rating){
                System.out.println("Found: "+ current.title+ " by "+ current.director+ " ("+ current.year+")");
                found = true;
            }
            current = current.next;
        }
        if(!found) System.out.println("No movies found with rating: "+ rating);
    }

    // Method to update rating of a movie
    public void updateRating(String title, double newrating){
        MovieNode current = head;
        while(current !=null){
            if(current.title.equalsIgnoreCase(title)){
                current.rating = newrating;
                System.out.println("Rating update successfully");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found");
    }

    // Method to display all movies in forward order
    public void displayMoviesForward(){
        MovieNode current = head;
        if(current == null){
            System.out.println("No movies available");
            return;
        }
        System.out.println("Movie List in Forward Order");
        while (current!= null){
            System.out.println(current.title + " ("+ current.year+") - "+ current.director+" - Rating: "+ current.rating);
            current = current.next;
        }
    }

    // Method to display movies in reverse order
    public void displayMoviesReverse(){
        MovieNode current = tail;
        if(current == null){
            System.out.println("No movies available");
            return;
        }
        System.out.println("Movie List in Reverse Order");
        while (current!= null){
            System.out.println(current.title + " ("+ current.year+") - "+ current.director+" - Rating: "+ current.rating);
            current = current.prev;
        }
    }

    // Main method
    public static void main(String[] args) {
        MovieManagementSystem mms = new MovieManagementSystem();

        // adding some movies
        mms.addMovieAtBeginning("Avengers Endgame", "Russo Brothers", 2019, 5);
        mms.addMovieAtEnd("Avengers Infinity War", "Russo Brothers", 2018, 4.8);
        mms.addMovieAtEnd("Spider-Man No Way Home", "John Watts", 2021, 4.9);

        // displaying movies in forward and reverse order
        mms.displayMoviesForward();
        System.out.println();
        mms.displayMoviesReverse();
        System.out.println();

        // searching movies
        mms.searchByDirector("Russo Brothers");
        mms.searchByRating(4.9);
        System.out.println();

        // updating rating
        mms.updateRating("Spider-Man No Way Home", 4.8);
        mms.displayMoviesForward();
        System.out.println();

        // removing a movie
        mms.removeMovie("Avengers Infinity War");
        mms.displayMoviesForward();
        System.out.println();
    }
}