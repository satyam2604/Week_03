package Week_03.Day_02.hashmapsandhashfunctions;

import java.util.*;

public class PairWithGivenSum {

    // Function to check if a pair with the given sum exists
    public static boolean hasPairWithSum(int[] arr, int target) {
        // HashSet to store the visited numbers
        Set<Integer> seenNumbers = new HashSet<>();

        // Traverse the array
        for (int num : arr) {
            // Calculate the required number to form the target sum
            int complement = target - num;

            // Check if the complement exists in the set
            if (seenNumbers.contains(complement)) {
                System.out.println("Pair found: (" + num + ", " + complement + ")");
                return true;
            }

            // Add the current number to the set
            seenNumbers.add(num);
        }

        // If no pair is found, return false
        System.out.println("No pair with the given sum found.");
        return false;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7}; // Sample input array
        int target = 17; // Target sum

        hasPairWithSum(arr, target); // Call the function
    }
}
