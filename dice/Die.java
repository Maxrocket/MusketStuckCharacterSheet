package musketstuckcharactersheet.dice;

import java.util.ArrayList;
import java.util.Comparator;
import javafx.util.Pair;
import musketstuckcharactersheet.utils.OnRoll;

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

    public Pair<String, Integer> roll(ArrayList<OnRoll> onRollArr, OnRoll.Trigger trigger) {
        ArrayList<Pair<String, Integer>> rolls = new ArrayList<>();
        if (op == -1) {
            if (d instanceof C) {
                return new Pair(d.roll(onRollArr, trigger).getKey()[0], d.roll(onRollArr, trigger).getValue()[0]);
            }
            //roll
            for (int i = 0; i < rollCount; i++) {
                Pair<String[], int[]> dp = d.roll(onRollArr, trigger);
                rolls.add(collapseDice(dp.getKey(), dp.getValue()));
            }
            //find selected
            ArrayList<Pair<String, Integer>> sorted = (ArrayList<Pair<String, Integer>>) (rolls.clone());
            sorted.sort(sorter);
            Pair<String, Integer> chosen = sorted.get(0);
            if (!adv) {
                chosen = sorted.get(sorted.size() - 1);
            }
            //combine strings
            String str = rolls.get(0).getKey();
            if (rollCount > 1) {
                str = "";
                for (Pair<String, Integer> roll : rolls) {
                    str += roll.getKey();
                }
                //isolate selected roll
                String chose = chosen.getKey();
                int pos = str.indexOf(chose);
                chose = "{" + chose.substring(1, chose.length() - 1) + "}";
                //put together and return
                str = str.substring(0, pos) + chose + str.substring(pos + chose.length());
            }
            return new Pair(str, chosen.getValue());
        } else {
            //roll
            for (int i = 0; i < rollCount; i++) {
                Pair<String, Integer> ds0p = ds0.roll(onRollArr, trigger);
                Pair<String, Integer> ds1p = ds1.roll(onRollArr, trigger);
                rolls.add(collapseDie(ds0p.getKey(), ds1p.getKey(), ds0p.getValue(), ds1p.getValue(), op));
            }
            //find selected
            ArrayList<Pair<String, Integer>> sorted = (ArrayList<Pair<String, Integer>>) (rolls.clone());
            sorted.sort(sorter);
            Pair<String, Integer> chosen = sorted.get(0);
            if (!adv) {
                chosen = sorted.get(sorted.size() - 1);
            }
            //combine strings
            String str = rolls.get(0).getKey();
            if (rollCount > 1) {
                str = "";
                for (Pair<String, Integer> roll : rolls) {
                    str += "(" + roll.getKey() + ")";
                }
                //isolate selected roll
                String chose = "(" + chosen.getKey() + ")";
                int pos = str.indexOf(chose);
                chose = "{" + chose.substring(1, chose.length() - 1) + "}";
                //put together and return
                str = str.substring(0, pos) + chose + str.substring(pos + chose.length());
            }
            return new Pair(str, chosen.getValue());
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
