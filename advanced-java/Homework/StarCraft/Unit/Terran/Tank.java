package Unit.Terran;

import Unit.GroundUnit;

public class Tank extends GroundUnit implements TerranUnit {
    public Tank() {
        super(7, 15);
    }

    @Override
    public String toString() {
        return "Tank (현재 방어력: " + this.getDef() + ")";
    }
}
