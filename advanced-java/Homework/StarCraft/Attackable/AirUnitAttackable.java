package Attackable;

import Unit.AirUnit;

public interface AirUnitAttackable extends Attackable {
    public void attack(AirUnit targeUnit);
}