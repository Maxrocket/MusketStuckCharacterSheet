/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musketstuckcharactersheet.structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import javafx.util.Pair;

/**
 *
 * @author Maxime
 */
public class Weapon extends Item {
    
    public ArrayList<Attack> attacks;

    public Weapon(String name, Optional<ArrayList<Pair<String, Integer>>> recipe, ArrayList<Attack> attacks) {
        super(name, recipe);
        this.attacks = attacks;
    }
    
    public Weapon(String name, ArrayList<Attack> attacks) {
        super(name);
        this.attacks = attacks;
    }

    public String attack(int index, int adv, int prof, HashMap<String, Integer> stats) {
        int stat = stats.get(attacks.get(index).abi);
        String output = attacks.get(index).attack(adv, prof, stat);

        return output;
    }

}
