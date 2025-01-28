package Week_03.Day_01.singlilikedlist.studentrecordmanagement;
// Singly Linked List class to manage student records
public class StudentLinkedList {
    private StudentNode head; // Head of the list

    // Constructor to initialize the linked list
    StudentLinkedList() {
        this.head = null; // Initially, the list is empty
    }

    // Method to add a new student at the beginning of the list
    public void addAtBeginning(int rollNumber, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade); // Create a new node
        newNode.next = head; // Point the new node to the current head
        head = newNode; // Update the head to the new node
    }

    // Method to add a new student at the end of the list
    public void addAtEnd(int rollNumber, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade); // Create a new node
        if (head == null) { // If the list is empty
            head = newNode; // Make the new node the head
            return;
        }
        StudentNode temp = head; // Temporary node to traverse the list
        while (temp.next != null) { // Traverse to the end of the list
            temp = temp.next;
        }
        temp.next = newNode; // Point the last node to the new node
    }

    // Method to add a new student at a specific position in the list
    public void addAtPosition(int position, int rollNumber, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade); // Create a new node
        if (position == 1) { // If the position is the beginning
            newNode.next = head; // Point the new node to the current head
            head = newNode; // Update the head to the new node
            return;
        }
        StudentNode temp = head; // Temporary node to traverse the list
        for (int i = 1; i < position - 1 && temp != null; i++) { // Traverse to the desired position
            temp = temp.next;
        }
        if (temp == null) { // If the position is out of bounds
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = temp.next; // Point the new node to the next node
        temp.next = newNode; // Update the previous node to point to the new node
    }

    // Method to delete a student by roll number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) { // If the list is empty
            System.out.println("List is empty");
            return;
        }
        if (head.rollNumber == rollNumber) { // If the head is to be deleted
            head = head.next; // Update the head to the next node
            return;
        }
        StudentNode temp = head; // Temporary node to traverse the list
        while (temp.next != null && temp.next.rollNumber != rollNumber) { // Traverse the list to find the node to delete
            temp = temp.next;
        }
        if (temp.next == null) { // If the roll number is not found
            System.out.println("Student with Roll Number " + rollNumber + " not found");
            return;
        }
        temp.next = temp.next.next; // Update the pointer to skip the node to be deleted
    }

    // Method to search for a student by roll number
    public void searchByRollNumber(int rollNumber) {
        StudentNode temp = head; // Temporary node to traverse the list
        while (temp != null) { // Traverse the list
            if (temp.rollNumber == rollNumber) { // If the roll number matches
                System.out.println("Student Found: Roll Number: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next; // Move to the next node
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found"); // If the roll number is not found
    }

    // Method to display all student records
    public void displayAll() {
        if (head == null) { // If the list is empty
            System.out.println("No records to display");
            return;
        }
        StudentNode temp = head; // Temporary node to traverse the list
        while (temp != null) { // Traverse the list
            System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next; // Move to the next node
        }
    }

    // Method to update a student's grade by roll number
    public void updateGrade(int rollNumber, char newGrade) {
        StudentNode temp = head; // Temporary node to traverse the list
        while (temp != null) { // Traverse the list
            if (temp.rollNumber == rollNumber) { // If the roll number matches
                temp.grade = newGrade; // Update the grade
                System.out.println("Grade updated for Roll Number " + rollNumber);
                return;
            }
            temp = temp.next; // Move to the next node
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found"); // If the roll number is not found
    }

    // Main method to test the program
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList(); // Create a new linked list

        // Add some student records
        list.addAtBeginning(1, "Peter", 20, 'A');
        list.addAtEnd(2, "Shaun", 19, 'B');
        list.addAtPosition(2, 3, "Chris", 21, 'A');

        // Display all records
        System.out.println("Student Records:");
        list.displayAll();

        // Search for a student
        System.out.println("\nSearching for Roll Number 2:");
        list.searchByRollNumber(2);

        // Update a student's grade
        System.out.println("\nUpdating Grade for Roll Number 1:");
        list.updateGrade(1, 'A');

        // Display all records after update
        System.out.println("\nStudent Records after Grade Update:");
        list.displayAll();

        // Delete a student
        System.out.println("\nDeleting Roll Number 3:");
        list.deleteByRollNumber(3);

        // Display all records after deletion
        System.out.println("\nStudent Records after Deletion:");
        list.displayAll();
    }
}
