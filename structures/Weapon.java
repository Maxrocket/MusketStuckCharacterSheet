/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musketstuckcharactersheet.structures;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Maxime
 */
public class Weapon extends Item {
    
    public ArrayList<Attack> attacks;
    public String type;
    
    public Weapon(String name, String type, ArrayList<Attack> attacks) {
        super(name);
        this.attacks = attacks;
        this.type = type;
    }

    public String attack(int index, int adv, int prof, HashMap<String, Integer> stats, String weaponProf) {
        int stat = stats.get(attacks.get(index).abi);
        if (!weaponProf.equals(type)) {
            prof = 0;
        }
        
        String output = attacks.get(index).attack(adv, prof, stat);

        return output;
    }

}
