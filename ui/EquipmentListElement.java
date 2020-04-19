package musketstuckcharactersheet.ui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import musketstuckcharactersheet.structures.Equipment;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import musketstuckcharactersheet.Window;
import musketstuckcharactersheet.structures.Armour;

public class EquipmentListElement extends JPanel {

    public Window frame;
    public Equipment a;

    public EquipmentListElement(int y, int w, Window frame, Equipment a) {
        this.a = a;
        this.frame = frame;
        this.setLayout(null);
        this.setLocation(0, y);
        JLabel nameLabel = new JLabel("- " + a.name);
        this.add(nameLabel);
        nameLabel.setLocation(0, 0);
        nameLabel.setSize(w, 20);

        int yCount = 20;
        for (Equipment.EquipmentState state : a.states) {
            JCheckBox checkBox = new JCheckBox();
            String checkboxLabel = "  ";
            if (a instanceof Armour) {
                checkboxLabel += "AC Bonus: " + ((Armour) a).acBonus + ", Max Dex Mod: " + ((Armour) a).maxDexMod;
            } else {
                for (Map.Entry<String, Integer> entry : state.bonuses.entrySet()) {
                    checkboxLabel += entry.getKey() + ": +" + entry.getValue() + ", ";
                }
                for (Map.Entry<String, Integer> entry : state.limits.entrySet()) {
                    checkboxLabel += entry.getKey() + " <= " + entry.getValue() + ", ";
                }
                checkboxLabel = checkboxLabel.substring(0, checkboxLabel.length() - 2);
            }
            checkBox = new JCheckBox(checkboxLabel, state.equiped);
            checkBox.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == 2) {
                        state.equiped = false;
                    } else {
                        state.equiped = true;
                    }
                    frame.refresh();
                }
            });

            this.add(checkBox);
            checkBox.setLocation(0, yCount);
            checkBox.setSize(w, 20);
            yCount += 20;
        }
        this.setSize(w, yCount);
    }

}
