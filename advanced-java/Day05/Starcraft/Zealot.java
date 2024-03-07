public class Zealot {
    int hp;
    int location;
    int attackPower;

    public int getHp() {
        return this.hp;
    }

    public int getLocation() {
        return this.location;
    }

    public int getAttackPower() {
        return this.attackPower;
    }

    public void reduceHp(int attackPower) {
        this.hp -= attackPower;
    }

    public void move(int location) {
        this.location = location;
    }

    public void attack(Marine marine) {
        System.out.println("근거리에서 기관총 공격");
        marine.reduceHp(marine.getAttackPower());
    }
}