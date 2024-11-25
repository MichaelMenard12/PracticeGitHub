import java.util.Scanner;

// start of IAm class
public class IAm {

    private static final Scanner keyboard = new Scanner(System.in);

    // start of main class
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String qualities = "";
        String input;

        // gather input
        System.out.print("Please enter sentences, . to end.");

        while (true) {
            input = keyboard.nextLine();

            // break if input is "."
            if (input.equals(".")) {
                break;
            }

            // checks if sentence starts with "I am"
            if (input.startsWith("I am ")) {
                // Extract the substring starting at the 5th character
                String quality = input.substring(5);

                // Concatenate this quality to the growing string
                if (!qualities.isEmpty()) {
                    qualities += ", "; // Add a comma separator if qualities already exist
                }
                qualities += quality;
            }
        }
        // outputs qualities and checks if empty
        if(!qualities.isEmpty()) {
            System.out.println("The qualities are " + qualities + ".");
        } else {
            System.out.println("No qualities were provided.");
        } // end of if-else

    } // end of the main method

} // end of the IAm class
    