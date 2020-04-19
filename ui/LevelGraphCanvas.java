/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musketstuckcharactersheet.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Maxime
 */
public class LevelGraphCanvas extends JPanel {

    public int power, knowledge, safety, aspect;

    public LevelGraphCanvas(int w, int power, int knowledge, int safety, int aspect) {
        this.power = power;
        this.knowledge = knowledge;
        this.safety = safety;
        this.aspect = aspect;
        this.setSize(w, w);
        this.setPreferredSize(new Dimension(w, w));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.gray);
        g.drawPolygon(new int[]{getWidth() / 2, getWidth() - 50, getWidth() / 2, 50}, new int[]{50, getWidth() / 2, getWidth() - 50, getWidth() / 2}, 4);
        g.drawPolygon(new int[]{getWidth() / 2, getWidth() / 2 + 25, getWidth() / 2, getWidth() / 2 - 25}, new int[]{getWidth() / 2 - 25, getWidth() / 2, getWidth() / 2 + 25, getWidth() / 2}, 4);
        g.drawLine(getWidth() / 2, 50, getWidth() / 2, getWidth() / 2 - 25);
        g.drawLine(getWidth() / 2 + 25, getWidth() / 2, getWidth() - 50, getWidth() / 2);
        g.drawLine(getWidth() / 2, getWidth() / 2 + 25, getWidth() / 2, getWidth() - 50);
        g.drawLine(getWidth() / 2 - 25, getWidth() / 2, 50, getWidth() / 2);
        
        double max = Math.max(Math.max(Math.max(power, knowledge), safety), aspect) + 0.0;
        double size = (getWidth() / 2.0) - 75.0;
        g.setColor(Color.gray);
        for (int i = 1; i < max; i++) {
            g.drawPolygon(new int[]{getWidth() / 2, getWidth() / 2 + 25 + (int) (size * (i / max)), getWidth() / 2, getWidth() / 2 - 25 - (int) (size * (i / max))},
                    new int[]{getWidth() / 2 - 25 - (int) (size * (i / max)), getWidth() / 2, getWidth() / 2 + 25 + (int) (size * (i / max)), getWidth() / 2}, 4);
        }
        
        g.setColor(new Color(255, 0, 0, 178));
        g.fillPolygon(new int[] {getWidth() / 2, getWidth() / 2 + 25 + (int)(size * (knowledge / max)), getWidth() / 2, getWidth() / 2 - 25 - (int)(size * (aspect / max))},
                new int[] {getWidth() / 2 - 25 - (int)(size * (power / max)), getWidth() / 2, getWidth() / 2 + 25 + (int)(size * (safety / max)), getWidth() / 2}, 4);
        g.setColor(Color.black);
        g.drawPolygon(new int[] {getWidth() / 2, getWidth() / 2 + 25 + (int)(size * (knowledge / max)), getWidth() / 2, getWidth() / 2 - 25 - (int)(size * (aspect / max))},
                new int[] {getWidth() / 2 - 25 - (int)(size * (power / max)), getWidth() / 2, getWidth() / 2 + 25 + (int)(size * (safety / max)), getWidth() / 2}, 4);
        
        g.setFont(new Font("monospaced", Font.BOLD, 20));
        g.drawString("P", getWidth() / 2 - 5, 40);
        g.drawString("K", getWidth() - 40, getWidth() / 2 + 7);
        g.drawString("S", getWidth() / 2 - 6, getWidth() - 28);
        g.drawString("A", 28, getWidth() / 2 + 7);
        g.setColor(Color.black);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }
}
