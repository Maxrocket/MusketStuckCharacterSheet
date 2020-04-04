package musketstuckcharactersheet.dice;

public class DiceParser {

    public Die parse(String die) {
        die = die.trim();
        Die cur = null;
        int nextOp = -1;
        Die nextDie;
        while (die.length() > 0) {
            String next = "";
            if (die.charAt(0) == '(') {
                die = die.substring(1);
                String bracketed = "";
                while (die.charAt(0) != ')') {
                    bracketed += die.charAt(0);
                    die = die.substring(1);
                }
                die = die.substring(1);
                cur = updateDie(cur, nextOp, parse(bracketed));
            } else {
                while (die.charAt(0) > 47 && die.charAt(0) < 58) {
                    next += die.charAt(0);
                    die = die.substring(1);
                    if (die.length() == 0) {
                        die = " ";
                    }
                }
                int count = Integer.parseInt(next);
                if (die.charAt(0) == 'd') {
                    next = "";
                    die = die.substring(1);
                    while (die.charAt(0) > 47 && die.charAt(0) < 58) {
                        next += die.charAt(0);
                        die = die.substring(1);
                        if (die.length() == 0) {
                            die = " ";
                        }
                    }
                    int size = Integer.parseInt(next);
                    cur = updateDie(cur, nextOp, new Die(new AdB(count, size)));
                } else {
                    cur = updateDie(cur, nextOp, new Die(new C(count)));
                }
            }
            die = die.trim();
            if (die.length() > 0) {
                switch (die.charAt(0)) {
                    case '+':
                        nextOp = 0;
                        die = die.substring(1);
                        break;
                    case '-':
                        nextOp = 1;
                        die = die.substring(1);
                        break;
                    case '*':
                        nextOp = 2;
                        die = die.substring(1);
                        break;
                    case '/':
                        nextOp = 3;
                        die = die.substring(1);
                        break;
                    default:
                        nextOp = -1;
                        break;
                }
            }
        }
        return cur;
    }

    public Die updateDie(Die ds0, int op, Die ds1) {
        if (ds0 == null) {
            return ds1;
        }
        return new Die(ds0, op, ds1);
    }

}
