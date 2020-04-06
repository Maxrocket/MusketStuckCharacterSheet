package musketstuckcharactersheet.utils;

import com.sun.glass.events.KeyEvent;
import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import musketstuckcharactersheet.Window;

public class Output {

    public static void windowOutput(String title, String message, JTextArea area) {
        area.append("\n" + title + ": " + message + "\n----------");
    }

    public static void windowOutput(String[] title, String[] message, JTextArea area) {
        for (int i = 0; i < title.length; i++) {
            area.append("\n" + title[i] + ": " + message[i]);
        }
        area.append("\n----------");
    }

    public static void discordOuput(String title, String message) {
        try {
            MouseCorrectRobot r = new MouseCorrectRobot();

            r.keyPress(KeyEvent.VK_ALT);
            r.keyPress(KeyEvent.VK_TAB);
            r.delay(50);
            r.keyRelease(KeyEvent.VK_ALT);
            r.keyRelease(KeyEvent.VK_TAB);
            r.MoveMouseControlled(0, 0);
            r.MoveMouseControlled(0.25, 0.9);
            int mask1 = InputEvent.getMaskForButton(1);
            r.mousePress(mask1);
            r.delay(50);
            r.mouseRelease(mask1);
            r.delay(50);

            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection stringSelection = new StringSelection(title + "\n```" + message + "```");
            clipboard.setContents(stringSelection, stringSelection);
            r.delay(50);

            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_V);
            r.delay(50);
            r.keyRelease(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.delay(50);
            r.keyPress(KeyEvent.VK_ENTER);
            r.delay(50);
            r.keyRelease(KeyEvent.VK_ENTER);
            r.delay(50);
            r.keyPress(KeyEvent.VK_ALT);
            r.keyPress(KeyEvent.VK_TAB);
            r.keyRelease(KeyEvent.VK_ALT);
            r.keyRelease(KeyEvent.VK_TAB);

        } catch (AWTException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void discordOuput(String[] title, String[] message) {
        try {
            MouseCorrectRobot r = new MouseCorrectRobot();

            r.keyPress(KeyEvent.VK_ALT);
            r.keyPress(KeyEvent.VK_TAB);
            r.delay(50);
            r.keyRelease(KeyEvent.VK_ALT);
            r.keyRelease(KeyEvent.VK_TAB);
            r.MoveMouseControlled(0, 0);
            r.MoveMouseControlled(0.25, 0.9);
            int mask1 = InputEvent.getMaskForButton(1);
            r.mousePress(mask1);
            r.delay(50);
            r.mouseRelease(mask1);
            r.delay(50);

            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            String output = title[0] + "\n```" + message[0] + "```";
            for (int i = 1; i < title.length; i++) {
                output += "\n" + title[1] + "\n```" + message[1] + "```";
            }
            StringSelection stringSelection = new StringSelection(output);
            clipboard.setContents(stringSelection, stringSelection);
            r.delay(50);

            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_V);
            r.delay(50);
            r.keyRelease(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_CONTROL);
            r.delay(50);
            r.keyPress(KeyEvent.VK_ENTER);
            r.delay(50);
            r.keyRelease(KeyEvent.VK_ENTER);
            r.delay(50);
            r.keyPress(KeyEvent.VK_ALT);
            r.keyPress(KeyEvent.VK_TAB);
            r.keyRelease(KeyEvent.VK_ALT);
            r.keyRelease(KeyEvent.VK_TAB);

        } catch (AWTException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void outputText(String title, String message, Window window) {
        if (window.discord.isSelected()) {
            discordOuput(title, message);
        } else {
            windowOutput(title, message, window.area);
        }
    }

    public static void outputText(String[] title, String[] message, Window window) {
        if (window.discord.isSelected()) {
            discordOuput(title, message);
        } else {
            windowOutput(title, message, window.area);
        }
    }

}
