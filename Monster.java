package musketstuckcharactersheet;

import java.util.HashMap;
import java.util.Map;

public class Monster {
    
    public String name;
    public HashMap<String, String> loot;
    
    public Monster(String name) {
        this.name = name;
        this.loot = new HashMap();
    }
    
    public HashMap<String, Integer> loot(int q) {
        HashMap<String, Integer> lootResults = new HashMap();
        for (Map.Entry<String, String> entry : loot.entrySet()) {
            String[] xs = entry.getValue().split("d");
            lootResults.put(entry.getKey(), roll(Integer.parseInt(xs[0]) * q, Integer.parseInt(xs[1])));
        }
        return lootResults;
    }
    
    public int roll(int num, int type) {
        int rolls = 0;
        for (int i = 0; i < num; i++) {
            rolls += (int) Math.ceil(Math.random() * (type + 0.0));
        }

        return rolls;
    }
    
    public void addLoot(String type, String q) {
        loot.put(type, q);
    }
    
}
