public class StringTest {
    public static void main(String[] args) {
        String s1 = new String("ABC");
        String s2 = s1;
        // 새로운 객체를 만들어서 던짐. String은 불변 객체로, s1이 가리키는 객체의 내용을 바꾸는 것이 아니라 새로운 객체를 만들어서 던짐.
        // 이것이 immutable한 객체의 특징.

        s2 = "Celine";

        System.out.println(s1);
        System.out.println(s2);
    }
}
