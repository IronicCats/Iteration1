
package View.Views;



import Controller.States.States;

import javax.swing.*;
import java.awt.*;


public class KillMenu {

    int width, height;

    private String[] menuItems = {"Exit to Main Menu", "Exit Game"};
    private States[] menuStates = {States.Menu, States.Exit};
    private int currentItem = 0;

    public KillMenu(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void render(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, width, height);

        g.setColor(new Color(255, 0, 0));
        g.setFont(new Font("Arial", Font.PLAIN, 48));
        FontMetrics fm = g.getFontMetrics();
        int totalWidth = (fm.stringWidth("...Death..."));
        int x = (width - totalWidth) / 2;
        int y = (height / 2) - 150;
        g.drawString("...Death...", x, y);

        for(int i = 0; i < menuItems.length; ++i) {
            g.setFont(new Font("Arial", Font.PLAIN, 36));
            fm = g.getFontMetrics();
            totalWidth = (fm.stringWidth(menuItems[i]));
            x = (width - totalWidth) / 2;
            y = (height / 2) - 50 + 50 * i;
            if(i == currentItem){
                g.setColor(Color.GREEN);
            }else {
                g.setColor(Color.RED);
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
