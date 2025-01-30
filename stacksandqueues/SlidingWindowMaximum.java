package Week_03.Day_02.stacksandqueues; // Package declaration

import java.util.ArrayDeque; // Import ArrayDeque for deque operations
import java.util.Deque; // Import Deque interface

public class SlidingWindowMaximum { // Class declaration
    public int[] maxSlidingWindow(int[] nums, int k) { // Function to compute sliding window max
        // Edge case: If the input array is null or k is zero, return an empty array.
        if (nums == null || k == 0) {
            return new int[0];
        }

        int n = nums.length; // Get the length of the input array
        int[] result = new int[n - k + 1]; // Array to store max values of each sliding window
        Deque<Integer> deque = new ArrayDeque<>(); // Deque to store indices of elements

        // Iterate through each element in the array
        for (int i = 0; i < n; i++) {
            // Remove elements from the front of the deque if they are outside the current window
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll(); // Remove the index from the deque
            }

            // Remove elements from the back of the deque if they are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast(); // Remove the smaller element
            }

            // Add the current index to the deque
            deque.offer(i);

            // If we have processed at least k elements, store the max in the result array
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()]; // Front of deque contains max element
            }
        }
        return result; // Return the final array of max values
    }

    // Main function to test the implementation
    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum(); // Create an instance of the class

        // Example test case
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3; // Window size

        // Call the function to compute sliding window maximum
        int[] result = solution.maxSlidingWindow(nums, k);

        // Print the output
        System.out.println("Sliding Window Maximum: ");
        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
