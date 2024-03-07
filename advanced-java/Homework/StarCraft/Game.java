public class Game {
    public static void main(String[] args) {
        chooseSpecies();
        showUnits();

        while (!(User.lose()) && !(Computer.lose())) {
            attack();
            showUnits();
        }

        System.out.println(User.lose() ? "___ 졌습니다. ___" : "*** 이겼습니다! ***");
    }

    public static void chooseSpecies() {
        Computer.chooseSpecies();
        User.chooseSpecies();
    }

    public static void showUnits() {
        Computer.showUnits();
        User.showUnits();
    }

    public static void attack() {
        Computer.attack();
        User.attack();
    }
}
