package Week_03.Day_01.circularlinkedlist.onlineticketreservationsystem;

public class TicketReservationSystem {
    private TicketNode last;
    private int ticketCount;

    // Constructor to initialize an empty circular list
    public TicketReservationSystem() {
        last = null;
        ticketCount = 0;
    }

    // Method to add a new ticket reservation at the end of the circular list
    public void addTicket(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        TicketNode newNode = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (last == null) { // If the list is empty
            last = newNode;
            last.next = last; // Point to itself to maintain circular nature
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        ticketCount++;
        System.out.println("Ticket booked successfully!");
    }

    // Method to remove a ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (last == null) {
            System.out.println("No tickets available to remove.");
            return;
        }

        TicketNode current = last.next;
        TicketNode previous = last;
        boolean found = false;

        do {
            if (current.ticketId == ticketId) {
                found = true;
                if (current == last && current.next == last) { // Only one node in the list
                    last = null;
                } else {
                    previous.next = current.next;
                    if (current == last) {
                        last = previous;
                    }
                }
                ticketCount--;
                System.out.println("Ticket with ID " + ticketId + " removed successfully.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != last.next);

        if (!found) {
            System.out.println("Ticket not found.");
        }
    }

    // Method to display all tickets in the circular list
    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets available.");
            return;
        }

        TicketNode current = last.next;
        System.out.println("Current Ticket Reservations:");
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName + ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != last.next);
    }

    // Method to search for a ticket by Customer Name or Movie Name
    public void searchTicket(String query) {
        if (last == null) {
            System.out.println("No tickets available.");
            return;
        }

        TicketNode current = last.next;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(query) || current.movieName.equalsIgnoreCase(query)) {
                System.out.println("Found Ticket - ID: " + current.ticketId + ", Customer: " + current.customerName + ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != last.next);

        if (!found) {
            System.out.println("No ticket found with the given query.");
        }
    }

    // Method to count the total number of booked tickets
    public int getTotalTickets() {
        return ticketCount;
    }
}
