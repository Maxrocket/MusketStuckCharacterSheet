package musketstuckcharactersheet.ui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import musketstuckcharactersheet.Window;

public class TechniqueListElement extends JLabel {

    public Window window;
    public String name;
    public String source;
    public String desc;

    public TechniqueListElement(int y, int w, Window window, String name, String source, String description) {
        this.window = window;
        this.name = name;
        this.source = source;

        String[] words = description.split(" ");
        description = words[0];
        String currentLine = words[0];
        for (int i = 1; i < words.length; i++) {
            if (getTextWidth(currentLine + " " + words[i]) > 500) {
                description += "\n" + words[i];
                currentLine = words[i];
            } else {
                description += " " + words[i];
                currentLine += " " + words[i];
            }
        }
        this.desc = description;

        this.setText("- " + name + " - " + source);
        this.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(window, desc);
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

        this.setSize(w, 20);
        this.setLocation(0, y);
    }

    public int getTextWidth(String text) {
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
        Font font = new Font("Tahoma", Font.PLAIN, 12);
        return (int) (font.getStringBounds(text, frc).getWidth());
    }

}
