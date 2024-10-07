import java.util.Scanner;

// input of array that get checked for fibonocci and prime numbers (max 10 integers, 0 to stop)

/**
 * This is the class
 *
 * @author MichaeL Menard
 */

public class ForArraySimple {
    private static final int MAX_INPUT = 10;
    private static Scanner keyboard = new Scanner(System.in);

    public static voi main(String[] args) {
        int[] numbers = new int[10];
        System.out.print("Week 6- Lab 5");
        int count = 0;
        int[] candidate = new int[MAX_INPUT];
        System.out.println("Please enter numbers (0 to stop):");
        while (count < 10) {
            int number = keyboard.nextInt();
            if (number == 0) {
                break;
            }
            numbers[count++] = number;
        }






    } // end of main class
    // displays results
    do {
    for (int i = 0; i < count; i++) {
        boolean prime = isPrime(numbers[i]);
        boolean fibonacci = isFibonacci(numbers[i]);

        System.out.print(numbers[i] + " is ");
        System.out.print(fibonacci ? "Fibonacci" : "not Fibonacci");
        System.out.println(" and is " + (prime ? "prime" : "not prime"));
    }
    keyboard.close();


    }

    // prime calculation method
    private static boolean isPrime(int candidate) {

        int divisor = 2;

        while (divisor <= Math.sqrt(candidate)) {
            if (candidate % divisor == 0) {
                return (false);
            }
            divisor++;
        }
        return (true);
    } // end of isPrime method

    private static boolean isFibonacci(int index) {

        int previous = 1;
        int current = 0;
        int next;

        while (index < current) {
            next = current + previous;
            previous = current;
            current = next;

            if (current == index) {
                return true;
            }
        }
    } // end of isFibonacci method
} // end of ForArraySimple class

