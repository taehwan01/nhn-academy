package Unit.Protoss;

import Unit.AirUnit;

public class Scout extends AirUnit implements ProtossUnit {
    public Scout() {
        super(5, 10);
    }

    @Override
    public String toString() {
        return "Scout (현재 방어력: " + this.getDef() + ")";
    }
}
