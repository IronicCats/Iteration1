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

        g.fillRect(barStartX, barStartY, width, 100);
        g.setColor(Color.YELLOW);
        g.fillRect(barStartX, barStartY, width, 5);



        g.setFont(new Font("Arial", Font.BOLD, 12));
        FontMetrics fm = g.getFontMetrics();
        int totalWidth = (fm.stringWidth("Health: "));
        int x = (barStartX);
        int y = (barStartY + 15);
        g.setColor(Color.PINK);
        g.drawString("Health: ", x, y);

        g.setColor(Color.blue);
        g.fillRect(x += totalWidth, y - 10, controller.getPlayer().getStats().getLife() / controller.getPlayer().getStats().getBaseLife() * 100, fm.getHeight() - 1);

        g.setColor(Color.black);
        String percent = controller.getPlayer().getStats().getLife() / controller.getPlayer().getStats().getBaseLife() * 100 + "%";
        g.drawString(percent, x, y);
        x = x + 100 + 10;
        g.setColor(Color.PINK);
        g.drawString("Mana: ", x, y);





    }



}

