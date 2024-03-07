public class Sample {
    public int returnToInt(long l) {
        return (int) l;
    }

    public <T extends Number> int returnToInt(T t) {
        return t.intValue();
    }

    public <T extends Number> double add(T t1, T t2) {
        return t1.doubleValue() + t2.doubleValue(); // t1 + t2 는 에러 -> 왜? t1과 t2는 Number 타입이지만, Number 타입은 + 연산자를 지원하지
                                                    // 않기 때문.
    }
}
