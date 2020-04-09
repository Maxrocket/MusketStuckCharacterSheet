package musketstuckcharactersheet.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import musketstuckcharactersheet.Window;

public class ResourceListElement extends JPanel {

    public Window frame;
    public String name;
    public int value;
    public JSpinner counter;

    public ResourceListElement(int y, int w, Window frame, String name, int value) {
        this.frame = frame;
        this.name = name;
        this.value = value;
        this.setLayout(null);

        JLabel label = new JLabel("- " + name + ":");
        label.setSize(w / 2, 20);
        label.setLocation(0, 0);
        this.add(label);

        counter = new JSpinner();
        counter.setValue(value);
        counter.setSize(w / 2, 20);
        counter.setLocation(w / 2, 0);
        this.add(counter);

        this.setSize(w, 20);
        this.setLocation(0, y);
    }

}
