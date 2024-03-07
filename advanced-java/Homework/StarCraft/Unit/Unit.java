package Unit;

public abstract class Unit {
    private int atk;
    private int def;

    public Unit(int atk, int def) {
        this.atk = atk;
        this.def = def;
    }

    public int getAtk() {
        return this.atk;
    }

    public int getDef() {
        return this.def;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void defend(int damage) {
        this.setDef(this.getDef() - damage);
    }

    public abstract String toString();
}
