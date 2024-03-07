package Unit.Protoss;

import Unit.GroundUnit;

public class Zealot extends GroundUnit implements ProtossUnit {
    public Zealot() {
        super(5, 20);
    }

    @Override
    public String toString() {
        return "Zealot (현재 방어력: " + this.getDef() + ")";
    }
}
