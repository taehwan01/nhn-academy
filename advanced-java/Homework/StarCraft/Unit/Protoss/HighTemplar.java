package Unit.Protoss;

import Unit.GroundUnit;

public class HighTemplar extends GroundUnit implements ProtossUnit {
    public HighTemplar() {
        super(10, 2);
    }

    @Override
    public String toString() {
        return "HighTemplar (현재 방어력: " + this.getDef() + ")";
    }
}
