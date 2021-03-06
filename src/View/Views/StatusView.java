package View.Views;

import Controller.Controller;
import Controller.States.GameState;
import Controller.States.State;
import Model.Item.Item;
import Model.Location;
import Model.Map.Tiles.Tile;
import View.Graphics.Assets;


import java.awt.*;
import java.util.ArrayList;

/**
 * Created by jlkegley on 2/5/2016.
 */
public class StatusView {

    Controller controller;
    int width, height;
    int barStartX, barStartY;

    public StatusView(Controller controller) {

        this.controller = controller;
        this.width = controller.getGame().getWidth();
        this.height = controller.getGame().getHeight();
        barStartX = 0;
        barStartY =height - 100;

    }

    public void render(Graphics g) {
        double[] playerStats = calculatePercentages();

        g.setFont(new Font("Arial", Font.BOLD, 12));
        FontMetrics fm = g.getFontMetrics();


        int x = (barStartX) + 5;
        int y = height - fm.getHeight() + 5;




        //SET HEALTH BAR COLOR
        int gr = (int)(255 * playerStats[0]) / 100;
        int red = (int)(255 * (100 - playerStats[0])) / 100;
        int blu = 0;

        g.setColor(getRGB(red, gr, blu));

        g.fillRect(0, y - 10,  (int)((playerStats[0]/100.0) * (width/4)) , fm.getHeight() + 1);

        //SET HEALTH PERCENTAGE
        g.setColor(Color.black);
        g.drawString("LIVES: " + (int)playerStats[3] + " - HEALTH: " + (int)playerStats[0] + "%", (width/8 - fm.stringWidth("Lives: 10 - HEALTH: 99%") / 2), y + 2);
        x = x + 100 + 10;


        //SET MANA BAR COLOR
        g.setColor(Color.GREEN);
        g.fillRect((width/4), y - 10, (int)((playerStats[1]/100.0) * (width/4)) , fm.getHeight() + 1);

        //SET MANA PERCENTAGE
        g.setColor(Color.black);
        g.drawString("MANA: " + (int)playerStats[1] + "%", width/4 + (width/8 - fm.stringWidth("MANA: 99%") / 2), y + 2);
        x = x + 100 + 10;


        //SET EXP BAR COLOR
        gr = (int)(255 * playerStats[6]) / 100;
        red = (int)(255 * (100 - playerStats[6])) / 100;
        blu = 100;

        g.setColor(getRGB(red, gr, blu));


        //Making the EXP Bar fill the rest of the game screen
        g.fillRect(width/2, y - 10, (int) (playerStats[6]/100.0 * width/2) , fm.getHeight() + 1);
        //SET EXP PERCENTAGE
        g.setColor(Color.black);
        g.drawString("LVL: " + (int)playerStats[2] + " - EXP: " + (int)playerStats[4] + "/" + (int)playerStats[5]  ,width/4 + (width/2 - (fm.stringWidth("LVL: 23 - EXP: 220/099%") / 2)), y + 2);
        x = x + 100 + 10;

        g.setColor(Color.YELLOW);
        g.fillRect(barStartX, y + 5, width, 5);

        if (State.getState() == GameState.game) {
            renderItemsLists(g);
            renderButtons(g);
        }
    }

    public double[] calculatePercentages() {
        double[] playerStats = new double[7];
        //HEALTH
        playerStats[0] = (double)controller.getPlayer().getStats().getLife() / controller.getPlayer().getStats().getBaseLife() * 100.0;
        if(playerStats[0] <= 0) playerStats[0] = 0;
        //MANA
        playerStats[1] = (double)controller.getPlayer().getStats().getMana() / controller.getPlayer().getStats().getBaseMana() * 100.0;
        if(playerStats[1] <= 0) playerStats[1] = 0;
        //LEVEL
        playerStats[2] = controller.getPlayer().getStats().getLevel();
        //LIVES LEFT
        playerStats[3] = controller.getPlayer().getStats().getLivesLeft();


        //EXP
        playerStats[4] = controller.getPlayer().getStats().getExperience();
        if(playerStats[4] <= 0) playerStats[4] = 0;
        //EXP TO LEVEL
        playerStats[5] = controller.getPlayer().getStats().getXpThreshold();
        //EXP divided by EXP TO LEVEL
        playerStats[6] = (int) 100 * (playerStats[4]/ ( playerStats[5]));

        return playerStats;

    }

    public void renderOptions(Graphics g) {

    }

    public void renderItemsLists(Graphics g) {
        int playerX = controller.getPlayer().getLocation().getX();
        int playerY = controller.getPlayer().getLocation().getY() ;
        Tile curTile = controller.getTiles(playerX, playerY);
        FontMetrics fm = g.getFontMetrics();
        int amountItems = controller.getTiles(playerX, playerY).getItems().size();
        //if theres items on the group, render a box and list the items on the screen
        if(curTile.hasItem()) {
            g.drawRect(width - 150, height - 50 - (10 *(amountItems + 1)), fm.stringWidth("1. xxxxxxxxxxxxxxxxxx"), (amountItems + 1) * (fm.getHeight()) );
            g.setColor(new Color(12, 12, 12, 150));
            g.fillRect(width - 150, height - 50 - (10 *(amountItems + 1)), fm.stringWidth("1. xxxxxxxxxxxxxxxxxx"), (amountItems + 1) * (fm.getHeight()));

            ArrayList<Item> items = controller.getTiles(playerX, playerY).getItems();
            g.setColor(new Color(255, 255, 255, 150));
            if(items.size() == 1){
                g.drawString(items.get(0).getName(), width - 140, (fm.getHeight() / 2 + (height - 60)));

            }else {
                for (int i = 0; i < items.size(); ++i) {
                    g.drawString(items.get(i).getName(), width - 140, (3 * -i) + (fm.getHeight() / 2 + height - 40 - (10 * (i + 1))));
                }
            }

        }
    }

    public void renderButtons(Graphics g) {
        int startX = 0;
        int startY = height - 100;
        int playerX = controller.getPlayer().getLocation().getX();
        int playerY = controller.getPlayer().getLocation().getY() ;
        FontMetrics fm = g.getFontMetrics();
        Tile curTile = controller.getTiles(playerX, playerY);
        g.setColor(new Color(255, 255, 255, 150));
        if(curTile.getItems().size() > 0) {
            g.drawImage(Assets.buttons.get(0), 0, startY, 64, 64, null);
            g.drawString("Interact", 64/2 - fm.stringWidth("Interact")/2, startY + 64);
            startX = 64;
        }
        String[] buttonText = {"Inventory", "Gear", "Menu"};
        for(int i = 1; i <= 3; ++i) {
            g.drawImage(Assets.buttons.get(i), startX, startY, 64, 64, null);
            g.drawString(buttonText[i - 1], startX + 64/2 - fm.stringWidth(buttonText[i - 1])/2, startY + 64);
            startX += 64;
        }

        g.drawImage(Assets.buttons.get(5), startX, startY, 64, 64, null);
        g.drawString("Map", startX + 64/2 - fm.stringWidth("Map")/2, startY + 64);
    }

    public Color getRGB(int r, int g, int b) {
        if( r < 0 || r > 255) {r = 0;};
        if( g < 0 || g > 255) {g = 0;};
        if( b < 0 || b > 255) {b = 0;};
        return new Color(r, g, b);
    }

}
