package musketstuckcharactersheet.dice;

import java.util.ArrayList;
import javafx.util.Pair;
import musketstuckcharactersheet.OnRoll;

public abstract class Dice {

    public abstract Pair<String[], int[]> roll(ArrayList<OnRoll> onRollArr);

    public abstract String toString();

}
