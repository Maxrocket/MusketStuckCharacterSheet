package musketstuckcharactersheet;

import java.util.ArrayList;
import java.util.Optional;
import javafx.util.Pair;

public class Item {

    public Optional<ArrayList<Pair<String, Integer>>> recipe;
    public String name;
    
    public Item(String name, Optional<ArrayList<Pair<String, Integer>>> recipe) {
        this.name = name;
        this.recipe = recipe;
    }
    
    public Item(String name) {
        this.name = name;
    }

}
