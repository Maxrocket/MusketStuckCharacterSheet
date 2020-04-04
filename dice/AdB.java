package musketstuckcharactersheet.dice;

import javafx.util.Pair;

public class AdB extends Dice {

        public int count, size;

        public AdB(int count, int size) {
            this.count = count;
            this.size = size;
        }

        @Override
        public Pair<String[], int[]> roll() {
            int[] rolls = new int[count];
            String[] strings = new String[count];
            for (int i = 0; i < count; i++) {
                rolls[i] = (int) (Math.random() * size + 1);
                strings[i] = "" + rolls[i];
            }
            return new Pair(strings, rolls);
        }

        @Override
        public String toString() {
            return count + "d" + size;
        }

    }
