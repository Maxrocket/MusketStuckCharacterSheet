package musketstuckcharactersheet.structures;

import java.util.ArrayList;
import javafx.util.Pair;
import musketstuckcharactersheet.utils.OnRoll;
import musketstuckcharactersheet.dice.DiceParser;

public class Attack {

    public int prof;
    public int hitBonus;
    public int hitAbility;
    public String dmg;
    public int crit;
    public int critMul;
    public String abi;
    public String name;

    public boolean damageAdvantage = false;

    public ArrayList<OnRoll> onRollFunctions = new ArrayList();

    public boolean straightDamage = false;

    public Attack(String name, int hitBonus, String dmg, int crit, int critMul, String abi) {
        this.name = name;
        this.hitBonus = hitBonus;
        this.dmg = dmg;
        this.crit = crit;
        this.critMul = critMul;
        this.abi = abi;
    }

    public Attack(String name, String dmg) {
        straightDamage = true;
        this.name = name;
        this.dmg = dmg;
    }

    public void addOnRoll(OnRoll r) {
        onRollFunctions.add(r);
    }

    public void addOnRoll(ArrayList<OnRoll> rs) {
        onRollFunctions.addAll(rs);
    }

    public void setDamageAdvantage(boolean b) {
        damageAdvantage = b;
    }

    public String attack(int adv, int prf, int abi) {
        String output = "";
        if (straightDamage) {
            Pair<String, Integer> rolls = DiceParser.parse(dmg).roll(onRollFunctions);
            output += rolls.getKey() + "=" + rolls.getValue();
        } else {
            hitAbility = abi;
            this.prof = prf;
            Pair<String, Integer> hitRolls = DiceParser.parse("(1d20)a" + Math.abs(adv)).roll(onRollFunctions);
            if (adv < 0) {
                hitRolls = DiceParser.parse("(1d20)z" + Math.abs(adv)).roll(onRollFunctions);
            }
            boolean isCrit = false;
            if (hitRolls.getValue() >= crit) {
                isCrit = true;
            }       
            int toHit = hitRolls.getValue() + hitBonus + hitAbility + prof;
            output = "To Hit: " + hitRolls.getKey() + "+" + hitBonus + "+" + hitAbility + "+" + prof + "=" + toHit;
            if (isCrit) {
                output += " CRIT";
            }

            output += " - ";
            int hitTimes = 1;
            if (isCrit) {
                hitTimes = critMul;
            }
            int totalDamage = 0;
            for (int i = 0; i < hitTimes; i++) {
                if (i != 0) {
                    output += "+";
                }

                Pair<String, Integer> damageRolls = DiceParser.parse(dmg).roll(onRollFunctions);
                if (damageAdvantage) {
                    damageRolls = DiceParser.parse("(" + dmg + ")a1").roll(onRollFunctions);
                }
                totalDamage += damageRolls.getValue() + hitAbility;
                output += damageRolls.getKey() + "+" + hitAbility;
            }
            output += "=" + totalDamage;
        }

        return output;
    }

}
