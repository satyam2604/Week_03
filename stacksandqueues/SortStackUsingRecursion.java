package Week_03.Day_02.stacksandqueues;

import java.util.Stack;

public class SortStackUsingRecursion {

    // Function to sort a stack using recursion
    public static Stack<Integer> sortStack(Stack<Integer> s) {
        // Base condition: If stack is empty or has only one element, it is already sorted
        if (s.isEmpty() || s.size() == 1) {
            return s;
        }

        // Remove the top element of the stack
        int top = s.pop();

        // Recursively sort the remaining stack
        sortStack(s);

        // Insert the removed element back in sorted order
        insert(top, s);

        return s;
    }

    // Helper function to insert an element into the sorted stack
    public static void insert(int element, Stack<Integer> s) {
        // Base condition: If stack is empty or the top element is greater than or equal to the current element
        if (s.isEmpty() || s.peek() >= element) {
            s.push(element);
            return;
        }

        // Remove the top element
        int top = s.pop();

        // Recursively call insert to place the element in the correct position
        insert(element, s);

        // Push the previously removed element back into the stack
        s.push(top);
    }

    // Main function to test the sorting function
    public static void main(String[] args) {
        // Creating a stack
        Stack<Integer> stack = new Stack<>();

        // Pushing elements into the stack
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        stack.push(40);

        // Displaying the original stack
        System.out.println("Original Stack: " + stack);
        System.out.println();

        // Sorting the stack using recursion
        Stack<Integer> sortedStack = sortStack(stack);

        // Displaying the sorted stack
        System.out.println("Sorted Stack (Ascending Order): " + sortedStack);
    }
}
