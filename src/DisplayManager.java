/**
 * DisplayManager.java
 *
 * SDC230L - Project Phase 4: Exception Handling
 * Author: Patrick Gonzalez
 *
 * This class handles all message display output for the calculator application.
 * It provides reusable methods for printing titles, menus, errors, and results,
 * following the principle of modular design.
 */
public class DisplayManager {

    /**
     * Prints the application title header with assignment info and author name.
     * Requirement: Show project week 4, a title, and the author's name.
     */
    public void printTitle() {
        System.out.println("============================================================");
        System.out.println("  Project Week 4 | Exception Handling Calculator");
        System.out.println("  Author: Patrick Gonzalez");
        System.out.println("  Course: SDC230L");
        System.out.println("============================================================");
    }

    /**
     * Prints a welcome message with basic instructions for the user.
     */
    public void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the Exception Handling Calculator!");
        System.out.println("This application will divide two numbers you provide.");
        System.out.println();
        System.out.println("Instructions:");
        System.out.println("  - Enter two numeric values when prompted.");
        System.out.println("  - The first number will be divided by the second.");
        System.out.println("  - If you enter an invalid value or zero as the");
        System.out.println("    denominator, you will be asked to try again.");
        System.out.println("  - Select option 2 from the menu to quit.");
        System.out.println();
    }

    /**
     * Prints the main menu for user interaction.
     */
    public void printMainMenu() {
        System.out.println("------------------------------------------------------------");
        System.out.println("                        MAIN MENU                          ");
        System.out.println("------------------------------------------------------------");
        System.out.println("  1. Perform Division");
        System.out.println("  2. Quit");
        System.out.println("------------------------------------------------------------");
        System.out.print("Enter your choice: ");
    }

    /**
     * Prints a formatted division result message.
     *
     * @param numerator   the first number entered by the user
     * @param denominator the second number entered by the user
     * @param result      the result of the division
     */
    public void printDivisionResult(double numerator, double denominator, double result) {
        System.out.printf("  >> Result: %.4f / %.4f = %.4f%n", numerator, denominator, result);
    }

    /**
     * Prints a general informational message.
     *
     * @param message the message to display
     */
    public void printMessage(String message) {
        System.out.println("  " + message);
    }

    /**
     * Prints an error/warning message.
     *
     * @param message the error message to display
     */
    public void printError(String message) {
        System.out.println("  [!] " + message);
    }

    /**
     * Prints the closing thank-you message when the user quits.
     */
    public void printClosing() {
        System.out.println();
        System.out.println("============================================================");
        System.out.println("  Thank you for using the Exception Handling Calculator!");
        System.out.println("  Goodbye, Patrick Gonzalez!");
        System.out.println("============================================================");
    }
}
