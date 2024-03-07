import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.nhnacademy.Ball;

class TestBall {
    @ParameterizedTest
    @MethodSource("constructorProvider")
    void testConstructor(int x, int y, int radius) {
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            new Ball(x, y, radius);
        });
    }

    static Stream<Arguments> constructorProvider() {
        return Stream.of(Arguments.arguments(1, 1, Integer.MAX_VALUE),
                Arguments.arguments(Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2, Integer.MAX_VALUE));
    }

    @ParameterizedTest
    @MethodSource("illegalArgumentExceptionProvider")
    void testConstructorWithIllegalArgumentException(int x, int y, int radius) {
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            new Ball(x, y, radius);
        });
    }

    static Stream<Arguments> illegalArgumentExceptionProvider() {
        return Stream.of(Arguments.arguments(1, 2, 0),
                Arguments.arguments(1, 2, Integer.MAX_VALUE),
                Arguments.arguments(1, 2, Integer.MIN_VALUE));
    }

    @ParameterizedTest
    @MethodSource("toStringProvider")
    void testToString(int x, int y, int radius, String target) {
        // assertThrowsExactly(IllegalArgumentException.class, () -> {
        // Ball ball = new Ball(x, y, radius);
        // assertEquals(target, ball.toString());
        // });
        Ball ball = new Ball(x, y, radius);
        assertEquals(target, ball.toString());
    }

    static Stream<Arguments> toStringProvider() {
        return Stream.of(Arguments.arguments(1, 1, 1, "( 1, 1, 1 )"));
    }
}
