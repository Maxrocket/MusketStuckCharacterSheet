package musketstuckcharactersheet.utils;

import javafx.util.Pair;

public interface OnRoll {

    public abstract Pair<String[], int[]> onRoll(Pair<String[], int[]> rolls, int num, int type);
    
}
