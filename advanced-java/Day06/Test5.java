public class Test5 {
    public static void main(String[] args) {
        // IDCard card = new IDCard(1, "SDS");
        // System.out.println(card.getProductName());
        Product p = new IDCard(1, "SDS");
        // p.getInfo(); // 불가하다, 왜냐하면 변수의 타입인 Product에는 getInfo() 메소드가 없기 때문이다.
        // 변수의 타입을 따라가서 메소드를 찾는다.
        // 객체의 메모리 공간은 IDCard로 생성되었지만, 변수의 타입이 Product이므로 Product의 메소드만 사용할 수 있다.
        ((IDCard) p).getInfo(); // 이렇게 형변환을 통해 IDCard의 메소드를 사용할 수 있다.
        IDCard i = (IDCard) p;
        i.getInfo();
    }

}
