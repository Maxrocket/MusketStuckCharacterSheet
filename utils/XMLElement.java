package musketstuckcharactersheet.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class XMLElement {
    
    public String name;
    public String textContent;
    public HashMap<String, ArrayList<XMLElement>> children;
    
    public XMLElement(String name, String textContent) {
        this.name = name;
        this.textContent = textContent;
        this.children = new HashMap();
    }
    
    public void addChild(XMLElement child) {
        if (children.containsKey(child.name)) {
            children.get(child.name).add(child);
        } else {
            ArrayList<XMLElement> elements = new ArrayList();
            elements.add(child);
            children.put(child.name, elements);
        }
    }
    
}
