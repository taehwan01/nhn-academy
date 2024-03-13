import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.nhnacademy.Semaphore;

class TestSemaphore {
    @Test
    void testConstructor() {
        assertDoesNotThrow(() -> new Semaphore(0));
        assertDoesNotThrow(() -> new Semaphore(1));
        assertDoesNotThrow(() -> new Semaphore(2));
        assertThrowsExactly(IllegalArgumentException.class, () -> new Semaphore(-1));
    }

    @ParameterizedTest
    @MethodSource("acquireProvider")
    void testAcquire(int permits) {
        Semaphore semaphore = new Semaphore(permits);
        semaphore.acquire();
        assertEquals(permits - 1, semaphore.availablePermits());
    }

    static Stream<Arguments> acquireProvider() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(2),
                Arguments.of(3));
    }

    @ParameterizedTest
    @MethodSource("releaseProvider")
    void testRelease(int permits) {
        Semaphore semaphore = new Semaphore(permits);
        semaphore.acquire();
        semaphore.release();
        assertEquals(permits, semaphore.availablePermits());
    }

    static Stream<Arguments> releaseProvider() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(2),
                Arguments.of(3));
    }

    @ParameterizedTest
    @MethodSource("tryAcquireProvider")
    void testTryAcquire(int permits, boolean target) {
        Semaphore semaphore = new Semaphore(permits);
        assertEquals(target, semaphore.tryAcquire());
    }

    static Stream<Arguments> tryAcquireProvider() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(2, true),
                Arguments.of(3, true),
                Arguments.of(0, false));
    }
}