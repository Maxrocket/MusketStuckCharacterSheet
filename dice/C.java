package musketstuckcharactersheet.dice;

import javafx.util.Pair;

public class C extends Dice {

        public int value;

        public C(int value) {
            this.value = value;
        }

        @Override
        public Pair<String[], int[]> roll() {
            return new Pair(new String[]{value + ""}, new int[]{value});
        }

        @Override
        public String toString() {
            return value + "";
        }

    }
