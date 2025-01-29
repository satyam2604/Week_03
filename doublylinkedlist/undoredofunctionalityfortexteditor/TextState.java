package Week_03.Day_01.doublylinkedlist.undoredofunctionalityfortexteditor;

public class TextState {
    String text;
    TextState next;
    TextState prev;

    // Constructor to initialize a text state node
    public TextState(String text) {
        this.text = text;
        this.next = null;
        this.prev = null;
    }
}