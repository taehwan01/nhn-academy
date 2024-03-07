package Unit.Terran;

import Unit.AirUnit;

public class Wraith extends AirUnit implements TerranUnit {
    public Wraith() {
        super(3, 10);
    }

    @Override
    public String toString() {
        return "Wraith (현재 방어력: " + this.getDef() + ")";
    }
}
