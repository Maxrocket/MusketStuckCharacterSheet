package musketstuckcharactersheet.dice;

import javafx.util.Pair;

public abstract class Dice {

    public abstract Pair<String[], int[]> roll();

    public abstract String toString();

}
