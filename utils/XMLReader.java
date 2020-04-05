package musketstuckcharactersheet.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import musketstuckcharactersheet.Window;

public class XMLReader {

    public static XMLElement parseXML(ArrayList<String> lines) {
        
        char[] chars = lines.get(0).toCharArray();
        lines.remove(0);
        if (chars[0] == '<') {
            int index = 1;
            String name = "";
            while (chars[index] != '>') {
                name += chars[index];
                index++;
            }
            if (chars.length == index + 1) {
                XMLElement parent = new XMLElement(name, "");
                while (!lines.get(0).equals("</" + name + ">")) {
                    XMLElement result = parseXML(lines);
                    parent.addChild(result);
                }
                lines.remove(0);
                return parent;
            } else {
                String textContent = "";
                index++;
                while (chars[index] != '<') {
                    textContent += chars[index];
                    index++;
                }
                return new XMLElement(name, textContent);
            }
        }
        return null;
    }

    public static XMLElement readXMLFile(String filePath) {
        ArrayList<String> lines = new ArrayList();
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            lines.add(line.trim());
            line = br.readLine();
            while (line != null) {
                lines.add(line.trim());
                line = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }

        return parseXML(lines);
    }

}
