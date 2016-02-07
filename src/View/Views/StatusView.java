package View.Views;

import Controller.Controller;



import java.awt.*;

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


        g.setColor(new Color(red, gr, blu));
        g.fillRect(0, y - 10,  (int)((playerStats[0]/100.0) * (width/4)) , fm.getHeight() + 1);

        //SET HEALTH PERCENTAGE
        g.setColor(Color.black);
        g.drawString("HEALTH: " + (int)playerStats[0] + "%", (width/8 - fm.stringWidth("HEALTH: 99%") / 2), y + 2);
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

        g.setColor(new Color(red, gr, blu));


        //Making the EXP Bar fill the rest of the game screen
        g.fillRect(width/2, y - 10, (int) (playerStats[6]/100.0 * width/2) , fm.getHeight() + 1);
        //SET EXP PERCENTAGE
        g.setColor(Color.black);
        g.drawString("LVL: " + (int)playerStats[2] + " - EXP: " + (int)playerStats[4] + "/" + (int)playerStats[5]  ,width/4 + (width/2 - (fm.stringWidth("LVL: 23 - EXP: 220/099%") / 2)), y + 2);
        x = x + 100 + 10;

        g.setColor(Color.YELLOW);
        g.fillRect(barStartX, y + 5, width, 5);

    }

    public double[] calculatePercentages() {
        double[] playerStats = new double[7];
        //HEALTH
        playerStats[0] = (double)controller.getPlayer().getStats().getLife() / controller.getPlayer().getStats().getBaseLife() * 100.0;
        if(playerStats[0] <= 0) playerStats[0] = 0;
        //MANA
        playerStats[1] = (double)controller.getPlayer().getStats().getMana() / controller.getPlayer().getStats().getBaseMana() * 100.0;
        //LEVEL
        playerStats[2] = controller.getPlayer().getStats().getLevel();
        //LIVES LEFT
        playerStats[3] = controller.getPlayer().getStats().getLivesLeft();


        //EXP
        playerStats[4] = controller.getPlayer().getStats().getExperience();
        //EXP TO LEVEL
        playerStats[5] = controller.getPlayer().getStats().getXpThreshold();
        //EXP divided by EXP TO LEVEL
        playerStats[6] = (int) 100 * (playerStats[4]/ ( playerStats[5]));

        return playerStats;

    }



}
