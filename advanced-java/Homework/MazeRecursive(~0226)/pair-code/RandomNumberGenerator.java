public class RandomNumberGenerator {
    static int get(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

}
