package Unit.Zerg;

import Unit.GroundUnit;

public class Ultralisk extends GroundUnit implements ZergUnit {
    public Ultralisk() {
        super(5, 15);
    }

    @Override
    public String toString() {
        return "Ultralisk (현재 방어력: " + this.getDef() + ")";
    }
}