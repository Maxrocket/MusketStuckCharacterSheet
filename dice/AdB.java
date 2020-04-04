package musketstuckcharactersheet.dice;

public class AdB extends Dice {

        public int count, size;

        public AdB(int count, int size) {
            this.count = count;
            this.size = size;
        }

        @Override
        public int roll() {
            int total = 0;
            for (int i = 0; i < count; i++) {
                total += (int) (Math.random() * size + 1);
            }
            return total;
        }

        @Override
        public String toString() {
            return count + "d" + size;
        }

    }
