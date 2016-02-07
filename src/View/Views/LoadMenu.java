package View.Views;

import Controller.States.States;

import java.awt.*;

/**
 * Created by mazumderm on 2/6/2016.
 */
public class LoadMenu {

    int width, height;
    private int currentItem = 0;

    public LoadMenu(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public void render(Graphics g)
    {
        g.setColor(new Color(38, 166, 91));
        g.fillRect(0, 0, width, height);
    }

    public void next()
    {

    }

    public void previous()
    {

    }

}
