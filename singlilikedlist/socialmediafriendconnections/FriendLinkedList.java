package Week_03.Day_01.singlilikedlist.socialmediafriendconnections;

import java.util.HashSet;
import java.util.Set;

public class FriendLinkedList {
    private UserNode head;

    //Constructor to initialize linked list
    public FriendLinkedList() {
        this.head = null;
    }
    // Method to add new user to the linked list
    public void addUser(int userId, String name, int age){
        UserNode newUser = new UserNode(userId,name,age); // create a new user
        if(head == null){ // if the list is empty
            head= newUser; // set new user as head of the list
        }else{
            UserNode temp = head;//temporary pointer to traverse the list
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newUser; // add new user at the end of the list
        }
    }

    // Method to add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1); // Find the first user by ID
        UserNode user2 = findUserById(userId2); // Find the second user by ID

        if (user1 != null && user2 != null) { // Check if both users exist
            user1.friendIds.add(userId2); // Add user2's ID to user1's friend list
            user2.friendIds.add(userId1); // Add user1's ID to user2's friend list
        } else {
            System.out.println("One or both users not found."); // Print error message if users are not found
        }
    }

    // Method to remove a friend connection between two users
    public void removeFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1); // Find the first user by ID
        UserNode user2 = findUserById(userId2); // Find the second user by ID

        if (user1 != null && user2 != null) { // Check if both users exist
            user1.friendIds.remove(Integer.valueOf(userId2)); // Remove user2's ID from user1's friend list
            user2.friendIds.remove(Integer.valueOf(userId1)); // Remove user1's ID from user2's friend list
        } else {
            System.out.println("One or both users not found."); // Print error message if users are not found
        }
    }

    // Method to find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1); // Find the first user by ID
        UserNode user2 = findUserById(userId2); // Find the second user by ID

        if (user1 != null && user2 != null) { // Check if both users exist
            Set<Integer> mutualFriends = new HashSet<>(user1.friendIds); // Copy user1's friend IDs into a set
            mutualFriends.retainAll(user2.friendIds); // Retain only the common IDs between the two sets
            System.out.println("Mutual friends: " + mutualFriends); // Print the mutual friends
        } else {
            System.out.println("One or both users not found."); // Print error message if users are not found
        }
    }

    // Method to display all friends of a specific user
    public void displayFriends(int userId) {
        UserNode user = findUserById(userId); // Find the user by ID

        if (user != null) { // Check if the user exists
            System.out.println("Friends of " + user.name + ": " + user.friendIds); // Print the user's friends
        } else {
            System.out.println("User not found."); // Print error message if user is not found
        }
    }

    // Method to search for a user by Name or User ID
    public void searchUser(String name, int userId) {
        UserNode temp = head; // Temporary pointer to traverse the list
        while (temp != null) { // Traverse the list until the end
            if (temp.name.equals(name) || temp.userId == userId) { // Check if the name or ID matches
                System.out.println("User found: ID=" + temp.userId + ", Name=" + temp.name + ", Age=" + temp.age);
                return; // Exit the method after finding the user
            }
            temp = temp.next; // Move to the next node
        }
        System.out.println("User not found."); // Print error message if user is not found
    }

    // Method to count the number of friends for each user
    public void countFriends() {
        UserNode temp = head; // Temporary pointer to traverse the list
        while (temp != null) { // Traverse the list until the end
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friends."); // Print the friend count for each user
            temp = temp.next; // Move to the next node
        }
    }

    // Helper method to find a user by their User ID
    private UserNode findUserById(int userId) {
        UserNode temp = head; // Temporary pointer to traverse the list
        while (temp != null) { // Traverse the list until the end
            if (temp.userId == userId) { // Check if the User ID matches
                return temp; // Return the user if found
            }
            temp = temp.next; // Move to the next node
        }
        return null; // Return null if user is not found
    }

    // Main method to test the system
    public static void main(String[] args) {
        FriendLinkedList smfl = new FriendLinkedList(); // Create an instance of the system

        // Add users to the system
        smfl.addUser(1, "Alice", 25);
        smfl.addUser(2, "Bob", 30);
        smfl.addUser(3, "Charlie", 20);

        // Add friend connections
        smfl.addFriendConnection(1, 2);
        smfl.addFriendConnection(1, 3);

        // Display all friends of a user
        smfl.displayFriends(1);

        // Find mutual friends between two users
        smfl.findMutualFriends(1, 2);

        // Search for a user
        smfl.searchUser("Charlie", 0);

        // Count friends for each user
        smfl.countFriends();

        // Remove a friend connection
        smfl.removeFriendConnection(1, 2);

        // Display all friends of a user after removal
        smfl.displayFriends(1);
    }
}
