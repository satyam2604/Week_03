package Week_03.Day_02.hashmapsandhashfunctions;
import java.util.*;

public class SubArrayWithZeroSum {

    // Function to find all subarrays with zero sum
    public static void findZeroSumSubarrays(int[] arr) {
        // HashMap to store the cumulative sum and its list of indices
        Map<Integer, List<Integer>> map = new HashMap<>();

        // List to store the result (pairs of start and end indices of subarrays)
        List<int[]> result = new ArrayList<>();

        // Variable to store cumulative sum
        int sum = 0;

        // Add a base case: sum 0 at index -1 (to handle cases where sum becomes zero at any index)
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Update the cumulative sum
            sum += arr[i];

            // Check if the sum has been seen before
            if (map.containsKey(sum)) {
                // Retrieve the list of indices where this sum was previously found
                List<Integer> indices = map.get(sum);

                // Iterate over the indices and add subarrays to the result
                for (int start : indices) {
                    result.add(new int[]{start + 1, i}); // Store subarray start and end indices
                }
            }

            // Add the current index to the list of indices for this sum
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        // Print all found subarrays
        if (result.isEmpty()) {
            System.out.println("No subarrays with zero sum found.");
        } else {
            System.out.println("Subarrays with zero sum:");
            for (int[] range : result) {
                System.out.println("Start: " + range[0] + ", End: " + range[1]);
            }
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 6, -3, 2, -2, 4, -4}; // Sample input array
        findZeroSumSubarrays(arr); // Call the function
    }
}
