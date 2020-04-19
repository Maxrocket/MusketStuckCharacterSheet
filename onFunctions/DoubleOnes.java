package musketstuckcharactersheet.onFunctions;

import javafx.util.Pair;

public class DoubleOnes extends OnRoll {

    public DoubleOnes() {
        super(new Trigger[]{OnRoll.Trigger.ATTACK, OnRoll.Trigger.DAMAGE});
    }

    public Pair<String[], int[]> onRoll(Pair<String[], int[]> rolls, int num, int type) {
        while (count(1, rolls.getValue()) >= 2) {
            for (int i = 0; i < num; i++) {
                if (rolls.getValue()[i] == 1) {
                    rolls.getValue()[i] = type;
                    rolls.getKey()[i] = rolls.getKey()[i] + " [" + type + "]";
                    break;
                }
            }
            for (int i = 0; i < num; i++) {
                if (rolls.getValue()[i] == 1) {
                    rolls.getValue()[i] = type;
                    rolls.getKey()[i] = rolls.getKey()[i] + " [" + type + "]";
                    break;
                }
            }
        }
        if (count(1, rolls.getValue()) == 1) {
            for (int i = 0; i < num; i++) {
                if (rolls.getValue()[i] == 1) {
                    int d6 = (int) Math.ceil(Math.random() * 6.0);
                    if (d6 == 1) {
                        rolls.getValue()[i] = type;
                        rolls.getKey()[i] = rolls.getKey()[i] + " (" + d6 + ")[" + type + "]";
                    } else {
                        rolls.getKey()[i] = rolls.getKey()[i] + " (" + d6 + ")";
                    }
                    break;
                }
            }
        }
        return rolls;
    }
    
    public int count(int x, int[] xs) {
        int c = 0;
        for (int y : xs) {
            if (x == y) {
                c++;
            }
        }
        return c;
    }

}
