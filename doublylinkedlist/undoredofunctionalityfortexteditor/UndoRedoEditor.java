package Week_03.Day_01.doublylinkedlist.undoredofunctionalityfortexteditor;

import java.util.Scanner;

public class UndoRedoEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor(10); // Limit history to 10 states

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Type Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current State");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    String text = scanner.nextLine();
                    editor.addTextState(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrentState();
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
