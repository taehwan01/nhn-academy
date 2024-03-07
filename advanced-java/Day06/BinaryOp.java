public interface BinaryOp {
    /*
     * 인터페이스는 specification을 작성해줘야함
     * 정수형 파라미터 2개를 연산한 결과를 정수형으로 반환한다.
     */
    int apply(int i, int j);

    default int apply(int i, int j, int k) {
        return apply(apply(i, j), k);
    }
}

class Adder implements BinaryOp {
    public int apply(int i, int j) {
        return i + j;
    }
}

class Test7 {
    public static void main(String[] args) {
        BinaryOp adder = new Adder();
        System.out.println(adder.apply(3, 4));
        System.out.println(adder.apply(3, 4, 5));
    }
}