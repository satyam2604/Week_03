package Week_03.Day_02.hashmapsandhashfunctions;
import java.util.*;

public class TwoSumProblem {

    // Function to find two indices such that their values add up to the target
    public static int[] twoSum(int[] nums, int target) {
        // HashMap to store the index of each element
        Map<Integer, Integer> numMap = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Calculate the required number

            // Check if complement exists in the map
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i}; // Return indices if found
            }

            // Store the current number and its index in the map
            numMap.put(nums[i], i);
        }

        // Return empty array if no solution found
        return new int[]{};
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15}; // Sample input array
        int target = 9; // Target sum
        int[] result = twoSum(nums, target);

        // Print the result
        if (result.length == 2) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No pair found with the given sum.");
        }
    }
}
