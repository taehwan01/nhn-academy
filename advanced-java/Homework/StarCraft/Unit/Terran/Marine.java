package Unit.Terran;

import Unit.GroundUnit;

public class Marine extends GroundUnit implements TerranUnit {
    public Marine() {
        super(3, 10);
    }

    @Override
    public String toString() {
        return "Marine (현재 방어력: " + this.getDef() + ")";
    }
}
