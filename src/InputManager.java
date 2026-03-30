import java.util.Scanner;

/**
 * InputManager.java
 *
 * SDC230L - Project Phase 4: Exception Handling
 * Author: Patrick Gonzalez
 *
 * This class handles all user input operations for the calculator application.
 * It provides reusable methods for safely reading doubles and raw strings from
 * the user, including NumberFormatException handling and re-prompting on error.
 */
public class InputManager {

    /** Scanner used to read user input from the console. */
    private Scanner scanner;

    /**
     * Constructor - initializes the Scanner for System.in.
     */
    public InputManager() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Reads a raw string line from the user with no validation.
     * Used for menu choices where the calling code handles validation.
     *
     * @return the trimmed string entered by the user
     */
    public String getRawInput() {
        return scanner.nextLine().trim();
    }

    /**
     * Reads a valid double (decimal or whole number) from the user.
     * Handles NumberFormatException - re-prompts until a valid number is entered.
     *
     * @param prompt the message to display before reading input
     * @return the valid double entered by the user
     */
    public double getDouble(String prompt) {
        while (true) {
            System.out.print("  " + prompt);
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("  [!] Invalid input: \"" + input + "\" is not a number.");
                System.out.println("      Please enter a valid numeric value (e.g., 10, 3.5, -7).");
            }
        }
    }

    /**
     * Reads a valid, non-zero double from the user for use as a denominator.
     * Handles both NumberFormatException (non-numeric input) and
     * division-by-zero by checking if the value is zero before returning.
     *
     * @param prompt  the message to display before reading input
     * @param display the DisplayManager used to print error messages
     * @return the valid, non-zero double entered by the user
     */
    public double getDoubleWithZeroCheck(String prompt, DisplayManager display) {
        while (true) {
            System.out.print("  " + prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value == 0) {
                    // Catch the logical division-by-zero condition
                    throw new ArithmeticException("Division by zero");
                }
                return value;
            } catch (NumberFormatException e) {
                display.printError("Invalid input: \"" + input + "\" is not a number.");
                display.printMessage("Please enter a valid numeric value (e.g., 4, 2.5, -3).");
            } catch (ArithmeticException e) {
                display.printError("Division by zero is not allowed.");
                display.printMessage("Please enter a non-zero value for the denominator.");
            }
        }
    }

    /**
     * Closes the scanner when no longer needed.
     * Should be called when the application exits.
     */
    public void close() {
        scanner.close();
    }
}
