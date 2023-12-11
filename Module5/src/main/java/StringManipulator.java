public class StringManipulator {
    private String inputString;

    // Constructor that takes a string parameter
    public StringManipulator(String inputString) {
        this.inputString = inputString;
    }

    // Concatenates the input string with another string and returns the result.
    public String concatenate(String str) {
        return inputString + str;
    }

    // Returns the length of the input string.
    public int findLength() {
        return inputString.length();
    }

    // Converts the input string to uppercase and returns the result.
    public String convertToUpperCase() {
        return inputString.toUpperCase();
    }

    // Converts the input string to lowercase and returns the result.
    public String convertToLowerCase() {
        return inputString.toLowerCase();
    }

    // Checks if the input string contains the given substring and returns true if it does, otherwise returns false.
    public boolean containsSubstring(String subStr) {
        return inputString.contains(subStr);
    }

    // Example usage in a main method (for testing purposes)
    public static void main(String[] args) {
        String input = "Hello";
        StringManipulator manipulator = new StringManipulator(input);

        // Concatenate
        String concatenated = manipulator.concatenate(" World");
        System.out.println("Concatenated: " + concatenated);

        // Find length
        int length = manipulator.findLength();
        System.out.println("Length: " + length);

        // Convert to uppercase
        String upperCase = manipulator.convertToUpperCase();
        System.out.println("Uppercase: " + upperCase);

        // Convert to lowercase
        String lowerCase = manipulator.convertToLowerCase();
        System.out.println("Lowercase: " + lowerCase);

        // Contains substring
        String substring = "lo";
        boolean containsSubstring = manipulator.containsSubstring(substring);
        System.out.println("Contains '" + substring + "': " + containsSubstring);
    }
}
