package Week_03.Day_03.insertionsort.sortemloyeeids;

public class Employee {
    // method to sort employee id using insertion sort
    public static int[] insertionSort(int [] employeeId){
        int length = employeeId.length; // length of the array
        // outer loop will iterate till length -2
        for(int i=0; i<length-1; i++){
            // inner loop will iterate from i+1 and decrease when it is greater than 0
            for(int j=i+1; j>0; j--){
                if(employeeId[j-1]>employeeId[j]){
                    swap(employeeId,j, j-1); // call method to swap elements
                }else {
                    break;
                }
            }
        }
        return  employeeId;
    }
    // helping method to swap the elements
    public  static void swap(int [] arr,int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        // create an array of employee ids
        int employeeId[] = {102,105,106,189,150,120,101,103,121,123,162};
        System.out.println("IDs Before sorting: ");
        for(int x: employeeId){
            System.out.print(x+" ");
        }
        System.out.println();
        int result[] = insertionSort(employeeId);
        System.out.println("IDs after sorting: ");
        for(int x: result){
            System.out.print(x+" ");
        }
    }
}
