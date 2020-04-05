package musketstuckcharactersheet.structures;

import java.util.ArrayList;
import javafx.util.Pair;
import musketstuckcharactersheet.OnRoll;

public class Dice {

//    public static Pair<String[], int[]> roll(int num, int type, ArrayList<OnRoll> onRollFunctions) {
//        Pair<String[], int[]> rolls = new Pair(new String[num], new int[num]);
//        for (int i = 0; i < num; i++) {
//            int roll = (int) Math.ceil(Math.random() * (type + 0.0));
//            rolls.getKey()[i] = roll + "";
//            rolls.getValue()[i] = roll;
//        }
//        for (OnRoll onRollFunction : onRollFunctions) {
//            rolls = onRollFunction.onRoll(rolls, num, type);
//        }
//
//        return rolls;
//    }
//    
//    public static Pair<String[], int[]> roll(int num, int type) {
//        Pair<String[], int[]> rolls = new Pair(new String[num], new int[num]);
//        for (int i = 0; i < num; i++) {
//            int roll = (int) Math.ceil(Math.random() * (type + 0.0));
//            rolls.getKey()[i] = roll + "";
//            rolls.getValue()[i] = roll;
//        }
//
//        return rolls;
//    }

    public static int count(int x, int[] xs) {
        int c = 0;
        for (int y : xs) {
            if (x == y) {
                c++;
            }
        }
        return c;
    }

    public static String writeDiceResult(String[] diceResults) {
        String output = "(" + diceResults[0];
        for (int i = 1; i < diceResults.length; i++) {
            output += "," + diceResults[i];
        }
        return output + ")";
    }

    public static int advantage(int[] rolls) {
        int max = rolls[0];
        for (int i = 1; i < rolls.length; i++) {
            max = Math.max(max, rolls[i]);
        }
        return max;
    }

    public static int disadvantage(int[] rolls) {
        int min = rolls[0];
        for (int i = 1; i < rolls.length; i++) {
            min = Math.min(min, rolls[i]);
        }
        return min;
    }

    public static int total(int[] arr) {
        int total = 0;
        for (int i : arr) {
            total += i;
        }
        return total;
    }
    
}
