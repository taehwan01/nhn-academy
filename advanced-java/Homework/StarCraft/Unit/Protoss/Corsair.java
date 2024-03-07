package Unit.Protoss;

import Unit.AirUnit;

public class Corsair extends AirUnit implements ProtossUnit {
    public Corsair() {
        super(4, 12);
    }

    @Override
    public String toString() {
        return "Corsair (현재 방어력: " + this.getDef() + ")";
    }
}
