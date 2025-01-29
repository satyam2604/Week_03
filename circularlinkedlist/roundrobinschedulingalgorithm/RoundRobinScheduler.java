package Week_03.Day_01.circularlinkedlist.roundrobinschedulingalgorithm;

public class RoundRobinScheduler {
    private Process head;  // Head of the circular linked list
    private Process tail;  // Tail of the circular linked list
    private int timeQuantum;  // Fixed time slice for each process

    // Constructor to initialize the scheduler with a given time quantum
    public RoundRobinScheduler(int timeQuantum) {
        this.head = null;
        this.tail = null;
        this.timeQuantum = timeQuantum;
    }

    // Method to add a new process at the end of the circular linked list
    public void addProcess(int processId, int burstTime) {
        Process newProcess = new Process(processId, burstTime);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head; // Making the list circular
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
        System.out.println("Process " + processId + " added.");
    }

    // Method to execute the processes in a round-robin fashion
    public void executeProcesses() {
        if (head == null) {
            System.out.println("No processes to execute.");
            return;
        }

        int totalTime = 0; // Keeps track of total execution time
        int completedProcesses = 0; // Counts the number of completed processes
        int totalProcesses = countProcesses(); // Total number of processes

        System.out.println("Executing processes in Round Robin order:");
        Process current = head;
        while (completedProcesses < totalProcesses) {
            if (current.remainingTime > 0) {
                int executionTime = Math.min(timeQuantum, current.remainingTime);
                System.out.println("Executing Process " + current.processId + " for " + executionTime + " units");

                current.remainingTime -= executionTime;
                totalTime += executionTime;

                if (current.remainingTime == 0) {
                    System.out.println("Process " + current.processId + " completed.");
                    completedProcesses++;
                }
            }
            current = current.next; // Move to the next process
        }

        System.out.println("All processes executed in " + totalTime + " time units.");
    }

    // Method to count the total number of processes in the circular list
    private int countProcesses() {
        if (head == null) return 0;
        int count = 0;
        Process current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }
}