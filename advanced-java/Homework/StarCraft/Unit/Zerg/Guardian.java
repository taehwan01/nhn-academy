package Unit.Zerg;

import Unit.AirUnit;

public class Guardian extends AirUnit implements ZergUnit {
    public Guardian() {
        super(3, 6);
    }

    @Override
    public String toString() {
        return "Guardian (현재 방어력: " + this.getDef() + ")";
    }
}