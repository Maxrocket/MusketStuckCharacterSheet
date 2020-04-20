package musketstuckcharactersheet.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javafx.util.Pair;
import musketstuckcharactersheet.onFunctions.OnMod;
import musketstuckcharactersheet.onFunctions.OnRoll;

public class Character {

    public String name;
    public int bod, dex, mnd, mag, asp;
    public int bodT, dexT, mndT, magT, aspT;
    public int bodB, dexB, mndB, magB, aspB;
    public int hitBonus, damageBonus;
    public int acBonus;
    public int maxDexMod;
    public int power, safety, knowledge, aspect;
    public String claspect, title;
    public int currentHp;
    public String weaponProf;
    public HashMap<String, OnRoll> onRollFunctions;
    public HashMap<String, OnMod> onModFunctions;
    public ArrayList<Pair<String, Integer>> gristCache;
    public ArrayList<Item> inventory;
    public ArrayList<Equipment> equipment;
    public ArrayList<Weapon> weapons;
    public ArrayList<String> skillProficiencies;
    public ArrayList<String[]> techniques;
    public HashMap<String, Integer> resources;
    
    public Equipment DEFAULT_ARMOUR = new Armour("Default Armour", 0, 100);
    public ArrayList<Attack> DEFAULT_ATTACK = new ArrayList<Attack>((List<Attack>)Arrays.asList(new Attack("Punch", 0, "1d4", 20, 2, "BOD", this)));
    public Weapon DEFAULT_WEAPON = new Weapon("Fists", "Fist", DEFAULT_ATTACK);

    public Character(String name, int bod, int dex, int mnd, int mag, int asp,
            int bodT, int dexT, int mndT, int magT, int aspT,
            int power, int safety, int knowledge, int aspect,
            String claspect, String title, int currentHp, String weaponProf) {
        this.name = name;
        this.bod = bod;
        this.dex = dex;
        this.mnd = mnd;
        this.mag = mag;
        this.asp = asp;
        this.bodT = bodT;
        this.dexT = dexT;
        this.mndT = mndT;
        this.magT = magT;
        this.aspT = aspT;
        this.power = power;
        this.safety = safety;
        this.knowledge = knowledge;
        this.aspect = aspect;
        this.claspect = claspect;
        this.title = title;
        this.currentHp = currentHp;
        this.weaponProf = weaponProf;
        onRollFunctions = new HashMap();
        onModFunctions = new HashMap();
        gristCache = new ArrayList();
        inventory = new ArrayList();
        equipment = new ArrayList();
        weapons = new ArrayList();
        skillProficiencies = new ArrayList();
        techniques = new ArrayList();
        resources = new HashMap();
    }

    public void addOnRoll(String name, OnRoll r) {
        onRollFunctions.put(name, r);
    }

    public ArrayList<OnRoll> getOnRollFunctions() {
        return new ArrayList<>(onRollFunctions.values());
    }
    
    public void addOnMod(String name, OnMod r) {
        onModFunctions.put(name, r);
    }

    public ArrayList<OnMod> getOnModFunctions() {
        return new ArrayList<>(onModFunctions.values());
    }

    public void addGrist(String type, int quantity) {
        gristCache.add(new Pair(type, quantity));
    }
    
    public void addItem(Item item) {
        inventory.add(item);
        if (item instanceof Equipment) {
            equipment.add((Equipment) item);
        } else if (item instanceof Weapon) {
            weapons.add((Weapon) item);
        }
    }

}
