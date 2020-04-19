package musketstuckcharactersheet.dice;

import java.util.ArrayList;
import javafx.util.Pair;
import musketstuckcharactersheet.onFunctions.OnRoll;

public class AdB extends Dice {

    public int count, size;

    public AdB(int count, int size) {
        this.count = count;
        this.size = size;
    }

    @Override
    public Pair<String[], int[]> roll(ArrayList<OnRoll> onRollArr, OnRoll.Trigger trigger) {
        Pair<String[], int[]> rolls = new Pair(new String[count], new int[count]);
        for (int i = 0; i < count; i++) {
            int roll = (int) (Math.random() * size + 1);
            rolls.getKey()[i] = roll + "";
            rolls.getValue()[i] = roll;
        }

        for (OnRoll onRoll : onRollArr) {
            boolean isTrigger = false;
            for (OnRoll.Trigger t : onRoll.triggers) {
                if (t == trigger) {
                    isTrigger = true;
                }
            }
            if (isTrigger) {
                rolls = onRoll.onRoll(rolls, count, size);
            }
        }

        return rolls;
    }

    @Override
    public String toString() {
        return count + "d" + size;
    }

}
