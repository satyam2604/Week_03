package Week_03.Day_01.singlilikedlist.studentrecordmanagement;

// Node class representing each student record
public class StudentNode {
    int rollNumber; // Roll Number of the student
    String name;    // Name of the student
    int age;        // Age of the student
    char grade;     // Grade of the student
    StudentNode next; // Pointer to the next node

    // Constructor to initialize the student node
    StudentNode(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null; // Initially, next is null
    }
}