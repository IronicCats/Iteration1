package View.Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mazumderm on 2/6/2016.
 */
public class SaveScreen {

    int width, height;
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

        g.setColor(new Color(38, 33, 191));
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
        g.drawString(currentSaveGameName, x, y);

        //text for the option of going back into the
        totalWidth = (fm.stringWidth("Back"));
        x = (width - totalWidth) / 2;
        y = (height / 2) + 150;
        g.drawString("Back", x, y);

    }
}
