package View.Views;

import java.awt.*;

/**
 * Created by Dartyx on 2/6/2016.
 */
public class InventoryView {
    int currentItem=0;
    int width, height;
    boolean view;
    int s;
    private String[] menuItems = {"Resume Game","Save Game", "Load Game", "Exit Game"};
    public InventoryView(int width, int height){
        this.height=height;
        this.width=width;
    }

    public void render(Graphics g) {
        g.setColor(new Color(38, 166, 91));
        g.fillRect(width / 4, (height / 2) - (height / 4) - 50, width / 2, (height / 2) + 100);

        g.setColor(new Color(38, 33, 191));
        g.setFont(new Font("Arial", Font.PLAIN, 48));
        FontMetrics fm = g.getFontMetrics();
        int totalWidth = (fm.stringWidth("Pause Menu"));
        int x = (width - totalWidth) / 2;
        int y = (height / 2) - 150;
        g.drawString("Pause Menu", x, y);

        for(int i = 0; i < menuItems.length; ++i) {
            g.setFont(new Font("Arial", Font.PLAIN, 36));
            fm = g.getFontMetrics();
            totalWidth = (fm.stringWidth(menuItems[i]));
            x = (width - totalWidth) / 2;
            y = (height / 2) - 50 + 50 * i;
            if(i == currentItem){
                g.setColor(Color.ORANGE);
                g.fillRect(x, y - fm.getHeight() + (fm.getHeight() / 4), totalWidth, fm.getHeight() );
                g.setColor(Color.PINK);
            }else {
                g.setColor(Color.GREEN);
            }
            g.drawString(menuItems[i], x, y);
        }
    }

    public void up() {
        if(view){
            if(s-4>=0){
                s-=4;
            }
        }
    }
    public void down() {
        if(view){
            if(s+4<16){
                s+=4;
            }
        }
    }
    public void left() {
        if(view){
            if(s-1>0){
                s-=1;
            }
        }
    }
    public void right() {
        if(view){
            if(s+1<16){
                s+=1;
            }
        }
    }
    public void shift() {
        view=!view;
        s=0;
    }
    public int d() {
        if(view){
            return s;
        }
        else return -1;
    }
    public int q() {
        return s;
    }
}
