package musketstuckcharactersheet.structures;

import java.util.HashMap;
import java.util.Map;

public class Monster {
    
    public String name;
    public HashMap<String, String> loot;
    
    public Monster(String name) {
        this.name = name;
        this.loot = new HashMap();
    }
    
    public void addLoot(String type, String q) {
        loot.put(type, q);
    }
    
}
