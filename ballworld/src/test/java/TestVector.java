
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import com.nhnacademy.Vector;

class TestVector {
    @Test
    void testConstructor() {
        assertDoesNotThrow(() -> {
            int dx = 100, dy = -100;
            Vector vector = new Vector(dx, dy);

            assertEquals(dx, vector.getDX());
            assertEquals(dy, vector.getDY());
        });
    }

    @Test
    void testSet() {
        assertDoesNotThrow(() -> {
            Vector targetVector = new Vector(100, -100);
            Vector otherVector = new Vector(0, 0);

            otherVector.set(targetVector);

            assertEquals(targetVector, otherVector);
        });
    }
}
