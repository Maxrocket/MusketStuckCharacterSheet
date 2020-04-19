package musketstuckcharactersheet.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javafx.util.Pair;
import javax.swing.JLabel;
import musketstuckcharactersheet.Window;
import musketstuckcharactersheet.dice.DiceParser;
import musketstuckcharactersheet.onFunctions.OnRoll;
import musketstuckcharactersheet.utils.Output;

public class SkillProficiencyListElement extends JLabel {

    public Window window;
    public String text;

    public ArrayList<OnRoll> onRollFunctions = new ArrayList();

    public SkillProficiencyListElement(int y, Window window, String text) {
        this.window = window;
        this.text = text;

        this.setText("- " + text);
        this.setSize(140, 20);
        this.setLocation(0, y);
        this.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                Pair<String, Integer> hitRolls = DiceParser.parse("(1d20)a" + Math.abs((int) window.advantage.getValue())).roll(onRollFunctions, OnRoll.Trigger.ABILITY);
                if ((int) window.advantage.getValue() < 0) {
                    hitRolls = DiceParser.parse("(1d20)z" + Math.abs((int) window.advantage.getValue())).roll(onRollFunctions, OnRoll.Trigger.ABILITY);
                }
                int result = hitRolls.getValue() + Integer.parseInt(window.modRef.get((String) window.skillMod.getSelectedItem()).getText()) + Integer.parseInt(window.prof.getText());

                String output = hitRolls.getKey() + "+" + window.modRef.get((String) window.skillMod.getSelectedItem()).getText() + "+" + window.prof.getText() + "=" + result;

                output = output.replace("+-", "-");
                output = output.replace("--", "+");

                Output.outputText(text + " Roll", output, window);
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
    }

    public void addOnRoll(ArrayList<OnRoll> rs) {
        onRollFunctions.addAll(rs);
    }

}
