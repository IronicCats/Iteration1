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

        g.fillRect(barStartX, barStartY, width, 100);
        g.setColor(Color.YELLOW);
        g.fillRect(barStartX, barStartY, width, 5);



        g.setFont(new Font("Arial", Font.BOLD, 12));
        FontMetrics fm = g.getFontMetrics();


        int totalWidth = (fm.stringWidth("Health: "));
        int x = (barStartX) + 5;
        int y = (barStartY + 15);
        //SET HEALTH TEXT COLOR
        g.setColor(Color.PINK);
        g.drawString("Health: ", x, y);
        //SET HEALTH BAR COLOR
        int gr = 0;
        int red = (int)(255 * (100 - playerStats[0])) / 100;
        int blu = (int)(255 * playerStats[0]) / 100;

        g.setColor(new Color(red, gr, blu));
        g.fillRect(x += totalWidth, y - 10, (int) playerStats[0] , fm.getHeight() - 1);

        //SET HEALTH PERCENTAGE
        g.setColor(Color.black);
        g.drawString((int)playerStats[0] + "%", x + 45, y + 1);
        x = x + 100 + 10;

        //SET MANA TEXT COLOR
        g.setColor(Color.PINK);
        g.drawString("Mana: ", x, y);
        //SET MANA BAR COLOR
        g.setColor(Color.GREEN);
        g.fillRect(x += totalWidth, y - 10, (int) playerStats[1] , fm.getHeight() - 1);

        //SET MANA PERCENTAGE
        g.setColor(Color.black);
        g.drawString((int)playerStats[1] + "%", x + 45, y + 1);
        x = x + 100 + 10;


        //SET EXP TEXT COLOR
        g.setColor(Color.PINK);
        g.drawString("EXP: ", x, y);
        //SET EXP BAR COLOR
        gr = (int)(255 * playerStats[6]) / 100;
        red = (int)(255 * (100 - playerStats[6])) / 100;
        blu = 0;

        g.setColor(new Color(red, gr, blu));


        //Making the EXP Bar fill the rest of the game screen
        g.fillRect(x += totalWidth - 10, y - 10, (int) (playerStats[6] * 4.6) , fm.getHeight() - 1);

        //SET EXP PERCENTAGE
        g.setColor(Color.black);
        g.drawString((int)playerStats[4] + "/" + (int)playerStats[5]  , x + (int)(45 * 4.6), y + 1);
        x = x + 100 + 10;

        y = y + fm.getHeight() + 25;
        g.setFont(new Font("Arial", Font.BOLD, 36));
        fm = g.getFontMetrics();

        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.drawString("lvl: ", x = 0, y);
        g.setFont(new Font("Arial", Font.BOLD, 36));
        g.drawString("" +(int)playerStats[2], x += 40, y);
        g.drawString(controller.getPlayer().getOccupation().getName(), x += 60, y);

        int r = 10;
        x = x-(r/2);
        y = y-(r/2);
        g.fillOval(x,y,r,r);


    }

    public double[] calculatePercentages() {
        double[] playerStats = new double[7];
        //HEALTH
        playerStats[0] = (double)controller.getPlayer().getStats().getLife() / controller.getPlayer().getStats().getBaseLife() * 100.0;
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

