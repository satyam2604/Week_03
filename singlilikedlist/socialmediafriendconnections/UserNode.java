package Week_03.Day_01.singlilikedlist.socialmediafriendconnections;

import java.util.LinkedList;

public class UserNode {
    int userId; //  user Id
    String name; //  name
    int age; // user's age
    LinkedList<Integer> friendIds; // List of friend ID's
    UserNode next; // Pointer to the next node

    // constructor to initialize values to the Friend node
    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new LinkedList<>();
        this.next = null;
    }
}
