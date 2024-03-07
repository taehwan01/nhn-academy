package Unit.Zerg;

import Unit.AirUnit;

public class Mutalisk extends AirUnit implements ZergUnit {
    public Mutalisk() {
        super(2, 8);
    }

    @Override
    public String toString() {
        return "Mutalisk (현재 방어력: " + this.getDef() + ")";
    }
}