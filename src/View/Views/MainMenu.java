package View.Views;


import Controller.States.States;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jlkegley on 2/3/2016.
 */
public class MainMenu  {

    int width, height;

    private String[] menuItems = {"Create Game", "Load Game", "Exit Game"};
    private States[] menuStates = {States.Game, States.Load, States.Exit};

    private int currentItem = 0;
    public MainMenu(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void render(Graphics g) {
        g.setColor(new Color(38, 166, 91));
        g.fillRect(0, 0, width, height);

        for(int i = 0; i < menuItems.length; ++i) {
            g.setFont(new Font("Arial", Font.PLAIN, 54));
            FontMetrics fm = g.getFontMetrics();
            int totalWidth = (fm.stringWidth(menuItems[i]));
            int x = (width - totalWidth) / 2;
            int y = (height / 2) - 100 + 100 * i;
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
