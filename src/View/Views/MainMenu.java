package View.Views;


import javax.swing.*;
import java.awt.*;

/**
 * Created by jlkegley on 2/3/2016.
 */
public class MainMenu  {

    int width, height;
    private String[] menuItems = {"Create Game", "Load Game", "Exit Game"};
    private int currentItem = 0;


    public MainMenu(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void render(Graphics g) {
        for(int i = 0; i < menuItems.length; ++i) {
            if(i == currentItem){
                g.setColor(Color.PINK);
            }else {
                g.setColor(Color.GREEN);
            }
            //g.drawLine(width, height);
            g.setFont(new Font("Arial", Font.PLAIN, 54));
            FontMetrics fm = g.getFontMetrics();
            int totalWidth = (fm.stringWidth(menuItems[i]));
            int x = (width - totalWidth) / 2;
            System.out.println(x);
            int y = (height / 2) - 100 + 100 * i;
            g.drawString(menuItems[i], x, y);
        }
    }

}
