
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
// Used copilot to generate the tests below and I verified them.
class PalindromeCheckerTest {

    @Test
    void transformInputRemovesNonAlphabeticCharactersAndConvertsToLowercase() {
        String input = "A Man, A Plan, A Canal, Panama!";
        String expected = "amanaplanacanalpanama";
        assertEquals(expected, PalindromeChecker.transformInput(input));
    }

    @Test
    void isPalindromeReturnsTrueForPalindrome() {
        String input = "amanaplanacanalpanama";
        assertTrue(PalindromeChecker.isPalindrome(input));
    }

    @Test
    void isPalindromeReturnsFalseForNonPalindrome() {
        String input = "notapalindrome";
        assertFalse(PalindromeChecker.isPalindrome(input));
    }

    @Test
    void reverseStringReversesInput() {
        String input = "reverse";
        String expected = "esrever";
        assertEquals(expected, PalindromeChecker.reverseString(input));
    }

    @Test
    void reverseStringHandlesEmptyString() {
        String input = "";
        String expected = "";
        assertEquals(expected, PalindromeChecker.reverseString(input));
    }
}
