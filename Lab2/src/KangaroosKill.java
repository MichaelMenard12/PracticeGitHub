import java.util.Scanner;

public class KangaroosKill {

    private static Scanner keyboard = new Scanner(System.in);

    // CONSTANT variables
    static final double ROAD_WIDTH = 0.01;
    static final double ROAD_KILL_PROB = 1.47;

    // --------------------------------------------------------------------
    public static void main(String[] args) {

        // Variables to hold input values
        System.out.print("Enter side of square in km : ");
        double square = keyboard.nextDouble();
        System.out.print("Enter roads length in km : ");
        double length = keyboard.nextDouble();
        System.out.print("Enter number of 'roos : ");
        double roos = keyboard.nextDouble();



        // Compute Kangaroos killed

        // Calculate area of Square of land
        double areaOfSquare = square * square;

        // Calculate kangaroo density
        double rooDensity = roos / areaOfSquare;

        // Calculate the road surface area
        double roadSurfaceArea = length * ROAD_WIDTH;

        // Calculate expected number of kills (density * road area * roadkill probability constant)
        double expectedKills = rooDensity * roadSurfaceArea * ROAD_KILL_PROB;

        // Calculate number of full kills and injuries (fractional part)
        int kills = (int) expectedKills;
        double injuries = expectedKills - kills;

        // Display results
        System.out.println("Expected number of kills is : " + kills);
        System.out.print("Expected number of injuries is : " + (injuries > 0 ? 1 : 0));

        // Close scanner
        keyboard.close();

    } // end of method

} // end of kangaroo class