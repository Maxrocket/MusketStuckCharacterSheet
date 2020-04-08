package musketstuckcharactersheet.utils;

import javafx.util.Pair;

public abstract class OnRoll {
    
    public enum Trigger {ROLL, ATTACK, DAMAGE, ABILITY, SAVE, LOOT}
    public Trigger[] triggers;
    
    public OnRoll(Trigger[] triggers) {
        this.triggers = triggers;
    }

    public abstract Pair<String[], int[]> onRoll(Pair<String[], int[]> rolls, int num, int type);
    
}
