package musketstuckcharactersheet.ui;

import musketstuckcharactersheet.structures.Attack;
import musketstuckcharactersheet.structures.Weapon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import musketstuckcharactersheet.Window;

public class WeaponListElement extends JPanel {

    public Window frame;
    public Weapon weapon;

    public WeaponListElement(int y, int w, Window frame, Weapon weapon) {
        this.weapon = weapon;
        this.frame = frame;
        this.setLayout(null);
        
        JLabel statLabel = new JLabel("- " + weapon.name + " -");
        this.add(statLabel);
        statLabel.setLocation(0, 0);
        statLabel.setSize(w, 20);
        
        int yCount = 20;
        for (Attack attack : weapon.attacks) {
            AttackListElement element = new AttackListElement(yCount, w, frame, attack);
            this.add(element);
            yCount += 20;
        }
        
        this.setLayout(null);
        this.setLocation(0, y);
        this.setSize(w, yCount);
    }

}
