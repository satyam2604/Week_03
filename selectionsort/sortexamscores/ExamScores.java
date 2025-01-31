package Week_03.Day_03.selectionsort.sortexamscores;

import java.util.Arrays;

public class ExamScores {
    // method to sort exam scores using selection sort
    public static void selectionSort(int [] scores){
        for (int i=0; i< scores.length; i++){
            // find the max element from the array and swap it with last element
            int last = scores.length - i -1;
            int maxIndex = getMaxIndex(scores,0,last);
            // swap the elements which is maximum
            int temp = scores[last];
            scores[last] = scores[maxIndex];
            scores[maxIndex] = temp;
        }
    }

    // method to find the index of maximum element of array
    private static int getMaxIndex(int[] scores, int start, int end) {
        int max = start;
        for (int i=start; i<=end; i++){
            if(scores[max]<scores[i]){
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // an array which stores value of scores of students
        int [] scores = {78,80,89,87,65,98,88,54,45,66,77,83,64};
        System.out.println("Marks of student before sorting:");
        System.out.println(Arrays.toString(scores)); // Use Arrays.toString for better readability

        // Call selection sort to sort the scores
        selectionSort(scores);

        System.out.println("Prices after sorting:");
        System.out.println(Arrays.toString(scores));
    }
}
