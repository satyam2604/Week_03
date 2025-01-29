package Week_03.Day_02.stacksandqueues;

import java.util.Stack;

public class QueueUsingTwoStacks {
    private Stack<Integer> firstStack; // Stack used for enqueue operations
    private Stack<Integer> secondStack; // Stack used for dequeue operations

    // Constructor to initialize the stacks
    public QueueUsingTwoStacks() {
        firstStack = new Stack<>();
        secondStack = new Stack<>();
    }

    // Method to add values to the queue
    public void enqueue(int value) {
        firstStack.push(value); // Push the value into the first stack
    }

    // Method to remove and return the front element from the queue
    public int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty"); // Handle underflow condition
        }

        // Transfer elements from firstStack to secondStack if secondStack is empty
        if (secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }

        return secondStack.pop(); // Pop the top element from secondStack (FIFO order)
    }

    // Method to get the front element without removing it
    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty"); // Handle underflow condition
        }

        // Transfer elements from firstStack to secondStack if secondStack is empty
        if (secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }

        return secondStack.peek(); // Return the top element from secondStack (FIFO order)
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return firstStack.isEmpty() && secondStack.isEmpty();
    }

    // Main function to test the implementation
    public static void main(String[] args) {
        try {
            QueueUsingTwoStacks queue = new QueueUsingTwoStacks();

            // Enqueue elements
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);

            // Peek the front element
            System.out.println("Front element: " + queue.peek());

            // Dequeue elements
            System.out.println("Dequeued: " + queue.dequeue());
            System.out.println("Dequeued: " + queue.dequeue());

            // Check if queue is empty
            System.out.println("Is queue empty? " + queue.isEmpty());

            // Dequeue last element
            System.out.println("Dequeued: " + queue.dequeue());

            // Check if queue is empty after all elements are removed
            System.out.println("Is queue empty? " + queue.isEmpty());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}