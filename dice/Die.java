package musketstuckcharactersheet.dice;

import java.util.ArrayList;
import javafx.util.Pair;
import musketstuckcharactersheet.OnRoll;

public class Die {

    Dice d = null;
    int op = -1; // 0+, 1-, 2*, 3/
    Die ds0 = null;
    Die ds1 = null;

    public Die(Dice d) {
        this.d = d;
    }

    public Die(Die ds0, int op, Die ds1) {
        this.ds0 = ds0;
        this.op = op;
        this.ds1 = ds1;
    }

    public Pair<String, Integer> roll(ArrayList<OnRoll> onRollArr) {
        if (op == -1) {
            Pair<String[], int[]> dp = d.roll(onRollArr);
            return collapseDice(dp.getKey(), dp.getValue());
        } else {
            Pair<String, Integer> ds0p = ds0.roll(onRollArr);
            Pair<String, Integer> ds1p = ds1.roll(onRollArr);
            return collapseDie(ds0p.getKey(), ds1p.getKey(), ds0p.getValue(), ds1p.getValue(), op);
        }
    }

    private Pair<String, Integer> collapseDice(String[] ss, int[] is) {
        String s = "(";
        for (int i = 0; i < ss.length - 1; i++) {
            s += ss[i] + ",";
        }
        s += ss[ss.length - 1] + ")";
        int total = 0;
        for (int i : is) {
            total += i;
        }
        return new Pair(s, total);
    }

    private Pair<String, Integer> collapseDie(String s0, String s1, int i0, int i1, int op) {
        String s = "";
        int total = i0;
        switch (op) {
            case 0:
                s = s0 + "+" + s1;
                total += i1;
                break;
            case 1:
                s = "(" + s0 + ")-(" + s1 + ")";
                total -= i1;
                break;
            case 2:
                s = "(" + s0 + ")*(" + s1 + ")";
                total *= i1;
                break;
            case 3:
                s = "(" + s0 + ")/(" + s1 + ")";
                total /= i1;
                break;
        }
        return new Pair(s, total);
    }

    public String toString() {
        switch (op) {
            case 0:
                return "(" + ds0.toString() + "+" + ds1.toString() + ")";
            case 1:
                return "(" + ds0.toString() + "-" + ds1.toString() + ")";
            case 2:
                return "(" + ds0.toString() + "*" + ds1.toString() + ")";
            case 3:
                return "(" + ds0.toString() + "/" + ds1.toString() + ")";
            default:
                return d.toString();
        }
    }

}
