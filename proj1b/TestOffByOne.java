import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void TestEqualChars() {
        char x = 'a';
        char y = 'b';
        char z = 'A';
        assertTrue(offByOne.equalChars(x, y));
        assertFalse(offByOne.equalChars(y, z));
    }
}
