public class Test {
    // List list = new ArrayList<>()
    public static void main(String[] args) {
        LinkedListGeneric<String> list = new LinkedListGeneric<>();
        list.add("Hello, ");
        list.add("World!");
        System.out.println(list);
    }
}
