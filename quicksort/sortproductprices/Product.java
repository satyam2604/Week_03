package Week_03.Day_03.quicksort.sortproductprices;

import java.util.Arrays;

public class Product {
    // Method to sort an array using QuickSort
    public static void quickSort(int[] prices, int low, int high) {
        if (low >= high) { // Base case: if the lower index is greater or equal to the higher index, return
            return;
        }

        // Define start and end indices
        int start = low;
        int end = high;
        int mid = start + (end - start) / 2; // Calculate the middle index
        int pivot = prices[mid]; // Choose the pivot as the middle element

        // Partitioning process
        while (start <= end) {
            // Move the left pointer to the right until an element greater than the pivot is found
            while (prices[start] < pivot) {
                start++;
            }
            // Move the right pointer to the left until an element smaller than the pivot is found
            while (prices[end] > pivot) {
                end--;
            }
            // Swap elements to place them in the correct partition
            if (start <= end) {
                int temp = prices[start];
                prices[start] = prices[end];
                prices[end] = temp;
                start++;
                end--;
            }
        }

        // Recursively sort the left and right subarrays
        quickSort(prices, low, end);
        quickSort(prices, start, high);
    }

    public static void main(String[] args) {
        // Create an array of product prices
        int[] prices = {500, 650, 456, 123, 457, 489, 654, 129, 102, 150, 200, 300, 400, 540, 350};

        System.out.println("Prices before sorting:");
        System.out.println(Arrays.toString(prices)); // Use Arrays.toString for better readability

        // Call QuickSort to sort the prices
        quickSort(prices, 0, prices.length - 1);

        System.out.println("Prices after sorting:");
        System.out.println(Arrays.toString(prices));
    }
}
