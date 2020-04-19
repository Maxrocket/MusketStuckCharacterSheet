package musketstuckcharactersheet.onFunctions;

import musketstuckcharactersheet.Window;
import musketstuckcharactersheet.structures.Character;

public abstract class OnMod {
    
    public OnMod() {
        
    }

    public abstract Character modStats(Character character, Window frame);
    
}
