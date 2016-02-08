package View.Views;

import Controller.States.States;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by mazumderm on 2/6/2016.
 */
public class LoadMenu {

    int width, height;
    private int currentItem = 0;
    String [] fileNames;

    public LoadMenu(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public void render(Graphics g)
    {
        //background
        g.setColor(new Color(38, 166, 91));
        g.fillRect(0, 0, width, height);

        //text for loading
        g.setColor(new Color(38, 33, 191));
        g.setFont(new Font("Arial", Font.PLAIN, 48));
        FontMetrics fm = g.getFontMetrics();
        int totalWidth = (fm.stringWidth("Pick a game to load"));
        int x = (width - totalWidth) / 2;
        int y = (height / 2) - 150;
        g.drawString("Pick a game to load", x, y);

        //list all possible games
        fileNames = new File("res/testLoadFiles").list();


        for(int i = 0; i < fileNames.length ; ++i) {
            g.setFont(new Font("Arial", Font.PLAIN, 28));
            FontMetrics fm2 = g.getFontMetrics();
            int totalWidth2 = (fm.stringWidth(fileNames[i]));
            int x2 = (width - totalWidth2) / 2;
            int y2 = (height / 2) - 100 + 100 * i;

            if(i == currentItem){
                g.setColor(Color.ORANGE);
                g.fillRect(x2, y2 - fm2.getHeight() + (fm2.getHeight() / 4), totalWidth2, fm2.getHeight() );
                g.setColor(Color.PINK);
            }else {
                g.setColor(Color.GREEN);
            }
            g.drawString(fileNames[i], x2, y2);
        }

    }

    public void next()
    {
        ++currentItem;
        if(currentItem > fileNames.length - 1){
            currentItem = 0;
        }
    }

    public void previous()
    {
        --currentItem;
        if(currentItem < 0){
            currentItem = fileNames.length - 1;
        }
    }

    public String getSelection()
    {
        return fileNames[currentItem];
    }

}
