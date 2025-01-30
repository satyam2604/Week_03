package Week_03.Day_02.stacksandqueues;

public class CircularTourProblem {
    // method to find starting point for completing circular tour
    public static int canCompleteCircuit(int [] petrol, int[] distance){
        int position =0; // give position as starting point of tour
        int sum = 0; // sum as cost between petrol and distance
        int total = 0; // total distance and petrol consumed

        for(int i=0; i<distance.length && i<petrol.length; i++){ // iterate through last index of array
            sum += petrol[i] - distance[i]; //
            if(sum<0){ // if left petrol is less than 0
                total += sum; // add sum to total to calculate total petrol needed to travel
                sum =0; // distance between every index and petrol consumed is different
                position = i+1; // next index should be position
            }
        }
        total += sum; // if above condition fails then last petrol should be added here
        return total>=0?position:-1; // if difference between petrol consumed and distance is greater than or equal to 0 than return position else return -1
    }

    public static void main(String[] args) {
        // Define an array of total petrol to refuel at each step
        int[] petrol1 = {1,2,3,4,5};
        int[] petrol2 = {2,3,4};

        //  define an array of total distance to travel at each step
        int [] distance1 = {3,4,5,1,2};
        int [] distance2 = {3,4,3};

        // call method to find starting point of the circular two
        int result1 = canCompleteCircuit(petrol1,distance1);
        int result2 = canCompleteCircuit(petrol2,distance2);

        System.out.println("Petrol filling at each index: ");
        for (int x: petrol1){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("Distance to next step: ");
        for(int x: distance1){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("Starting point of circle: "+ result1);
        System.out.println("Petrol filling at each index: ");
        for (int x: petrol2){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("Distance to next step: ");
        for(int x: distance2){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("Starting point of circle: "+ result2);
    }
}
