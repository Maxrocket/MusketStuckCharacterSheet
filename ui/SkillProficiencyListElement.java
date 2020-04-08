package musketstuckcharactersheet.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javafx.util.Pair;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import musketstuckcharactersheet.Window;
import musketstuckcharactersheet.dice.DiceParser;
import musketstuckcharactersheet.utils.Output;

public class SkillProficiencyListElement extends JLabel {

    public Window window;
    public String text;

    public SkillProficiencyListElement(int y, Window window, String text) {
        this.window = window;
        this.text = text;

        this.setText("- " + text);
        this.setSize(140, 20);
        this.setLocation(0, y);
        this.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                Object[] possibilities = {"BOD", "DEX", "MND", "MAG", "ASP"};
                String s = (String) JOptionPane.showInputDialog(
                        window,
                        "Select attribute for skill roll:",
                        "Input required",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        possibilities,
                        "BOD");

                Pair<String, Integer> hitRolls = DiceParser.parse("(1d20)a" + Math.abs((int) window.advantage.getValue())).roll(new ArrayList());
                if ((int) window.advantage.getValue() < 0) {
                    hitRolls = DiceParser.parse("(1d20)z" + Math.abs((int) window.advantage.getValue())).roll(new ArrayList());
                }
                int result = hitRolls.getValue() + Integer.parseInt(window.modRef.get(s).getText()) + Integer.parseInt(window.prof.getText());
                
                String output = hitRolls.getKey() + "+" + window.modRef.get(s).getText() + "+" + window.prof.getText() + "=" + result;
                
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

}
