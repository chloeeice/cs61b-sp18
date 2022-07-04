import org.junit.Test;
import static org.junit.Assert.*;

public class FlikTest {

    @Test
    public void isSameNumberTest() {
        int A = 128;
        int B = 128;
        int C = 25;
        assertTrue(Flik.isSameNumber(A, B));
        assertFalse(Flik.isSameNumber(A, C));

    }

}
