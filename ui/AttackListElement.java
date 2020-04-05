package musketstuckcharactersheet.ui;

import musketstuckcharactersheet.structures.Attack;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;
import musketstuckcharactersheet.Window;

public class AttackListElement extends JLabel {

    public Window frame;
    public Attack a;

    public AttackListElement(int y, int w, Window frame, Attack a) {
        this.a = a;
        this.frame = frame;
        this.setLayout(null);

        String text = a.name + ": ";
        if (!a.straightDamage) {
            text += a.abi;
            if (a.hitBonus > 0) {
                text += "+" + a.hitBonus;
            }
            text += ", ";
        }
        text += a.dmg;
        if (!a.straightDamage) {
            text += "+" + a.abi + ", " + a.crit + "/x" + a.critMul;
        }
        
        text += ", " + a.damageAdvantage;
        
        this.setText(text);
        this.setSize(w, 20);
        this.setLocation(0, y);

        this.addMouseListener(new MouseInputListener() {
            public void mouseClicked(MouseEvent e) {
                if (a.straightDamage) {
                    String output = a.attack(0, 0, 0);
                    frame.outputText(output + "\n", a.name + " Attack\n```" + output + "```");
                } else {
                    String output = a.attack((int) frame.advantage.getValue(), Integer.parseInt(frame.prof.getText()), Integer.parseInt(frame.modRef.get(a.abi).getText()));
                    frame.outputText(output + "\n", a.name + " Attack\n```" + output + "```");
                }
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {

            }

            public void mouseDragged(MouseEvent e) {

            }

            public void mouseMoved(MouseEvent e) {

            }
        });
    }

}
