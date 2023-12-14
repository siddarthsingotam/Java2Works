//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class PalindromeChecker {
    public PalindromeChecker() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string, to check if it is a palindrome: ");
        String userInput = scanner.nextLine();
        String transformedInput = transformInput(userInput);
        boolean isPalindrome = isPalindrome(transformedInput);
        if (isPalindrome) {
            System.out.println("The transformed input is a palindrome.");
        } else {
            System.out.println("The transformed input is not a palindrome.");
        }

    }

    public static String transformInput(String input) {
        input = input.toLowerCase();
        input = input.replaceAll("[^a-zA-Z]", "");
        return input;
    }

    public static boolean isPalindrome(String input) {
        StringBuilder reversed = new StringBuilder();

        for(int i = input.length() - 1; i >= 0; --i) {
            reversed.append(input.charAt(i));
        }

        String reversedString = reversed.toString();
        return input.equals(reversedString);
    }

    public static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder();

        for(int i = input.length() - 1; i >= 0; --i) {
            reversed.append(input.charAt(i));
        }

        return reversed.toString();
    }
}
