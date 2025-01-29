package Week_03.Day_01.circularlinkedlist.taskscheduler;

public class TaskScheduler {
    private TaskNode head;
    private TaskNode tail;
    private TaskNode currentTask;

    // constructor to initialize empty list
    public TaskScheduler(){
        this.head = null;
        this.tail = null;
        this.currentTask = null;
    }

    // Method to add a task at the beginning of the circular list
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) { // If the list is empty
            head = tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    // Method to add a task at the end of the circular list
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (tail == null) { // If the list is empty
            head = tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Method to remove a task by Task ID
    public void removeTask(int taskId) {
        if (head == null) { // If the list is empty
            System.out.println("No tasks available to remove.");
            return;
        }
        TaskNode current = head;
        TaskNode prev = tail;
        do {
            if (current.taskId == taskId) {
                if (current == head) { // Removing the head node
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) { // Removing the tail node
                    tail = prev;
                    tail.next = head;
                } else { // Removing a node from the middle
                    prev.next = current.next;
                }
                System.out.println("Task with ID " + taskId + " removed successfully.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        System.out.println("Task not found.");
    }

    // Method to view the current task and move to the next task in the circular list
    public void viewAndMoveToNextTask() {
        if (currentTask == null) {
            currentTask = head;
        }
        if (currentTask != null) {
            System.out.println("Current Task: " + currentTask.taskName + " (Priority: " + currentTask.priority + ", Due: " + currentTask.dueDate + ")");
            currentTask = currentTask.next;
        } else {
            System.out.println("No tasks available.");
        }
    }

    // Method to display all tasks in the list starting from the head node
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        TaskNode current = head;
        System.out.println("Task List:");
        do {
            System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    // Method to search for tasks by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        TaskNode current = head;
        boolean found = false;
        do {
            if (current.priority == priority) {
                System.out.println("Found: " + current.taskName + " (Due: " + current.dueDate + ")");
                found = true;
            }
            current = current.next;
        } while (current != head);
        if (!found) System.out.println("No tasks found with priority: " + priority);
    }

    // Main method to test the system
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Adding tasks
        scheduler.addTaskAtBeginning(1, "Complete project", 2, "2025-02-15");
        scheduler.addTaskAtEnd(2, "Submit report", 1, "2025-02-20");
        scheduler.addTaskAtEnd(3, "Team meeting", 3, "2025-02-25");

        // Displaying tasks
        scheduler.displayTasks();

        // Viewing and moving to the next task
        scheduler.viewAndMoveToNextTask();
        scheduler.viewAndMoveToNextTask();

        // Searching by priority
        scheduler.searchByPriority(2);

        // Removing a task
        scheduler.removeTask(1);
        scheduler.displayTasks();
    }
}
