package musketstuckcharactersheet.onFunctions;

import musketstuckcharactersheet.Window;
import musketstuckcharactersheet.ui.ResourceListElement;
import musketstuckcharactersheet.structures.Character;

public class DeathConsume extends OnMod {
    
    public Character modStats(Character character, Window frame) {
        for (ResourceListElement resourceElement : frame.resourceElements) {
            if (resourceElement.name.equals("Consumptions")) {
                for (int i = 0; i < Integer.parseInt(resourceElement.counter.getValue() + ""); i++) {
                    character.dexB += 2;
                }
            }
        }
        return character;
    }

}
