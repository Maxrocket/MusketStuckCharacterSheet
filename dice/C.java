package musketstuckcharactersheet.dice;

import java.util.ArrayList;
import javafx.util.Pair;
import musketstuckcharactersheet.OnRoll;

public class C extends Dice {

        public int value;

        public C(int value) {
            this.value = value;
        }

        @Override
        public Pair<String[], int[]> roll(ArrayList<OnRoll> onRollArr) {
            return new Pair(new String[]{value + ""}, new int[]{value});
        }

        @Override
        public String toString() {
            return value + "";
        }

    }
