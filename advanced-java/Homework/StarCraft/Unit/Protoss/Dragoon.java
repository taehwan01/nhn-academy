package Unit.Protoss;

import Unit.AirAttackingGroundUnit;

public class Dragoon extends AirAttackingGroundUnit implements ProtossUnit {
    public Dragoon() {
        super(3, 15);
    }

    @Override
    public String toString() {
        return "Dragoon (현재 방어력: " + this.getDef() + ")";
    }
}
