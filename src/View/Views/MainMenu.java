package View.Views;


import Controller.States.States;
import View.Graphics.Assets;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jlkegley on 2/3/2016.
 */
public class MainMenu  {

    int width, height;
    int redTitle, greenTitle, blueTitle, state;
    int backX, backY;

    private String[] menuItems = {"Create Game", "Load Game", "Exit Game"};
    private States[] menuStates = {States.Create, States.Load, States.Exit};

    private int currentItem = 0;
    public MainMenu(int width, int height) {
        this.width = width;
        this.height = height;
        this.redTitle = 255;
        this.greenTitle = 0;
        this.blueTitle = 0;
        this.state = 0;
        this.backX = 0;
        this.backY = 0;
    }

    public void render(Graphics g) {


        g.drawImage(Assets.background, backX, backY, 800, 600, null);
        g.setColor(new Color(12, 12, 12, 130));
        g.fillRect(0, 0, width, height);
        for(int i = 0; i < menuItems.length; ++i) {
            g.setFont(new Font("Arial", Font.PLAIN, 54));
            FontMetrics fm = g.getFontMetrics();
            int totalWidth = (fm.stringWidth(menuItems[i]));
            int x = (width - totalWidth) / 2;
            int y = 50 + (height / 2) - 100 + 120 * i;

            if(i == currentItem){
                g.setColor(new Color(149, 165, 166, 175));
                g.fillRect(x, y - fm.getHeight() + (fm.getHeight() / 4), totalWidth, fm.getHeight() );
                g.setColor(new Color(243, 156, 18));

            }else {
                g.setColor(new Color(231, 76, 60));
            }
            g.drawString(menuItems[i], x, y);

        }
        changeColor();
        Color color = new Color(redTitle, greenTitle, blueTitle);
        int rgb = color.getRGB();
        /*
        for (int i = 0; i < Assets.title.getWidth(); i++) {
            for (int j = 0; j < Assets.title.getHeight(); j++) {
                Color c = new Color(Assets.title.getRGB(i, j));
                if(c.getAlpha() >= 255){
                    Assets.title.setRGB(i, j, rgb);
                }

            }
        }
        */
        g.setFont(new Font("Arial", Font.PLAIN, 154));
        g.setColor(color);
        FontMetrics fm = g.getFontMetrics();
        g.drawString("Ironic Cats",width / 2 - fm.stringWidth("Ironic Cats")/2, 25 + fm.getHeight()/2 );

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

    public void changeColor() {
        switch(state){
            case 0:
                greenTitle += 5;
                if(greenTitle == 255) {
                    state = 1;
                }
                break;
            case 1:
                redTitle -=5;
                if( redTitle == 0){
                    state = 2;
                }
                break;
            case 2:
                blueTitle += 5;

                if(blueTitle == 255) {
                    state = 3;
                }
                break;
            case 3:
                greenTitle -= 5;
                if(greenTitle == 0) {
                    state = 4;
                }
                break;
            case 4:
                redTitle += 5;
                if(redTitle == 255) {
                    state = 5;
                }
                break;
            case 5:
                blueTitle -= 5;
                if( blueTitle == 0) {
                    state = 0;
                }
                break;

        }
    }

}
