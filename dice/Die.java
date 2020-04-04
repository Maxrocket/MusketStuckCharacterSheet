package musketstuckcharactersheet.dice;

import java.util.ArrayList;
import java.util.Comparator;
import javafx.util.Pair;
import musketstuckcharactersheet.OnRoll;

public class Die {

    Dice d = null;
    int op = -1; // 0+, 1-, 2*, 3/
    Die ds0 = null;
    Die ds1 = null;

    int rollCount = 1;
    boolean adv;

    Comparator<Pair<String, Integer>> sorter = new Comparator<Pair<String, Integer>>() {
        @Override
        public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
            return o2.getValue() - o1.getValue();
        }
    };

    public Die(Dice d) {
        this.d = d;
    }

    public Die(Die ds0, int op, Die ds1) {
        this.ds0 = ds0;
        this.op = op;
        this.ds1 = ds1;
    }

    public Pair<String, Integer> roll(ArrayList<OnRoll> onRollArr) {
        ArrayList<Pair<String, Integer>> rolls = new ArrayList<>();
        if (op == -1) {
            //roll
            for (int i = 0; i < rollCount; i++) {
                Pair<String[], int[]> dp = d.roll(onRollArr);
                rolls.add(collapseDice(dp.getKey(), dp.getValue()));
            }
            //find selected
            ArrayList<Pair<String, Integer>> sorted = (ArrayList<Pair<String, Integer>>)(rolls.clone());
            sorted.sort(sorter);
            Pair<String, Integer> chosen = sorted.get(0);
            if (!adv){
                chosen = rolls.get(sorted.size() - 1);
            }
            //combine strings
            String str = "";
            for (Pair<String, Integer> roll : rolls) {
                str += roll.getKey();
            }
            //isolate selected roll
            String chose = chosen.getKey();
            String[] ss = str.split(chose, 2);
            chose = "{" + chose.substring(1, chose.length()) + "}";
            //put together and return
            return new Pair(ss[0] + chose + ss[1], chosen.getValue());
        } else {
            //roll
            for (int i = 0; i < rollCount; i++) {
                Pair<String, Integer> ds0p = ds0.roll(onRollArr);
                Pair<String, Integer> ds1p = ds1.roll(onRollArr);
                rolls.add(collapseDie(ds0p.getKey(), ds1p.getKey(), ds0p.getValue(), ds1p.getValue(), op));
            }
            //find selected
            ArrayList<Pair<String, Integer>> sorted = (ArrayList<Pair<String, Integer>>)(rolls.clone());
            sorted.sort(sorter);
            Pair<String, Integer> chosen = sorted.get(0);
            if (!adv){
                chosen = rolls.get(sorted.size() - 1);
            }
            //combine strings
            String str = "";
            for (Pair<String, Integer> roll : rolls) {
                str += "(" + roll.getKey() + ")";
            }
            //isolate selected roll
            String chose = "(" + chosen.getKey() + ")";
            String[] ss = str.split(chose, 2);
            chose = "{" + chose.substring(1, chose.length()) + "}";
            //put together and return
            return new Pair(ss[0] + chose + ss[1], chosen.getValue());
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
