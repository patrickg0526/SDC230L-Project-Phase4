/**
 * CalculatorApp.java
 *
 * SDC230L - Project Phase 4: Exception Handling
 * Author: Patrick Gonzalez
 *
 * Main application class for the Exception Handling Calculator.
 * This class ties together all components (DisplayManager, InputManager,
 * DivisionCalculator) to deliver the full Phase 4 functionality.
 *
 * Features:
 *   - Prompts user to enter two numeric values
 *   - Divides the first number by the second number
 *   - Handles ArithmeticException (division by zero)
 *   - Handles NumberFormatException (non-numeric input)
 *   - Allows user to retry on invalid input
 *   - Continues until the user selects to quit
 */
public class CalculatorApp {

    /**
     * Main entry point for the Exception Handling Calculator application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        // Initialize components (modular design)
        DisplayManager display = new DisplayManager();
        InputManager input = new InputManager();
        DivisionCalculator calculator = new DivisionCalculator(display);

        // ----------------------------------------------------------
        // STEP 1: Print the title line (screenshot here)
        // ----------------------------------------------------------
        display.printTitle();

        // ----------------------------------------------------------
        // STEP 2: Print the welcome/instructions message (screenshot here)
        // ----------------------------------------------------------
        display.printWelcome();

        // ----------------------------------------------------------
        // STEP 3: Main loop - continue until user selects Quit
        // ----------------------------------------------------------
        boolean running = true;
        while (running) {

            display.printMainMenu();
            String menuChoice = input.getRawInput();

            switch (menuChoice.trim()) {

                case "1":
                    // Perform division with full exception handling
                    double numerator = input.getDouble("Enter the first number (numerator): ");
                    double denominator = input.getDoubleWithZeroCheck(
                            "Enter the second number (denominator): ", display);
                    calculator.divide(numerator, denominator);
                    break;

                case "2":
                    running = false;
                    break;

                default:
                    display.printError("Invalid choice. Please enter 1 or 2.");
            }
        }

        // ----------------------------------------------------------
        // STEP 4: Print closing message (screenshot here)
        // ----------------------------------------------------------
        display.printClosing();

        // Close scanner resource
        input.close();
    }
}
