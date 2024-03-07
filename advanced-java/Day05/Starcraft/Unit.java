public class Unit {
    protected int hp;
    protected int location;
    protected int attackPower;

    public int getHp() {
        return this.hp;
    }

    public void reduceHp(int power) {
        this.hp -= power;
    }

    public int getAttackPower() {
        return this.attackPower;
    }

    public void move(int location) {
        this.location = location;
    }

    public void gotAttackedBy(Unit unit) {
        System.out.println("공격 ~~~");
        this.reduceHp(unit.attackPower);
    }
}