package Species;

public class Terran extends Species {
    public Terran() {
        super();

        for (int i = 0; i < 5; i++) {
            this.addUnit(UnitsGenerator.randomGenerator("Terran"));
        }
    }
}
