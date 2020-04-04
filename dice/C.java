package musketstuckcharactersheet.dice;

public class C extends Dice {

        public int value;

        public C(int value) {
            this.value = value;
        }

        @Override
        public int roll() {
            return value;
        }

        @Override
        public String toString() {
            return value + "";
        }

    }
