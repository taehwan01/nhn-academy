package Species;

public class Protoss extends Species {
    public Protoss() {
        super();

        for (int i = 0; i < 4; i++) {
            this.addUnit(UnitsGenerator.randomGenerator("Protoss"));
        }
    }
}
