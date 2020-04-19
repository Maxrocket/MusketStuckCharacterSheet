package musketstuckcharactersheet.dice;

import java.util.ArrayList;
import javafx.util.Pair;
import musketstuckcharactersheet.onFunctions.OnRoll;

public abstract class Dice {

    public abstract Pair<String[], int[]> roll(ArrayList<OnRoll> onRollArr, OnRoll.Trigger trigger);

    public abstract String toString();

}
