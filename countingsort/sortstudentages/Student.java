package Week_03.Day_03.countingsort.sortstudentages;

import java.util.Arrays;

public class Student {
    // method to sort the ages of student using count sort
    public static void countSort(int[] ages){
        if(ages == null || ages.length <=1){ // if length of array is less than or equal to 1 return it
            return;
        }
        // find the maximum element of array
        int max = ages[0];
        for (int x: ages){
            if(max<x){
                max = x;
            }
        }
        // make an array of size largest element of array +1
        int[] countArray = new int[max+1];
        //increase the frequency of each number in the new frequency array to count frequency of each element
        for(int x: ages){
            countArray[x]++;
        }
        // initialize index variable with 0 to store values from starting index
        int index =0;
        // traverse an array through loop till it reaches max element
        for(int i=0; i<=max; i++){
            while(countArray[i]>0){ // continue the loop until the frequency of loop reaches 0
                ages[index] = i;
                index++; // increase index
                countArray[i]--;// decrease the frequency
            }
        }
    }

    public static void main(String[] args) {
        // create an array of ages of students
        int[] ages = {12,13,14,10,16,19,12,13,15,21,16,11};

        System.out.println("Ages of students before sorting:");
        System.out.println(Arrays.toString(ages)); // Use Arrays.toString for better readability

        // Call count Sort to sort the ages
        countSort(ages);

        System.out.println("Ages of students after sorting:");
        System.out.println(Arrays.toString(ages));
    }
}
