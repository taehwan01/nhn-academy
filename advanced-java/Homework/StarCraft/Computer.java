import java.util.List;

import Species.Protoss;
import Species.Species;
import Species.Terran;
import Species.Zerg;
import Unit.AirUnit;
import Unit.GroundUnit;
import Unit.Unit;

public class Computer {
    private static Species species;

    public static void chooseSpecies() {
        int randomNumber = (int) (Math.random() * 3) + 1;
        switch (randomNumber) {
            case 1:
                species = new Terran();
                break;
            case 2:
                species = new Protoss();
                break;
            case 3:
                species = new Zerg();
                break;
            default:
                break;
        }
    }

    public static void showUnits() {
        System.out.println("적군 " + species.getClass().getSimpleName());
        System.out.println(species.toString());
    }

    public static void attack() {
        int attackerIndex = (int) (Math.random() * getUnits().size());
        while (isDead(attackerIndex)) {
            attackerIndex = (int) (Math.random() * getUnits().size());
        }
        int damage = getUnits().get(attackerIndex).getAtk();

        int targetIndex = (int) (Math.random() * User.getUnits().size());
        while (true) {
            if (User.isDead(targetIndex)) {
                targetIndex = (int) (Math.random() * User.getUnits().size());
            } else if (getUnits().get(attackerIndex) instanceof GroundUnit
                    && User.getUnits().get(targetIndex) instanceof AirUnit) {
                targetIndex = (int) (Math.random() * User.getUnits().size());
            } else {
                break;
            }
        }
        User.getUnits().get(targetIndex).defend(damage);

        System.out.println("[COMPUTER] " + attackerIndex + "번 유닛이 " + targetIndex + "번 유닛을 공격했습니다.");
    }

    public static List<Unit> getUnits() {
        return species.getUnits();
    }

    public static boolean isDead(int index) {
        return getUnits().get(index).getDef() <= 0;
    }

    public static boolean lose() {
        for (Unit unit : getUnits()) {
            if (unit.getDef() > 0) {
                return false;
            }
        }
        return true;
    }
}
