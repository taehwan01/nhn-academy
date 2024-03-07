public class PassByValue {
    static void process(int value) {
        System.out.println("전달 받은 파라미터 값: " + value);
        value = 10;
        System.out.println("함수 내에서 수정한 파라미터 값: " + value);
    }

    public static void main(String[] args) {
        int i = 5;
        System.out.println("선언한 변수의 초기 값: " + i);
        process(i);
        System.out.println("process() 호출 후의 변수 값: " + i);
    }
}
