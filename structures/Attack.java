package musketstuckcharactersheet.structures;

import java.util.ArrayList;
import javafx.util.Pair;
import musketstuckcharactersheet.onFunctions.OnRoll;
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
    
    public String critDamage;

    public boolean damageAdvantage = false;

    public ArrayList<OnRoll> onRollFunctions = new ArrayList();

    public boolean straightDamage = false;

    public Character c;

    public Attack(String name, int hitBonus, String dmg, int crit, int critMul, String abi, Character c) {
        this.name = name;
        this.hitBonus = hitBonus;
        this.dmg = dmg;
        this.crit = crit;
        this.critMul = critMul;
        this.abi = abi;
        this.c = c;
        critDamage = "0";
    }

    public Attack(String name, String dmg, Character c) {
        straightDamage = true;
        this.name = name;
        this.dmg = dmg;
        this.c = c;
        critDamage = "0";
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
    
    public void setCritDamage(String critDamage) {
        this.critDamage = critDamage;
    }

    public String attack(int adv, int prf, int abi) {
        String output = "";
        if (straightDamage) {
            Pair<String, Integer> rolls = DiceParser.parse(dmg).roll(onRollFunctions, OnRoll.Trigger.DAMAGE);
            output += rolls.getKey() + "=" + rolls.getValue();
        } else {
            hitAbility = abi;
            this.prof = prf;
            Pair<String, Integer> hitRolls = DiceParser.parse("(1d20)a" + Math.abs(adv)).roll(onRollFunctions, OnRoll.Trigger.ATTACK);
            if (adv < 0) {
                hitRolls = DiceParser.parse("(1d20)z" + Math.abs(adv)).roll(onRollFunctions, OnRoll.Trigger.ATTACK);
            }
            boolean isCrit = false;
            if (hitRolls.getValue() >= crit) {
                isCrit = true;
            }
            int toHit = hitRolls.getValue() + hitBonus + c.hitBonus + hitAbility + prof;

            output = "To Hit: " + hitRolls.getKey();
            if (hitBonus != 0) {
                output += "+" + hitBonus;
            }
            if (c.hitBonus != 0) {
                output += "+" + c.hitBonus;
            }
            output += "+" + hitAbility;
            if (prof != 0) {
                output += "+" + prof;
            }
            output += "=" + toHit;

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

                Pair<String, Integer> damageRolls = DiceParser.parse(dmg).roll(onRollFunctions, OnRoll.Trigger.DAMAGE);
                if (damageAdvantage) {
                    damageRolls = DiceParser.parse("(" + dmg + ")a1").roll(onRollFunctions, OnRoll.Trigger.DAMAGE);
                }
                totalDamage += damageRolls.getValue() + hitAbility + c.damageBonus;
                output += damageRolls.getKey() + "+" + hitAbility;
                if (c.damageBonus != 0) {
                    output += "+" + c.damageBonus;
                }
            }
            if (isCrit && !critDamage.equals("0")) {
                Pair<String, Integer> critDamageRolls = DiceParser.parse(critDamage).roll(onRollFunctions, OnRoll.Trigger.DAMAGE);
                totalDamage += critDamageRolls.getValue();
                output += "+" + critDamageRolls.getKey();
            }

            output = output.replace("+-", "-");
            output = output.replace("--", "+");

            output += "=" + totalDamage;
            if (totalDamage < 0) {
                output += " [0]";
            }
        }

        return output;
    }

}
