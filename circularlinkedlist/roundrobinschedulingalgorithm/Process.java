package Week_03.Day_01.circularlinkedlist.roundrobinschedulingalgorithm;

public class Process {
    int processId;  // Unique identifier for each process
    int burstTime;  // Time required by the process to complete execution
    int remainingTime;  // Time left for execution after each round
    Process next;  // Pointer to the next process in the circular list

    // Constructor to initialize a process
    public Process(int processId, int burstTime) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime; // Initially, remaining time is equal to burst time
        this.next = null;
    }
}