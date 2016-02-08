package View.Views;

import View.Graphics.Assets;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mazumderm on 2/6/2016.
 */
public class SaveScreen {

    int width, height;
    int selection = 0;
    private String currentSaveGameName = "";
    private final String savePrompt = "Name the game and press enter";

    public SaveScreen(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public void setCurrentSaveGameName(String s) {
        currentSaveGameName = s;
    }

    public void render(Graphics g)
    {
        g.setColor(new Color(38, 166, 91));
        g.fillRect(0, 0, width, height);

        g.setFont(new Font("Arial", Font.PLAIN, 128));
        g.drawImage(Assets.background, 0, 0, 800, 600, null);

        g.setColor(new Color(12, 12, 12, 130));
        g.fillRect(0, 0, width, height);


        g.setColor(new Color(155, 89, 182));
        g.setFont(new Font("Arial", Font.PLAIN, 48));
        FontMetrics fm = g.getFontMetrics();
        int totalWidth = (fm.stringWidth(savePrompt));
        int x = (width - totalWidth) / 2;
        int y = (height / 2) - 150;
        g.drawString("Name the game", x, y);


        //text box for name
        g.drawString(savePrompt, x, y);
        totalWidth = fm.stringWidth(currentSaveGameName);
        x = (width - totalWidth)/2;
        y = (height / 2);

        if(selection == 0) {
            g.setColor(new Color(149, 165, 166, 175));
            g.fillRect(x, y - fm.getHeight() + (fm.getHeight() / 4), totalWidth, fm.getHeight() );
            g.setColor(new Color(243, 156, 18));
        } else {
            g.setColor(new Color(231, 76, 60));
        }
        g.drawString(currentSaveGameName, x, y);

        //text for the option of going back into the
        totalWidth = (fm.stringWidth("Back"));
        x = (width - totalWidth) / 2;
        y = (height / 2) + 150;
        if(selection == 1) {
            g.setColor(new Color(149, 165, 166, 175));
            g.fillRect(x, y - fm.getHeight() + (fm.getHeight() / 4), totalWidth, fm.getHeight() );
            g.setColor(new Color(243, 156, 18));
        } else {
            g.setColor(new Color(231, 76, 60));
        }
        g.drawString("Back", x, y);

    }

    public void up() {
        selection = 0;
    }

    public void down() {
        selection = 1;
    }

    public String getSelection() {
        if(selection == 1) {
            return "back";
        } else {
            return "naming";
        }
    }


}
