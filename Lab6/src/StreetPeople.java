import java.util.Scanner;

public class StreetPeople {
    private static final Scanner scanner = new Scanner(System.in);
    /**
     * Class stores house # & age of people living in each house as input.
     * Calculates total age of each house and total age of all ppl on street
     **/
    public static void main(String[] args) {
        // store input # of houses
        System.out.print("How many houses in the street?   : ");
        int numberOfHouses = scanner.nextInt();
        // declare store house #'s
        int[] houseNumbers = new int[numberOfHouses];
        // declare store age of ppl in each house
        int[][] houseAges = new int[numberOfHouses][];
        inputHouseData(scanner, houseNumbers, houseAges, numberOfHouses);
        analyzeAndReport(houseNumbers, houseAges);
    } // end of main method

    // This method inputs house numbers and the ages of people in each house
    public static void inputHouseData(Scanner scanner, int[] houseNumbers, int[][] houseAges, int numberOfHouses) {
        for (int index = 0; index < numberOfHouses; index++) {
            // Input house number
            System.out.print("What is the next house number?   : ");
            houseNumbers[index] = scanner.nextInt();
        } // end of for loop
        for (int rowIndex = 0; rowIndex < numberOfHouses; rowIndex++) {
            // Input number of people in the house
            System.out.print("How many people live in number " + houseNumbers[rowIndex] + " : ");
            int numberOfPeople = scanner.nextInt();
            // Initialize the ages array for this house
            houseAges[rowIndex] = new int[numberOfPeople];
            // Input the ages of people in the house
            for (int age = 0; age < numberOfPeople; age++) {
                System.out.print("What is the age of person " + (age + 1) + "      : ");
                houseAges[rowIndex][age] = scanner.nextInt();
            } // end of inner for loop
        } // end of outer for loop
    } // end of inputHouseData method

    // method analyzes & outputs total age per house and the total age for the street
    public static void analyzeAndReport(int[] houseNumbers, int[][] houseAges) {
        int totalStreetAge = 0;
        // Loop through each house to calculate the total age for each house
        for (int totalAge = 0; totalAge < houseNumbers.length; totalAge++) {
            int houseTotalAge = 0;
            for (int age : houseAges[totalAge]) {
                houseTotalAge += age;
            } // end of inner for loop
            totalStreetAge += houseTotalAge;
            //output total age of house number
            System.out.println("House " + houseNumbers[totalAge] + " has a total age of " + houseTotalAge);
        } // end of outer for loop
        // output total street age
        System.out.println("The street has a total age of " + totalStreetAge);
    } // end of analyzeAndReport class
}  // end of StreetPeople class
