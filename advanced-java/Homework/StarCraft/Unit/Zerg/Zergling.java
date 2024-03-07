package Unit.Zerg;

import Unit.GroundUnit;

public class Zergling extends GroundUnit implements ZergUnit {
    public Zergling() {
        super(2, 2);
    }

    @Override
    public String toString() {
        return "Zergling (현재 방어력: " + this.getDef() + ")";
    }
}