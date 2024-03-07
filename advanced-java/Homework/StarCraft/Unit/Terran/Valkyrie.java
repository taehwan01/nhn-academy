package Unit.Terran;

import Unit.AirUnit;

public class Valkyrie extends AirUnit implements TerranUnit {
    public Valkyrie() {
        super(4, 12);
    }

    @Override
    public String toString() {
        return "Valkyrie (현재 방어력: " + this.getDef() + ")";
    }
}
