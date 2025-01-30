package Week_03.Day_02.hashmapsandhashfunctions;
import java.util.*;

public class LongestConsecutiveSequence {

    // Function to find the length of the longest consecutive elements sequence
    public static int longestConsecutive(int[] nums) {
        // HashSet to store the unique elements of the array
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        // Variable to track the longest sequence length
        int longestStreak = 0;

        // Traverse each element in the set
        for (int num : numSet) {
            // Check if num is the start of a sequence (num - 1 is not in set)
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Check for consecutive numbers in the sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // Update longest sequence length if a longer sequence is found
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2}; // Sample input array
        System.out.println("Longest Consecutive Sequence Length: " + longestConsecutive(nums)); // Call the function
    }
}
