package musketstuckcharactersheet.structures;

import java.util.ArrayList;
import java.util.HashMap;

public class Equipment extends Item {

    public ArrayList<EquipmentState> states;

    public Equipment(String name) {
        super(name);
        states = new ArrayList();
    }
    
    public EquipmentState createNewState() {
        EquipmentState state = new EquipmentState();
        states.add(state);
        return state;
    }

    public class EquipmentState {

        public boolean equiped;
        public HashMap<String, Integer> bonuses;
        public HashMap<String, Integer> limits;

        public EquipmentState() {
            equiped = false;
            bonuses = new HashMap();
            limits = new HashMap();
        }
        
        public void addBonus(String stat, int value) {
            bonuses.put(stat, value);
        }
        
        public void addLimit(String stat, int value) {
            bonuses.put(stat, value);
        }

    }

}
