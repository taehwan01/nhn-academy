import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.awt.Color;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.nhnacademy.MoveableBall;

@TestInstance(PER_CLASS)
class TestMoveableBall {
    @Test
    void testConstructor() {
        assertDoesNotThrow(() -> {
            MoveableBall ball = new MoveableBall(0, 0, 1, Color.ORANGE);

            assertEquals(MoveableBall.DEFAULT_DX, ball.getDX());
            assertEquals(MoveableBall.DEFAULT_DY, ball.getDY());
        });
    }

    @ParameterizedTest
    @MethodSource("deltaProvider")
    void testDeltaXY(int x, int y, int dx, int dy) {
        assertDoesNotThrow(() -> {
            MoveableBall ball = new MoveableBall(0, 0, 1, Color.ORANGE);

            ball.setDX(dx);
            ball.setDY(dy);
            assertEquals(dx, ball.getDX());
            assertEquals(dy, ball.getDY());
        });
    }

    static Stream<Arguments> deltaProvider() {
        return Stream.of(
                Arguments.arguments(0, 0, 10, 0, 0),
                Arguments.arguments(0, 0, 10, 1, -1),
                Arguments.arguments(0, 0, 10, -1, 1),
                Arguments.arguments(0, 0, 10, 1, 1),
                Arguments.arguments(0, 0, 10, -1, -1),
                Arguments.arguments(0, 0, 10, Integer.MAX_VALUE, 0),
                Arguments.arguments(0, 0, 10, Integer.MAX_VALUE, Integer.MAX_VALUE),
                Arguments.arguments(0, 0, 10, Integer.MIN_VALUE, 0),
                Arguments.arguments(0, 0, 10, 0, Integer.MIN_VALUE));
    }

    @ParameterizedTest
    @MethodSource("moveProvider")
    void testMove(int x, int y, int radius, int dx, int dy, int count) {
        assertDoesNotThrow(() -> {
            MoveableBall ball = new MoveableBall(x, y, radius, Color.ORANGE);

            ball.setDX(dx);
            ball.setDY(dy);

            int currentX = x;
            int currentY = y;

            for (int i = 1; i < count; i++) {
                ball.move();
                currentX += dx;
                currentY += dy;

                assertEquals(currentX, ball.getX());
                assertEquals(currentY, ball.getY());
            }
        });
    }

    static Stream<Arguments> moveProvider() {
        return Stream.of(
                Arguments.arguments(10, 20, 10, 5, 10, 10),
                Arguments.arguments(10, 20, 10, -5, 10, 100),
                Arguments.arguments(10, 2, 10, 5, -10, 1000));
    }

    int startX = 0;
    int startY = 0;
    int deltaX = 5;
    int deltaY = 5;
    MoveableBall ball = new MoveableBall(startX, startY, 10, Color.ORANGE);

    @BeforeAll
    void beforeRepeatedMove() {
        ball.setDX(deltaX);
        ball.setDY(deltaY);
    }

    @RepeatedTest(5)
    void testRepeatedMove(RepetitionInfo info) {
        ball.move();
        assertEquals(startX + deltaX * info.getCurrentRepetition(), ball.getX());
        assertEquals(startY + deltaY * info.getCurrentRepetition(), ball.getY());
    }
}
