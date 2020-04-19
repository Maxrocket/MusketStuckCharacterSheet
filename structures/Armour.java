package musketstuckcharactersheet.structures;

public class Armour extends Equipment {
    
    public int acBonus, maxDexMod;
    
    public Armour(String name, int acBonus, int maxDexMod) {
        super(name);
        EquipmentState state = createNewState();
        this.acBonus = acBonus;
        state.bonuses.put("AC", acBonus);
        this.maxDexMod = maxDexMod;
        state.limits.put("DEX", maxDexMod);
    }
    
}
