import java.util.Scanner;

public class TaxSystem {

    private static Scanner keyboard = new Scanner(System.in);

    // CONSTANT variables
    private static final int FEET_PER_ATMOSPHERE = 33;
    private static final double MAX_O2_PRESSURE = 1.4;
    private static final double CONTINGENCY_MAX_PRESSURE = 1.6;

    // --------------------------------------------------------------------
    public static void main(String[] args) {

        // Variables to hold input value
        int income = 0;
        int deduction = 0;

        System.out.print("Enter value ");
        int value = -1;
        while (value != 0) {
            value = keyboard.nextInt();
            if (value > 0) {
                income += value;
            }
            else if (value < 0) {
                deduction += value;
            }
        }

        // Computations

        // Display results
        System.out.println("Ambient Pressure: " + ambientPressure);

        // Close scanner
        keyboard.close();

    } // end of main method


} // end of TaxSystem class