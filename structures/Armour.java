package musketstuckcharactersheet.structures;

public class Armour extends Item {
    
    public int acBonus, maxDexMod;
    
    public Armour(String name, int acBonus, int maxDexMod) {
        super(name);
        this.acBonus = acBonus;
        this.maxDexMod = maxDexMod;
    }
    
}
