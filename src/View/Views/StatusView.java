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
       // System.out.println("Life: " + controller.getPlayer().getStats().getLife() + " Hardiness: " + controller.getPlayer().getStats().getHardiness());
       // System.out.println("Base Life: " + controller.getPlayer().getStats().getBaseLife() + " Level: " + controller.getPlayer().getStats().getLevel());
        g.fillRect(barStartX, barStartY, width, 100);
        g.setColor(Color.YELLOW);
        g.fillRect(barStartX, barStartY, width, 5);



        g.setFont(new Font("Arial", Font.BOLD, 12));
        FontMetrics fm = g.getFontMetrics();


        int totalWidth = (fm.stringWidth("Health: "));
        int x = (barStartX);
        int y = (barStartY + 15);
        //SET HEALTH TEXT COLOR
        g.setColor(Color.PINK);
        g.drawString("Health: ", x, y);
        //SET HEALTH BAR COLOR
        g.setColor(Color.blue);
        g.fillRect(x += totalWidth, y - 10, (int) playerStats[0] , fm.getHeight() - 1);
        //SET HEALTH PERCENTAGE
        g.setColor(Color.black);
        g.drawString((int)playerStats[0] + "%", x, y);
        x = x + 100 + 10;

        //SET MANA TEXT COLOR
        g.setColor(Color.PINK);
        g.drawString("Mana: ", x, y);
        //SET MANA BAR COLOR
        g.setColor(Color.GREEN);
        g.fillRect(x += totalWidth, y - 10, (int) playerStats[1] , fm.getHeight() - 1);

        //SET MANA PERCENTAGE
        g.setColor(Color.black);
        g.drawString((int)playerStats[1] + "%", x, y);
        x = x + 100 + 10;



    }

    public double[] calculatePercentages() {
        double[] playerStats = new double[5];
        //HEALTH
        playerStats[0] = (double)controller.getPlayer().getStats().getLife() / controller.getPlayer().getStats().getBaseLife() * 100.0;
        playerStats[1] = (double)controller.getPlayer().getStats().getMana() / controller.getPlayer().getStats().getBaseMana() * 100.0;


        return playerStats;

    }



}

