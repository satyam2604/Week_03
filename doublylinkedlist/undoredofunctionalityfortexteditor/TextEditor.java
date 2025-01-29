package Week_03.Day_01.doublylinkedlist.undoredofunctionalityfortexteditor;

public class TextEditor {
    private TextState currentState;
    private int historySize;
    private int currentSize;

    // Constructor to initialize the text editor with a history limit
    public TextEditor(int historySize) {
        this.historySize = historySize;
        this.currentSize = 0;
        this.currentState = new TextState(""); // Initial empty state
    }
    // Method to add a new text state (simulate typing or performing an action)
    public void addTextState(String newText) {
        TextState newState = new TextState(newText);
        newState.prev = currentState;
        if (currentState != null) {
            currentState.next = newState;
        }
        currentState = newState;

        // Maintain history size limit
        currentSize++;
        if (currentSize > historySize) {
            removeOldestState();
        }
    }

    // Method to remove the oldest state when history size exceeds limit
    private void removeOldestState() {
        TextState temp = currentState;
        while (temp.prev != null) {
            temp = temp.prev;
        }
        if (temp.next != null) {
            temp.next.prev = null;
        }
        currentSize--;
    }

    // Method to undo (move to the previous state)
    public void undo() {
        if (currentState.prev != null) {
            currentState = currentState.prev;
        } else {
            System.out.println("No more undo operations available.");
        }
    }

    // Method to redo (move to the next state after undo)
    public void redo() {
        if (currentState.next != null) {
            currentState = currentState.next;
        } else {
            System.out.println("No more redo operations available.");
        }
    }

    // Method to display the current state of the text
    public void displayCurrentState() {
        System.out.println("Current Text: " + currentState.text);
    }
}