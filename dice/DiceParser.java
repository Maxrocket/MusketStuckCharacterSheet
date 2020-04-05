package musketstuckcharactersheet.dice;

public class DiceParser {

    public static Die parse(String die) {
        System.out.println(die);
        die = die.replace(" ", "");
        Die cur = null; //die to be made
        int nextOp = -1; //operation before next die
        while (die.length() > 0) {
            String next = "";
            if (die.charAt(0) == '(') { // if brackets
                die = die.substring(1);
                String bracketed = "";
                while (die.charAt(0) != ')') { //find end of brackets
                    bracketed += die.charAt(0);
                    die = die.substring(1);
                }
                die = die.substring(1);
                if (die.length() == 0) {
                    die = " "; //used to prevent errors when calling at charAt(0)
                }
                Die bracketDie = parse(bracketed); //parse inside of brackets
                boolean advantage = die.charAt(0) == 'a'; //check for advantage
                if (die.charAt(0) == 'a' || die.charAt(0) == 'z') {
                    die = die.substring(1);
                    String advCount = "";
                    while (die.charAt(0) > 47 && die.charAt(0) < 58) { //get advantage count
                        advCount += die.charAt(0);
                        die = die.substring(1);
                        if (die.length() == 0) {
                            die = " ";
                        }
                    }
                    int adv = Integer.parseInt(advCount);
                    bracketDie.adv = advantage; //set advantage/disadvantage
                    bracketDie.rollCount = adv + 1; //set rolls
                }
                cur = updateDie(cur, nextOp, bracketDie); //parse inside of brackets
            } else {
                while (die.charAt(0) > 47 && die.charAt(0) < 58) { //find dice count or constant
                    next += die.charAt(0);
                    die = die.substring(1);
                    if (die.length() == 0) {
                        die = " ";
                    }
                }
                int count = Integer.parseInt(next);
                if (die.charAt(0) == 'd') { // check for dice
                    next = "";
                    die = die.substring(1);
                    while (die.charAt(0) > 47 && die.charAt(0) < 58) { //find size
                        next += die.charAt(0);
                        die = die.substring(1);
                        if (die.length() == 0) {
                            die = " ";
                        }
                    }
                    int size = Integer.parseInt(next);
                    cur = updateDie(cur, nextOp, new Die(new AdB(count, size))); //create die
                } else {
                    cur = updateDie(cur, nextOp, new Die(new C(count))); // create constant
                }
            }
            die = die.trim();
            if (die.length() > 0) { //check for operation
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

    public static Die updateDie(Die ds0, int op, Die ds1) {
        if (ds0 == null) {
            return ds1;
        }
        return new Die(ds0, op, ds1);
    }

}
