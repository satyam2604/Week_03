package Week_03.Day_01.circularlinkedlist.roundrobinschedulingalgorithm;
import java.util.Scanner;
public class RoundRobinMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the time quantum: ");
        int timeQuantum = scanner.nextInt();

        RoundRobinScheduler scheduler = new RoundRobinScheduler(timeQuantum);

        // Adding processes
        scheduler.addProcess(1, 10);
        scheduler.addProcess(2, 5);
        scheduler.addProcess(3, 8);

        // Executing processes
        scheduler.executeProcesses();

        scanner.close();
    }
}
