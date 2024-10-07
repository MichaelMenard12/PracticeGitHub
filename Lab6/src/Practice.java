import java.util.Scanner;

public class Practice {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Practice Arrays");

        System.out.println("How many element of the array do you want?");
        int arraySize = keyboard.nextInt();
        // declaring an array
        int[] myArray = new int[arraySize];
        // declaring 2d array
        int[][] yourArray = new int[3][2];

        // updating the array
        int rowIndex;
        int colIndex;

        for (rowIndex = 0; rowIndex < yourArray.length; rowIndex++) {

            for (colIndex = 0; colIndex < yourArray[rowIndex].length; colIndex++) {

                System.out.println("At index [" + rowIndex + "] [" + colIndex + "]: Enter a number: ");
                yourArray[rowIndex][colIndex] = keyboard.nextInt();
            } // end of the inner for loop --> column
        } // end of the outer for loop --> row

        int index;
        for (index = 0; index < myArray.length; index++) {
            System.out.println("\n\nAt print [" + index + "], The value is: " + myArray[index]);
            myArray[index] = keyboard.nextInt();

        } // end of the for loop

        System.out.println("Display the content of the array");

        // Display the array

        for (rowIndex = 0; rowIndex < yourArray.length; rowIndex++) {

            for (colIndex = 0; colIndex < yourArray[rowIndex].length; colIndex++) {

                System.out.println("At index [" + rowIndex + "] [" + colIndex + "]: The value is :");
            }
        }


        for (index = 0; index < myArray.length; index++) {
            System.out.println("At index [" + index + "], The value is: " + myArray[index]);
        } // end of the for loop

    } // end of the main method

} // end of the Practice class
