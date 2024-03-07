package Species;

import Unit.Unit;
import Unit.Terran.*;
import Unit.Protoss.*;
import Unit.Zerg.*;

public abstract class UnitsGenerator {
        public static Unit randomGenerator(String species) {
                if (species.equals("Terran")) {
                        TerranUnit[] terranUnits = { new Marine(), new Tank(), new Goliath(), new Wraith(),
                                        new Valkyrie() };
                        return (Unit) terranUnits[(int) (Math.random() * terranUnits.length)];
                } else if (species.equals("Protoss")) {
                        ProtossUnit[] protossUnits = { new Zealot(), new Dragoon(), new HighTemplar(),
                                        new Scout(),
                                        new Corsair() };
                        return (Unit) protossUnits[(int) (Math.random() * protossUnits.length)];
                } else {
                        ZergUnit[] zergUnits = { new Zergling(), new Hydralisk(),
                                        new Ultralisk(), new Mutalisk(),
                                        new Guardian(),
                        };
                        return (Unit) zergUnits[(int) (Math.random() * zergUnits.length)];
                }
        }
}
