import java.util.Arrays;
import java.util.List;

public class NumberOperations {

    public static void main(String[] args) {
        // Example list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Perform operations using functional programming
        int sum = numbers.stream()
                .filter(NumberOperations::isOdd)    // Filter out even numbers
                .map(NumberOperations::doubleNumber) // Double each remaining number
                .reduce(0, Integer::sum);            // Find the sum

        // Print the result
        System.out.println("Sum of doubled odd numbers: " + sum);
    }

    // Predicate to check if a number is odd
    private static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    // Function to double a number as follows: f(x) = 2x
    private static int doubleNumber(int number) {
        return number * 2;
    }
}

