package musketstuckcharactersheet.utils;

import com.sun.glass.events.KeyEvent;
import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import musketstuckcharactersheet.Window;

public class Output {

    public static void windowOutput(String title, String message, JTextArea area) {
        area.append("\n" + title + ": " + message + "\n--------------------");
    }

    public static void windowOutput(String[] title, String[] message, JTextArea area) {
        for (int i = 0; i < title.length; i++) {
            area.append("\n" + title[i] + ": " + message[i]);
        }
        area.append("\n--------------------");
    }

    public static void discordOuput(String title, String message, String channel, String user) {
        System.out.println(title + ", " + message + ", " + channel + ", " + user);
        try {
            String url = "";

            switch (channel) {
                case "LOTAO":
                    url = "https://discordapp.com/api/webhooks/698993988631396413/omC6D8bxoJLw9fzUzGJVkpkvyxhJ-PC6O6MtgMJQIys6xFcxPnjS0bUXA1bBQUfwOQ32";
                    break;
            }
            System.out.println(url);
            if (!url.equals("")) {
                DiscordWebhook web = new DiscordWebhook(url);
                web.setContent(user + " - " + title + "\n```" + message + "```");
                web.execute();
            }

        } catch (IOException ex) {
            Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void discordOuput(String[] title, String[] message, String channel, String user) {
        try {
            String url = "";

            switch (channel) {
                case "LOTAO":
                    url = "https://discordapp.com/api/webhooks/698993988631396413/omC6D8bxoJLw9fzUzGJVkpkvyxhJ-PC6O6MtgMJQIys6xFcxPnjS0bUXA1bBQUfwOQ32";
                    break;
            }

            if (!url.equals("")) {
                DiscordWebhook web = new DiscordWebhook(url);
                for (int i = 0; i < title.length; i++) {
                    web.setContent(user + " - " + title[i] + "\n```" + message[i] + "```");
                    web.execute();
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void outputText(String title, String message, Window window) {
        if (window.discord.getSelectedItem().equals("Window")) {
            windowOutput(title, message, window.area);
        } else {
            discordOuput(title, message, (String) window.discord.getSelectedItem(), window.currentSelection);
        }
    }

    public static void outputText(String[] title, String[] message, Window window) {
        if (window.discord.getSelectedItem().equals("Window")) {
            windowOutput(title, message, window.area);
        } else {
            discordOuput(title, message, (String) window.discord.getSelectedItem(), window.currentSelection);
        }
    }

}
