package View.Views;

import Controller.States.States;
import View.Graphics.Assets;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.awt.*;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by mazumderm on 2/6/2016.
 */
public class LoadMenu {

    int width, height;
    private int currentItem;
    ArrayList<String> menuOptions = new ArrayList<>();
    int numberOfMenuOptions;

    public LoadMenu(int width, int height)
    {
        this.currentItem = 0;
        this.width = width;
        this.height = height;
    }

    public void render(Graphics g)
    {
        g.setColor(new Color(38, 166, 91));
        g.fillRect(0, 0, width, height);

        g.setFont(new Font("Arial", Font.PLAIN, 128));
        g.drawImage(Assets.background, 0, 0, 800, 600, null);

        g.setColor(new Color(12, 12, 12, 130));
        g.fillRect(0, 0, width, height);

        //text for loading
        g.setColor(new Color(155, 89, 182));
        g.setFont(new Font("Arial", Font.PLAIN, 48));
        FontMetrics fm = g.getFontMetrics();
        int totalWidth = (fm.stringWidth("Pick a game to load"));
        int x = (width - totalWidth) / 2;
        int y = (height / 2) - 150;
        g.drawString("Pick a game to load", x, y);


        numberOfMenuOptions = menuOptions.size();

        for(int i = 0; i < menuOptions.size(); ++i) {
            g.setFont(new Font("Arial", Font.PLAIN, 28));
            FontMetrics fm2 = g.getFontMetrics();
            int totalWidth2 = (fm.stringWidth(menuOptions.get(i)));
            int x2 = (width - totalWidth2) / 2;
            int y2 = (height / 2) - 100 + 100 * i;

            if(i == currentItem){
                g.setColor(new Color(149, 165, 166, 175));
                g.fillRect(x2, y2 - fm2.getHeight() + (fm2.getHeight() / 4), totalWidth2, fm2.getHeight() );
                g.setColor(new Color(243, 156, 18));
            }else {
                g.setColor(new Color(231, 76, 60));
            }
            g.drawString(menuOptions.get(i), x2, y2);

        }
        menuOptions.clear();

    }

    public void up()
    {
        if((currentItem - 1) >= 0) {
            currentItem--;
        }
    }

    public void down()
    {
        if((currentItem + 1) < numberOfMenuOptions) {
            currentItem++;
        }
    }


    public boolean checkSelectionStatus() {
       return (menuOptions.get(currentItem).equals("Back"));
    }

    public void setMenuOptions(ArrayList<String> op) {
        menuOptions = op;
    }

    public String getSelectionString() {
        return menuOptions.get(currentItem);
    }

}
