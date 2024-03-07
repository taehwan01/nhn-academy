import java.util.List;
import java.util.Scanner;

import Species.Protoss;
import Species.Species;
import Species.Terran;
import Species.Zerg;
import Unit.AirUnit;
import Unit.GroundUnit;
import Unit.Unit;

public class User {
    private static Species species;

    public static void chooseSpecies() {
        System.out.println("* 종족을 선택해주세요.");
        System.out.println("* Terran (5개의 유닛)");
        System.out.println("* Protoss (4개의 유닛)");
        System.out.println("* Zerg (8개의 유닛)");

        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();

        switch (userInput) {
            case "Terran":
                species = new Terran();
                break;
            case "Protoss":
                species = new Protoss();
                break;
            case "Zerg":
                species = new Zerg();
                break;
            default:
                System.out.println("* Terran, Protoss, Zerg 중에 하나를 입력해주세요.");
                chooseSpecies();
        }
    }

    public static void showUnits() {
        System.out.println("아군 " + species.getClass().getSimpleName());
        System.out.println(species.toString());
    }

    public static void attack() {
        System.out.print("* 공격을 실행할 유닛을 선택해주세요. ");
        Scanner sc = new Scanner(System.in);
        int attackerIndex = sc.nextInt();
        while (true) {
            if (attackerIndex < 0 || attackerIndex >= getUnits().size()) {
                System.out.print("* 잘못된 번호입니다. 다시 입력해주세요. ");
                attackerIndex = sc.nextInt();
            } else if (isDead(attackerIndex)) {
                System.out.print("* 이미 죽은 유닛입니다. 다시 입력해주세요. ");
                attackerIndex = sc.nextInt();
            } else {
                break;
            }
        }
        int damage = getUnits().get(attackerIndex).getAtk();

        System.out.print("* 공격할 대상을 선택해주세요. ");
        int targetIndex = sc.nextInt();
        while (true) {
            if (targetIndex < 0 || targetIndex >= Computer.getUnits().size()) {
                System.out.print("* 잘못된 번호입니다. 다시 입력해주세요. ");
                targetIndex = sc.nextInt();
            } else if (Computer.isDead(targetIndex)) {
                System.out.print("* 이미 죽은 유닛입니다. 다시 입력해주세요. ");
                targetIndex = sc.nextInt();
            } else if (getUnits().get(attackerIndex) instanceof GroundUnit
                    && Computer.getUnits().get(targetIndex) instanceof AirUnit) {
                System.out.print("* 지상 유닛은 지상 유닛만 공격할 수 있습니다. 다시 입력해주세요. ");
                targetIndex = sc.nextInt();
            } else {
                break;
            }
        }
        Computer.getUnits().get(targetIndex).defend(damage);
        System.out.println("[USER] " + attackerIndex + "번 유닛이 " + targetIndex + "번 유닛을 공격했습니다.");
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
