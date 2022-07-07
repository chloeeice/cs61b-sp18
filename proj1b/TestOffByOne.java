import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        char x = 'a';
        char y = 'b';
        char z = 'A';
        char q = '&';
        char p = '%';
        assertTrue(offByOne.equalChars(x, y));
        assertFalse(offByOne.equalChars(y, z));
        assertTrue(offByOne.equalChars(p, q));
        assertFalse(offByOne.equalChars(y, q));
    }
}
