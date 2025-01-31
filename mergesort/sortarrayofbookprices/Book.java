package Week_03.Day_03.mergesort.sortarrayofbookprices;

import java.util.Arrays;

public class Book {
    // method to recursively sort two sub-arrays
    public static int[] mergeSort(int [] prices){
        // base case if length of array is 1 return it
        if(prices.length ==1){
            return prices;
        }
        // find mid-element of array to divide it
        int mid = prices.length/2;

        // make two sub arrays and copy elements from prices array and recursively call it
        int left[] = mergeSort(Arrays.copyOfRange(prices,0,mid));
        int right[] = mergeSort(Arrays.copyOfRange(prices,mid,prices.length));
        return merge(left,right);
    }

    // method to merge two arrays after sorting them independently
    private static int[] merge(int[] left, int[] right) {
        int result[]= new int[left.length+ right.length]; // final array which will contain sorted values
        // make pointers to iterate over arrays
        int i=0,j=0,k=0;
        while(i< left.length&& j< right.length){
            if(left[i]<right[j]){
                result[k] = left[i];
                i++;
                k++;
            }else{
                result[k] = right[j];
                j++;
                k++;
            }
        }

        // in some cases if some values are left in sub-arrays
        while(i< left.length){
            result[k] = left[i]; i++;k++;
        }
        while(j< right.length){
            result[k] = right[j]; j++;k++;
        }
        return result;
    }

    public static void main(String[] args) {
        // make an array that contain price of books
        int [] prices = {500,650,456,123,457,489,654,129,102,150,200,300,400,540,350};

        System.out.println("Price of books before sorting: ");
        for(int x: prices){
            System.out.print(x+" ");
        }
        System.out.println();
        int result[] = mergeSort(prices);
        System.out.println("Price of books after sorting: ");
        for(int x: result){
            System.out.print(x+" ");
        }
    }
}
