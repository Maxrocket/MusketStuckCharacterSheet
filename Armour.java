package musketstuckcharactersheet;

import java.util.ArrayList;
import java.util.Optional;
import javafx.util.Pair;

public class Armour extends Item {
    
    public int acBonus, maxDexMod;
    
    public Armour(String name, Optional<ArrayList<Pair<String, Integer>>> recipe, int acBonus, int maxDexMod) {
        super(name, recipe);
        this.acBonus = acBonus;
        this.maxDexMod = maxDexMod;
    }
    
    public Armour(String name, int acBonus, int maxDexMod) {
        super(name);
        this.acBonus = acBonus;
        this.maxDexMod = maxDexMod;
    }
    
}
