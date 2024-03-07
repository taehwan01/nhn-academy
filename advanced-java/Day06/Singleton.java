public class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    public Singleton(int i) {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton;
    }
}

class ExtendedSingleton extends Singleton {
    public ExtendedSingleton() {
        super(1);
    }
} // Add a closing curly brace here
