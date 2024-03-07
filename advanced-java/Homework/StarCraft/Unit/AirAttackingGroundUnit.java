package Unit;

import Attackable.*;

public abstract class AirAttackingGroundUnit extends Unit implements AirUnitAttackable, GroundUnitAttackable {

    public AirAttackingGroundUnit(int atk, int def) {
        super(atk, def);
    }

    @Override
    public void attack(GroundUnit targetUnit) {
        targetUnit.defend(this.getAtk());
    }

    @Override
    public void attack(AirUnit targetUnit) {
        targetUnit.defend(this.getAtk());
    }

}
