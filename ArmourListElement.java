package musketstuckcharactersheet;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ArmourListElement extends JPanel {

    public JCheckBox checkBox;
    public ArrayList<ArmourListElement> elements;
    public Window frame;
    public Armour a;

    public ArmourListElement(int y, int w, boolean enabled, ArrayList<ArmourListElement> elements, Window frame, Armour a) {
        this.elements = elements;
        this.a = a;
        this.frame = frame;
        this.setLayout(null);
        this.setLocation(0, y);
        this.setSize(w, 40);
        checkBox = new JCheckBox("  " + a.name, enabled);
        checkBox.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                boolean state = checkBox.isSelected();
                if (state) {
                    for (ArmourListElement element : elements) {
                        element.checkBox.setSelected(false);
                    }
                    checkBox.setSelected(true);
                    frame.characters.get(frame.currentSelection).equiped = a;
                } else {
                    frame.characters.get(frame.currentSelection).equiped = Character.DEFAULT_ARMOUR;
                }
                frame.refresh();
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {

            }
        });
        this.add(checkBox);
        checkBox.setLocation(0, 0);
        checkBox.setSize(w, 20);
        String text = "AC Bonus: +" + a.acBonus + ", Max Dex Mod: " + a.maxDexMod;
        if (a.maxDexMod == 20) {
            text = "Ac Bonus: +" + a.acBonus;
        }
        JLabel statLabel = new JLabel(text);
        this.add(statLabel);
        statLabel.setLocation(30, 20);
        statLabel.setSize(w - 30, 20);
    }

}
