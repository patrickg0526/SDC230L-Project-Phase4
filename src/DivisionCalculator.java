/**
 * DivisionCalculator.java
 *
 * SDC230L - Project Phase 4: Exception Handling
 * Author: Patrick Gonzalez
 *
 * This class handles the division operation for the calculator application.
 * It demonstrates exception handling for:
 *   - ArithmeticException: division by zero
 *   - NumberFormatException: non-numeric input (handled upstream in InputManager)
 *
 * Designed for reuse in the final course project submission.
 */
public class DivisionCalculator {

    /** Reference to DisplayManager for printing results and error messages. */
    private DisplayManager display;

    /**
     * Constructor - takes a DisplayManager to use for output.
     *
     * @param display the DisplayManager instance for printing messages
     */
    public DivisionCalculator(DisplayManager display) {
        this.display = display;
    }

    /**
     * Divides the numerator by the denominator and displays the result.
     * Handles ArithmeticException in the unlikely event a zero slips through.
     *
     * @param numerator   the number to be divided
     * @param denominator the number to divide by (must not be zero)
     */
    public void divide(double numerator, double denominator) {
        try {
            if (denominator == 0) {
                throw new ArithmeticException("Division by zero");
            }
            double result = numerator / denominator;
            display.printDivisionResult(numerator, denominator, result);
        } catch (ArithmeticException e) {
            display.printError("Cannot divide by zero. Operation aborted.");
        }
    }
}
