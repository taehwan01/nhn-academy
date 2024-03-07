package Attackable;

import Unit.GroundUnit;

public interface GroundUnitAttackable extends Attackable {
    public void attack(GroundUnit targeUnit);
}