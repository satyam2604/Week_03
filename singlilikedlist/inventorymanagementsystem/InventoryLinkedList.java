package Week_03.Day_01.singlilikedlist.inventorymanagementsystem;

public class InventoryLinkedList {
    private InventoryNode head; // head of the list

    // Constructor to initialize linked list
    public InventoryLinkedList() {
        this.head = null; // Initially list is empty
    }

    // Method to add a new inventory at the beginning of the list
    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price); // Create a new Node
        newNode.next = head; // Point the new Node to the Current Node
        head = newNode; // Update the head to the new Node
    }

    // Method to add a new Inventory at the end of the list
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price); // Create a new Node
        if (head == null) { // if list is empty
            head = newNode; // Make the new Node Head
            return;
        }
        InventoryNode temp = head; // Temporary node to traverse the list
        while (temp.next != null) { // Traverse to the end of the list
            temp = temp.next;
        }
        temp.next = newNode; // Point the last node the new node
    }

    // Method to add a new Inventory at the specific position in the list
    public void addAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price); // Create a new Node
        if (position == 1) { // If the position is at beginning
            newNode.next = head; // Point the new Node to the current Node
            head = newNode; // Update the head to the new Node
            return;
        }
        InventoryNode temp = head; // Temporary node to the traverse the list
        for (int i = 1; i < position - 1 && temp != null; i++) { // Traverse to the desired position
            temp = temp.next;
        }
        if (temp == null) { // If the position is out of bounds
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = temp.next; // point the new node to the next node
        temp.next = newNode;     // update the previous node to the new Node
    }

    // Method to delete an Inventory by itemId
    public void deleteByItemId(int itemId) {
        if (head == null) { // if list is empty
            System.out.println("List is empty!!!!");
            return;
        }
        if (head.itemId == itemId) { // if head is to be deleted
            head = head.next; // update the head to the next Node
            return;
        }
        InventoryNode temp = head; // temporary node to traverse the list
        while (temp.next != null && temp.itemId != itemId) { // traverse the list to find the node to delete
            temp = temp.next;
        }
        if (temp.next == null) { // if the roll number is not found
            System.out.println("Inventory with item ID: " + itemId + " not Found!!!");
            return;
        }
        temp.next = temp.next.next; // update to the pointer to skip the node to delete
    }

    // Method to search for an inventory by item ID
    public void searchByItemId(int itemId) {
        InventoryNode temp = head; // temporary node to traverse the list
        while (temp != null) {// traverse the list
            if (temp.itemId == itemId) { // inventory is found
                System.out.println("Item Name: " + temp.itemName + ", Item ID: " + temp.itemId + ", Quantity: " + temp.quantity + " & Price: " + temp.price);
                return;
            }
            temp = temp.next;// Move to the next Node
        }
        System.out.println("Student with item ID: " + itemId + " not found!!");
    }

    // Method to display all inventory records
    public void displayAll() {
        if (head == null) {// if the list is empty
            System.out.println("No record to display");
            return;
        }
        InventoryNode temp = head; // Temporary node to traverse the list
        while (temp != null) { // Traverse the list
            System.out.println("Item Name: " + temp.itemName + ", Item ID: " + temp.itemId + ", Quantity: " + temp.quantity + " & Price: " + temp.price);
            temp = temp.next; // move to the next node
        }
    }

    // Method to update quantity of an item by item ID
    public void updateQuantity(int quantity, int itemId){
        InventoryNode temp = head; // temporary node to traverse the list
        while(temp!=null){
            if(temp.itemId == itemId){
                temp.quantity = quantity;
                System.out.println("Quantity update for itemId: "+ itemId);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Inventory with item ID: "+ itemId + " not found!"); // if the roll number is not found
    }

    // Method to calculate and display total value of inventory
    public void calculateTotalValue(){
        double totalValue = 0; // variable to score total value
        InventoryNode temp = head; // temporary node to traverse the list
        while(temp!=null){
            totalValue+= temp.price * temp.quantity; // add the value to the current item
            temp= temp.next;
        }
        System.out.println("Total Inventory value: "+ totalValue); // Display the total value
    }

    public static void main(String[] args) {
        InventoryLinkedList list = new InventoryLinkedList(); // Create a new Linked List

        // Add some inventory records
        list.addAtBeginning("Mobile",101,12,25000);
        list.addAtEnd("Laptop",102,25,60000);
        list.addAtPosition(2,"Computer",103,15,45000);

        // Display all records
        System.out.println("Inventory Records: ");
        list.displayAll();
        System.out.println();

        // search for an inventory item
        System.out.println("Searching for item ID 102");
        list.searchByItemId(102);
        System.out.println();

        // update a inventory's quantity
        System.out.println("Updating quantity for item ID 101");
        list.updateQuantity(50,101);
        list.searchByItemId(101);
        System.out.println();

        // records after inventory update
        System.out.println("Inventory record: ");
        list.displayAll();
        System.out.println();

        // delete an inventory
        System.out.println("Deleting records of item ID 103");
        list.deleteByItemId(103);
        System.out.println();

        // calculate total value of inventory
        list.calculateTotalValue();
        System.out.println();

        // records after deletion
        System.out.println("Inventory records: ");
        list.displayAll();
        System.out.println();
    }
}
