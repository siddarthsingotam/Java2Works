import java.util.Arrays;

public class MeanCalculator {

    public static void main(String[] args) {
        // Example array
        double[] numbers = {1.0, 2.0, 3.0, 4.0, 5.0};

        // Calculate the mean
        double mean = calculateMean(numbers);

        // Print the result
        System.out.println("Mean: " + mean);
    }

    // Function to calculate the mean of an array
    private static double calculateMean(double[] numbers) {
        return Arrays.stream(numbers)
                .average()
                .orElse(0.0); // Default value if the array is empty
    }
}
