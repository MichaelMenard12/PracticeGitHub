import java.util.Scanner;

public class Scuba {

    private static Scanner keyboard = new Scanner(System.in);

    // CONSTANT variables
    private static final int FEET_PER_ATMOSPHERE = 33;
    private static final double MAX_O2_PRESSURE = 1.4;
    private static final double CONTINGENCY_MAX_PRESSURE = 1.6;

    // --------------------------------------------------------------------
    public static void main(String[] args) {

        // Variables to hold input values
        System.out.print("Enter depth ");
        double depth = keyboard.nextDouble();
        System.out.print("Enter percentage oxygen in gas ");
        double percentageOxygenInGas = keyboard.nextDouble();
        // Computations
        double ambientPressure = (depth / FEET_PER_ATMOSPHERE) + 1;

        double o2Pressure = ambientPressure * (double) percentageOxygenInGas / 100;

        char o2Group = (char) ((int) (o2Pressure * 10) + (int) 'A');

        // Display results
        System.out.println("Ambient Pressure: " + ambientPressure);
        System.out.println("O2 Pressure: " + o2Pressure);
        System.out.println("O2 Group: " + o2Group);
        System.out.println("Exceeds maximal O2 pressure: " + ((o2Pressure >= MAX_O2_PRESSURE) ? "true" : "false"));
        System.out.println("Exceeds contingency O2 pressure: " + ((o2Pressure >= CONTINGENCY_MAX_PRESSURE) ? "true" : "false"));

        // Close scanner
        keyboard.close();

    } // end of main method


} // end of Scuba class