package Unit.Terran;

import Unit.AirAttackingGroundUnit;

public class Goliath extends AirAttackingGroundUnit implements TerranUnit {
    public Goliath() {
        super(5, 15);
    }

    @Override
    public String toString() {
        return "Goliath (현재 방어력: " + this.getDef() + ")";
    }
}
