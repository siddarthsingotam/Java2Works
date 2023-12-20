import java.util.ArrayList;
import java.util.List;

public class CollectionOperationsWithLambdas {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(8);
        numbers.add(20);
        numbers.add(15);
        numbers.add(3);
        numbers.add(12);

        // Filter Even Numbers using lambda expressions
        numbers.removeIf(n -> n % 2 == 0);

        // Double the Odd Numbers using lambda expressions and replaceAll()
        numbers.replaceAll(n -> (n % 2 == 1) ? n * 2 : n);

        // Sum the Numbers using lambda expressions
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();

        // Display the modified list and the sum
        System.out.println("Modified List: " + numbers);
        System.out.println("Sum of Numbers: " + sum);
    }
}
