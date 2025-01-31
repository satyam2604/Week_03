package Week_03.Day_03.heapsort.sortjobapplicantsbysalary;

import java.util.Arrays;

public class JobApplicants {
    //method to sort an array of salary using heap sort
    public static void heapSort(int [] salary){
        int n = salary.length; // length of array
        // Build heap or we call it rearrange array
        for(int i= n/2-1; i>=0; i--){
            heapify(salary,n,i);
        }
        // one by one extract elements from heap
        for(int i=n-1; i>=0; i--){
            int temp = salary[0];
            salary[0] = salary[i];
            salary[i] = temp;
            // call max heapify on the reduced heap
            heapify(salary,i,0);
        }
    }
        // method to heapify a subtree rooted with node which is index of array salary
    private static void heapify(int[] salary, int n, int i) {
        int largest = i; // initialize largest as root
        int left = 2 * i +1;
        int right = 2 * i +2;
        // if the left child is larger than root
        if(left < n && salary[left]>salary[largest]){
            largest = left;
        }
        // if the right child is larger than largest so far
        if(right< n && salary[right]>salary[largest]){
            largest = right;
        }
        // if largest is not root
        if(largest != i){
            int temp= salary[i];
            salary[i] = salary[largest];
            salary[largest] =temp;

            // recursively heapify the affected sub-tree
            heapify(salary,n,largest);
        }
    }

    public static void main(String[] args) {
        // create an array containing salary of job applicants
        int [] salary = {500, 650, 456, 123, 457, 489, 654, 129, 102, 150, 200, 300, 400, 540, 350};
        System.out.println("Salary of job applicants before sorting:");
        System.out.println(Arrays.toString(salary)); // Use Arrays.toString for better readability

        // Call HeapSort to sort the salary
        heapSort(salary);

        System.out.println("Salary of job applicants after sorting:");
        System.out.println(Arrays.toString(salary));
    }
}
