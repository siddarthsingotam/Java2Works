
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringManipulatorTest {

    @Test
    public void concatenateAddsStringToEnd() {
        StringManipulator manipulator = new StringManipulator("Hello");
        assertEquals("Hello World", manipulator.concatenate(" World"));
    }

    @Test
    public void findLengthReturnsCorrectLength() {
        StringManipulator manipulator = new StringManipulator("Hello");
        assertEquals(5, manipulator.findLength());
    }

    @Test
    public void convertToUpperCaseMakesAllLettersCapital() {
        StringManipulator manipulator = new StringManipulator("Hello");
        assertEquals("HELLO", manipulator.convertToUpperCase());
    }

    @Test
    public void convertToLowerCaseMakesAllLettersSmall() {
        StringManipulator manipulator = new StringManipulator("Hello");
        assertEquals("hello", manipulator.convertToLowerCase());
    }

    @Test
    public void containsSubstringReturnsTrueWhenSubstringExists() {
        StringManipulator manipulator = new StringManipulator("Hello");
        assertTrue(manipulator.containsSubstring("lo"));
    }

    @Test
    public void containsSubstringReturnsFalseWhenSubstringDoesNotExist() {
        StringManipulator manipulator = new StringManipulator("Hello");
        assertFalse(manipulator.containsSubstring("world"));
    }

    // Edge cases
    @Test
    public void concatenateWithEmptyStringReturnsOriginal() {
        StringManipulator manipulator = new StringManipulator("Hello");
        assertEquals("Hello", manipulator.concatenate(""));
    }

    @Test
    public void findLengthReturnsZeroForEmptyString() {
        StringManipulator manipulator = new StringManipulator("");
        assertEquals(0, manipulator.findLength());
    }

    @Test
    public void convertToUpperCaseForEmptyStringReturnsEmptyString() {
        StringManipulator manipulator = new StringManipulator("");
        assertEquals("", manipulator.convertToUpperCase());
    }

    @Test
    public void convertToLowerCaseForEmptyStringReturnsEmptyString() {
        StringManipulator manipulator = new StringManipulator("");
        assertEquals("", manipulator.convertToLowerCase());
    }

    @Test
    public void containsSubstringReturnsFalseForEmptyString() {
        StringManipulator manipulator = new StringManipulator("");
        assertFalse(manipulator.containsSubstring("lo"));
    }
}
