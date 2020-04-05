package musketstuckcharactersheet.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.util.Pair;
import musketstuckcharactersheet.utils.OnRoll;

public class Character {

    public String name;
    public int bod, dex, mnd, mag, asp;
    public int power, safety, knowledge, aspect;
    public String claspect, title;
    public int currentHp;
    public String weaponProf;
    public ArrayList<OnRoll> onRollFunctions;
    public ArrayList<Pair<String, Integer>> gristCache;
    public ArrayList<Item> inventory;
    public Armour equiped;
    public ArrayList<Armour> armourpodes;
    public ArrayList<Weapon> weapons;
    
    public static Armour DEFAULT_ARMOUR = new Armour("Default Armour", 0, 20);
    public static ArrayList<Attack> DEFAULT_ATTACK = new ArrayList<Attack>((List<Attack>)Arrays.asList(new Attack("Punch", 0, "1d4", 20, 2, "BOD")));
    public static Weapon DEFAULT_WEAPON = new Weapon("Fists", "Fist", DEFAULT_ATTACK);

    public Character(String name, int bod, int dex, int mnd, int mag, int asp, int power, int safety, int knowledge, int aspect, String claspect, String title, int currentHp, String weaponProf) {
        this.name = name;
        this.bod = bod;
        this.dex = dex;
        this.mnd = mnd;
        this.mag = mag;
        this.asp = asp;
        this.power = power;
        this.safety = safety;
        this.knowledge = knowledge;
        this.aspect = aspect;
        this.claspect = claspect;
        this.title = title;
        this.currentHp = currentHp;
        this.weaponProf = weaponProf;
        onRollFunctions = new ArrayList();
        gristCache = new ArrayList();
        inventory = new ArrayList();
        armourpodes = new ArrayList();
        weapons = new ArrayList();
        equiped = DEFAULT_ARMOUR;
    }

    public void addOnRoll(OnRoll r) {
        onRollFunctions.add(r);
    }

    public ArrayList<OnRoll> getOnRollFunctions() {
        return onRollFunctions;
    }

    public void addGrist(String type, int quantity) {
        gristCache.add(new Pair(type, quantity));
    }
    
    public void addItem(Item item) {
        inventory.add(item);
        if (item instanceof Armour) {
            armourpodes.add((Armour) item);
        } else if (item instanceof Weapon) {
            weapons.add((Weapon) item);
        }
    }

}
