package Species;

import java.util.ArrayList;
import java.util.List;

import Unit.Unit;

public abstract class Species {
    private List<Unit> units;

    public Species() {
        this.units = new ArrayList<>();
    }

    public List<Unit> getUnits() {
        return this.units;
    }

    protected void addUnit(Unit unit) {
        this.units.add(unit);
    }

    protected void deleteUnit(int index) {
        this.units.remove(index);
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.units.size(); i++) {
            if (this.units.get(i).getDef() <= 0) {
                continue;
            }
            s += i + ". " + this.units.get(i).toString() + "\n";
        }
        return s;
    }
}
