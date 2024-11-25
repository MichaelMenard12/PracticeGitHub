


import java.util.Scanner;

/**
 * DentalRecords - asks user for input and outputs menu to select from
 */
public class DentalRecords {
    // DentalRecords constants
    private static final int MAX_PEOPLE = 6; // max 6 people in family
    private static final int MAX_TEETH = 8; // max 8 teeth

    // arrays
    private static String[] familyNames = new String[MAX_PEOPLE]; // family name array
    private static char[][][] teethRecords = new char[MAX_PEOPLE][2][MAX_TEETH]; // 3D array [people][uppers/lowers][teeth]

    // Validates tooth string

    /**
     * checks if teeth length exceeds max
     * @param teeth string of teeth
     * @return
     */
    private static boolean isValidToothString(String teeth) {
        if (teeth.length() > MAX_TEETH) return false;
        for (char c : teeth.toUpperCase().toCharArray()) {
            if (c != 'I' && c != 'B' && c != 'M') { // valid tooth types (I, B, M)
                return false;
            }
        } // end of for loop
        return true;
    } // end of isValidToothString

    /**
     * prints the family's teeth record
     * @param familySize accounts for entire size of family
     */
    private static void printFamilyRecord(int familySize) { // Print the family's teeth record
        for (int i = 0; i < familySize; i++) { // start of outer for loop
            System.out.println(familyNames[i]);
            System.out.print("  Uppers: ");
            for (int j = 0; j < MAX_TEETH; j++) { // start of inner for loop
                if (teethRecords[i][0][j] != '\u0000') { // if tooth is initialized then print it
                    System.out.print((j + 1) + ":" + teethRecords[i][0][j] + " ");
                }
            } // end of inner for loop
            System.out.println();
            System.out.print("  Lowers: ");
            for (int j = 0; j < MAX_TEETH; j++) { // start of for loop
                if (teethRecords[i][1][j] != '\u0000') {
                    System.out.print((j + 1) + ":" + teethRecords[i][1][j] + " ");
                }
            } // end of inner for loop
            System.out.println("\n"); // new line for each new member
        } // end of for loop
    } // end of printFamilyRecord

    /**
     * handles tooth extractions
     * @param familySize accounts for entire size of family
     */
    private static void extractTooth(int familySize) {     // start of extractTooth method
        Scanner scanner;

        // while loop until a family member is chosen
        int familyIndex = -1;
        while (familyIndex == -1) {
            scanner = new Scanner(System.in);
            System.out.print("Which family member: ");
            String name = scanner.nextLine();

            // start of for loop for family size
            for (int i = 0; i < familySize; i++) {
                if (familyNames[i].equalsIgnoreCase(name)) { // case-sensitive checker
                    familyIndex = i;
                    break;
                }
            } // end of inner for loop

            if (familyIndex == -1) { // repeats if invalid input
                System.out.println("Invalid family member, try again.");
            }
        } // end of while loop
        // while loop until tooth layer is chosen
        int layerIndex = -1;
        while (layerIndex == -1) {

            System.out.print("Which tooth layer (U)pper or (L)ower: ");
            scanner = new Scanner(System.in);
            char layer = scanner.nextLine().toUpperCase().charAt(0); // retrieves uppercase layer input
            layerIndex = (layer == 'U') ? 0 : (layer == 'L') ? 1 : -1;

            if (layerIndex == -1) {
                System.out.println("Invalid layer, try again.");
            }
        } // end of while loop
        // while loop until tooth number is chosen
        int toothNumber = -1;
        while (toothNumber < 1 || toothNumber > MAX_TEETH) {
            System.out.print("Which tooth number: ");
            scanner = new Scanner(System.in);

            toothNumber = scanner.nextInt();
            if (toothNumber < 1 || toothNumber > MAX_TEETH) {
                System.out.println("Invalid tooth number, try again.");
            }
        } // end of while loop
        if (teethRecords[familyIndex][layerIndex][toothNumber - 1] == 'M') { // check if tooth is missing
            System.out.println("Missing tooth, try again.");
        }

        // Extract the tooth
        teethRecords[familyIndex][layerIndex][toothNumber - 1] = 'M';
        System.out.println("Tooth extracted.");
    } // end of extractTooth

