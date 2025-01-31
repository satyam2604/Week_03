package Week_03.Day_03.bubblesort.sortstudentmarks;

public class StudentMarks {
    // method to sort student marks using bubble sort
    public static int[] bubblesort(int marks[]){
        boolean swapped; // variable to check if elements get sorted in previous sort
        //outer loop to iterate through the arrays length
        for(int i = 0; i< marks.length; i++){
            swapped = false; // make it false after every pass
            // for each step, max item will come at the last respective index
            for(int j = 1; j< marks.length -i; j++){
                if(marks[j-1]> marks[j]){ // if previous mark is greater than current than swap it
                    int temp = marks[j-1];
                    marks[j-1] = marks[j];
                    marks[j] = temp;
                    swapped = true; // make it true after swapping
                }
            }
            System.out.println("Marks Before sorting: ");
            for(int x: marks){
                System.out.print(x+" ");
            }
            System.out.println();
            int result[] = bubblesort(marks);
            System.out.println("Marks after sorting: ");
            for(int x: result){
                System.out.print(x+" ");
            }        if(!swapped)break; // break the loop if no element is swapped in previous pass
        }
        return marks;
    }

    public static void main(String[] args) {
        // create an integer array where marks of students are stored
        int [] marks = {8,6,9,12,45,74,6,3,2,4,1,2};

    }
}
