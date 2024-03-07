package Unit;

import Attackable.GroundUnitAttackable;

public abstract class GroundUnit extends Unit implements GroundUnitAttackable {
    public GroundUnit(int atk, int def) {
        super(atk, def);
    }

    @Override
    public void attack(GroundUnit targetUnit) {
        targetUnit.defend(this.getAtk());
    }
}
