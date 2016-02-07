package View.Views;

import java.awt.*;

/**
 * Created by mazumderm on 2/6/2016.
 */
public class SaveScreen {

    int width, height;

    public SaveScreen(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public void render(Graphics g)
    {
        g.setColor(new Color(38, 166, 91));
        g.fillRect(0, 0, width, height);

    }
}
