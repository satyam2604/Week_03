package Week_03.Day_02.stacksandqueues;

import java.util.Stack;

public class StockSpan {

    // Functions to calculate stock span problem
    public static int[] calculateSpan(int [] prices){
        int n = prices.length; // number of days
        int[] span = new int[n]; // Array to store span value for each day
        Stack<Integer> stack = new Stack<>(); // Stack store indices o prices

        // iterate through each day's price
        for(int i=0; i<n;i++){
            // pop elements from stack while stack is not empty and price at the top of stack is less than or equal to current price
            while(!stack.isEmpty() && prices[stack.peek()]<=prices[i]){
                stack.pop();
            }

            // if the stack becomes empty it means no greater price on the left
            if(stack.isEmpty()){
                span[i] = i+1;
            }else{
                span[i]= i-stack.peek();
            }
            // push the current day's index onto the stack
            stack.push(i);
        }
        return span; // return the final compounded span array
    }

    public static void main(String[] args) {
        //create an array to represent stock prices
        int [] prices = {100,80,60,75,45,65,89,66};

        // call the function to compute span values
        int [] span = calculateSpan(prices);

        //display stock prices:
        System.out.println("Stock prices: ");
        for(int x: prices){
            System.out.print(x+" ");
        }
        System.out.println();
        // display the computed stock span values
        System.out.println("Stock span: ");
        for(int x: span){
            System.out.print(x+ " ");
        }
        System.out.println();
    }
}
