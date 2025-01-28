package Week_03.Day_01.singlilikedlist.inventorymanagementsystem;

// Node class representing each inventory record
public class InventoryNode {
    String itemName; // Name of the item
    int itemId; // ID of the item
    int quantity; // item quantity
    double price; // item price
    InventoryNode next; // Pointer to the next Node

    // Constructor to initialize the inventory node
    public InventoryNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}
