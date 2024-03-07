public class BoyFriend {
    private String name;
    private int age;

    public BoyFriend(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void hear(String message) {
        System.out.println(message);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.age + " yo.";
    }
}
