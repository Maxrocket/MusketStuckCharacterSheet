package musketstuckcharactersheet.structures;

import java.util.ArrayList;
import javafx.util.Pair;
import musketstuckcharactersheet.OnRoll;

public class Attack {

    public int prof;
    public int hitBonus;
    public int hitAbility;
    public ArrayList<Pair<Integer, Integer>> dmg;
    public ArrayList<Pair<Integer, Integer>> bonusDmg;
    public int crit;
    public int critMul;
    public String abi;
    public String name;

    public boolean damageAdvantage = false;

    public ArrayList<OnRoll> onRollFunctions = new ArrayList();

    public boolean straightDamage = false;

    public Attack(String name, int hitBonus, String dmg, String bonusDmg, int crit, int critMul, String abi) {
        this.name = name;
        this.hitBonus = hitBonus;
        String[] dmgS = dmg.split("\\+");
        ArrayList<Pair<Integer, Integer>> dmgDice = new ArrayList();
        for (String string : dmgS) {
            String[] dice = string.split("d");
            dmgDice.add(new Pair(Integer.parseInt(dice[0]), Integer.parseInt(dice[1])));
        }
        this.dmg = dmgDice;
        String[] bdmgS = bonusDmg.split("\\+");
        ArrayList<Pair<Integer, Integer>> bdmgDice = new ArrayList();
        if (!bonusDmg.equals("")) {
            for (String string : bdmgS) {
                String[] bdice = string.split("d");
                bdmgDice.add(new Pair(Integer.parseInt(bdice[0]), Integer.parseInt(bdice[1])));
            }
        }

        this.bonusDmg = bdmgDice;
        this.crit = crit;
        this.critMul = critMul;
        this.abi = abi;
    }

    public Attack(String name, String dmg) {
        straightDamage = true;
        this.name = name;
        String[] dmgS = dmg.split("\\+");
        ArrayList<Pair<Integer, Integer>> dmgDice = new ArrayList();
        for (String string : dmgS) {
            String[] dice = string.split("d");
            dmgDice.add(new Pair(Integer.parseInt(dice[0]), Integer.parseInt(dice[1])));
        }
        this.dmg = dmgDice;
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
            int totalDamage = 0;
            for (int j = 0; j < dmg.size(); j++) {
                if (j != 0) {
                    output += "+";
                }
                Pair<Integer, Integer> pair = dmg.get(j);
                Pair<String[], int[]> damageRolls = Dice.roll(pair.getKey(), pair.getValue(), onRollFunctions);
                output += Dice.writeDiceResult(damageRolls.getKey());
                totalDamage += Dice.total(damageRolls.getValue());
            }
            output += "=" + totalDamage;
        } else {
            hitAbility = abi;
            this.prof = prf;
            Pair<String[], int[]> hitRolls = Dice.roll(1 + Math.abs(adv), 20, onRollFunctions);
            int toHit = hitRolls.getValue()[0];
            if (adv > 0) {
                toHit = Dice.advantage(hitRolls.getValue());
            }
            if (adv < 0) {
                toHit = Dice.disadvantage(hitRolls.getValue());
            }
            boolean isCrit = false;
            if (toHit >= crit) {
                isCrit = true;
            }
            toHit += hitBonus + hitAbility + prof;
            output = "To Hit: " + Dice.writeDiceResult(hitRolls.getKey()) + "+" + hitBonus + "+" + hitAbility + "+" + prof + "=" + toHit;
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
                for (int j = 0; j < dmg.size(); j++) {
                    if (j != 0) {
                        output += "+";
                    }
                    Pair<Integer, Integer> pair = dmg.get(j);
                    Pair<String[], int[]> damageRolls = Dice.roll(pair.getKey(), pair.getValue(), onRollFunctions);
                    output += Dice.writeDiceResult(damageRolls.getKey());
                    int damageSum = Dice.total(damageRolls.getValue());
                    int damageSumAdv = 0;
                    if (damageAdvantage) {
                        Pair<String[], int[]> damageRollsAdv = Dice.roll(pair.getKey(), pair.getValue(), onRollFunctions);
                        output += Dice.writeDiceResult(damageRollsAdv.getKey());
                        damageSumAdv = Dice.total(damageRollsAdv.getValue());
                    }
                    totalDamage += Math.max(damageSum, damageSumAdv);
                }
                totalDamage += hitBonus + hitAbility;
                output += "+" + hitBonus + "+" + hitAbility;

                for (Pair<Integer, Integer> pair : bonusDmg) {
                    output += "+";
                    Pair<String[], int[]> damageRolls = Dice.roll(pair.getKey(), pair.getValue(), onRollFunctions);
                    output += Dice.writeDiceResult(damageRolls.getKey());
                    int damageSum = Dice.total(damageRolls.getValue());
                    totalDamage += damageSum;
                }
            }
            output += "=" + totalDamage;
        }

        return output;
    }

}
