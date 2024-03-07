package Species;

public class Zerg extends Species {
    public Zerg() {
        super();

        for (int i = 0; i < 8; i++) {
            this.addUnit(UnitsGenerator.randomGenerator("Zerg"));
        }
    }
}
