
package View.Views;



import Controller.States.States;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jlkegley on 2/5/2016.
 */
public class PauseMenu {

    int width, height;

    private String[] menuItems = {"Resume Game","Save Game", "Load Game", "Exit Game"};
    private States[] menuStates = {States.Game, States.Save, States.Load, States.Exit};
    private int currentItem = 0;

    public PauseMenu(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void render(Graphics g) {
        g.setColor(new Color(38, 166, 91));
        g.fillRect(width / 4, (height / 2) - (height / 4) - 50, width / 2, (height / 2) + 100);

        g.setColor(new Color(38, 33, 191));
        g.setFont(new Font("Arial", Font.PLAIN, 48));
        FontMetrics fm = g.getFontMetrics();
        int totalWidth = (fm.stringWidth("Pause Menu"));
        int x = (width - totalWidth) / 2;
        int y = (height / 2) - 150;
        g.drawString("Pause Menu", x, y);

        for(int i = 0; i < menuItems.length; ++i) {
            g.setFont(new Font("Arial", Font.PLAIN, 36));
            fm = g.getFontMetrics();
            totalWidth = (fm.stringWidth(menuItems[i]));
            x = (width - totalWidth) / 2;
            y = (height / 2) - 50 + 50 * i;
            if(i == currentItem){
                g.setColor(Color.ORANGE);
                g.fillRect(x, y - fm.getHeight() + (fm.getHeight() / 4), totalWidth, fm.getHeight() );
                g.setColor(Color.PINK);
            }else {
                g.setColor(Color.GREEN);
            }
            g.drawString(menuItems[i], x, y);
        }
    }

    public void next() {
        ++currentItem;
        if(currentItem > menuItems.length - 1){
            currentItem = 0;
        }
    }

    public void previous() {
        --currentItem;
        if(currentItem < 0){
            currentItem = menuItems.length - 1;
        }
    }

    public States getSelection() {
        return menuStates[currentItem];
    }

}
