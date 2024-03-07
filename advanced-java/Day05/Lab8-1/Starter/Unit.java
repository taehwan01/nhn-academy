public class Unit {
    int hp;
    String name;

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }
}

class Zealot extends Unit {
    public void attack() {
        System.out.println("Zealot attack");
    }
}

class Test2 {
    public static void main(String[] args) {
        Unit unit;
        Zealot zealot = new Zealot();

        unit = zealot;

        Unit unit2 = new Unit();
        // zealot = unit2; // 컴파일 에러가 발생합니다. 왜냐하면 Unit은 Zealot보다 상위 클래스이기 때문입니다.
        // 따라서 명시적으로 형변환을 해주어야 합니다.
        zealot = (Zealot) unit2;

        Unit unitAttack = new Zealot();
        // unitAttack.attack(); // 컴파일 에러가 발생합니다. 왜냐하면 Unit 클래스에는 attack 메소드가 없기 때문입니다.
        ((Zealot) unitAttack).attack(); // 명시적으로 형변환을 해주어야 합니다.
    }
}