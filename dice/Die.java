package musketstuckcharactersheet.dice;

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

        public int roll() {
            switch (op) {
                case 0:
                    return ds0.roll() + ds1.roll();
                case 1:
                    return ds0.roll() - ds1.roll();
                case 2:
                    return ds0.roll() * ds1.roll();
                case 3:
                    return ds0.roll() / ds1.roll();
                default:
                    return d.roll();
            }
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
