public class Stack<T> {
    T[] elements = new T[3];

    public static void main(String[] args) {
        Stack<int> strStack = new Stack<int>(); 
        // 이는 컴파일 에러를 발생시킵니다. 왜냐하면 int는 참조형이 아니기 때문입니다. <> 안에는 참조형만 올 수 있습니다.
        // 왜냐하면 컴파일러는 T가 무엇인지 알 수 없기 때문입니다. 런타임에는 T가 무엇인지 알 수 있지만 컴파일 타임에는 알 수 없습니다.
    }
}