    /**
     * Reports root canal indices based off tooth condition
     * @param familySize accounts for entire size of family
     */
    private static void reportRootCanal(int familySize) {
        int I = 0, B = 0, M = 0; // (I)ncisors, (B)icuspids, (M)olars
        for (int i = 0; i < familySize; i++) {
            for (int j = 0; j < 2; j++) { // 2 rows: uppers and lowers
                for (int k = 0; k < MAX_TEETH; k++) {
                    char tooth = teethRecords[i][j][k];
                    if (tooth == 'I') I++;
                    else if (tooth == 'B') B++;
                    else if (tooth == 'M') M++;
                } // end of inner for loop
            } // end of inner for loop
        } // end of outer for loop

        // Solves quadratic Ix^2 + Bx - M = 0
        double discriminant = B * B + 4 * I * M;
        if (discriminant < 0) {
            System.out.println("No real roots."); // checks for real roots
        } else {
            double root1 = (-B + Math.sqrt(discriminant)) / (2 * I);
            double root2 = (-B - Math.sqrt(discriminant)) / (2 * I);
            System.out.printf("One root canal at %.2f%n", root1);
            System.out.printf("Another root canal at %.2f%n", root2);
        }
    } // end of reportRootCanal

    /**
     * Gets input from users and outputs menu, allowing option to print, extract, root, and exit
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Floridian Tooth Records");
        System.out.println("--------------------------------------");

        int familySize;
        // Get number of people in the family
        do {
            System.out.print("Please enter number of people in the family: ");
            familySize = scanner.nextInt();
            scanner.nextLine(); // consume newline
            if (familySize < 1 || familySize > MAX_PEOPLE) {
                System.out.println("Invalid number of people, try again.");
            }
        } while (familySize < 1 || familySize > MAX_PEOPLE);

        // Record data for each family member
        for (int i = 0; i < familySize; i++) {
            System.out.print("Please enter the name for family member " + (i + 1) + ": ");
            familyNames[i] = scanner.nextLine();

            // Get upper teeth
            String uppers;
            do {
                System.out.print("Please enter the uppers for " + familyNames[i] + ": ");
                uppers = scanner.nextLine();
                if (!isValidToothString(uppers)) {
                    System.out.println("Invalid teeth types, try again."); // ask again if invalid input
                } else if (uppers.length() > MAX_TEETH) {
                    System.out.println("Too many teeth, try again."); // ask again if invalid input
                }
            } while (!isValidToothString(uppers) || uppers.length() > MAX_TEETH);

            // Get lower teeth
            String lowers;
            do {
                System.out.print("Please enter the lowers for " + familyNames[i] + ": ");
                lowers = scanner.nextLine();
                if (!isValidToothString(lowers)) {
                    System.out.println("Invalid teeth types, try again."); // ask again if invalid input
                } else if (lowers.length() > MAX_TEETH) {
                    System.out.println("Too many teeth, try again."); // ask again if invalid input
                }
            } while (!isValidToothString(lowers) || lowers.length() > MAX_TEETH);

            // Store teeth information
            for (int j = 0; j < uppers.length(); j++) {
                teethRecords[i][0][j] = Character.toUpperCase(uppers.charAt(j));
            } // end of inner for loop
            for (int j = 0; j < lowers.length(); j++) {
                teethRecords[i][1][j] = Character.toUpperCase(lowers.charAt(j));
            } // end of inner for loop
        } // end of outer for loop

        // menu loop
        while (true) {
            System.out.print("(P)rint, (E)xtract, (R)oot, e(X)it: ");
            char option = scanner.nextLine().toUpperCase().charAt(0);
            switch (option) { // 4 options possible
                case 'P':   // print
                    printFamilyRecord(familySize);
                    break;
                case 'E': // extract
                    extractTooth(familySize);
                    break;
                case 'R': // report
                    reportRootCanal(familySize);
                    break;
                case 'X': // exit
                    System.out.println("Exiting the Floridian Tooth Records :-)");
                    return;
                default:
                    System.out.println("Invalid menu option, try again.");  // repeat if invalid input
            } // end of switch
        } // end of while loop
    } // end of main class
} // end of public class DentalRecords
