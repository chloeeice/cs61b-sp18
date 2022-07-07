import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offBy5 = new OffByN(5);

    @Test
    public void testEqualChars() {
        char x = 'a';
        char y = 'f';
        char z = 'h';
        assertTrue(offBy5.equalChars(x, y));
        assertTrue(offBy5.equalChars(y, x));
        assertFalse(offBy5.equalChars(y, z));
    }
}
