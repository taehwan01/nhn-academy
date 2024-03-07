package Unit.Zerg;

import Unit.AirAttackingGroundUnit;

public class Hydralisk extends AirAttackingGroundUnit implements ZergUnit {
    public Hydralisk() {
        super(3, 7);
    }

    @Override
    public String toString() {
        return "Hydralisk (현재 방어력: " + this.getDef() + ")";
    }
}