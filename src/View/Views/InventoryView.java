package View.Views;

import Controller.Controller;

import java.awt.*;

/**
 * Created by Dartyx on 2/6/2016.
 */
public class InventoryView {
    int currentItem=0;
    int width, height;
    boolean view;

    public void setS(int s) {
        this.s = s;
    }

    private int s;
    int sX;
    int sY;
    Controller controller;
    private String[] menuItems = {"Resume Game","Save Game", "Load Game", "Exit Game"};
    public InventoryView(Controller controller, int width, int height){
        this.height=height;
        this.width=width;
        view = true;
        this.controller=controller;
        int s=0;
    }

    public void render(Graphics g) {
        if(view) {
            g.setColor(new Color(0, 0, 0, 170));
            g.fillRect(width / 12, height / 12, 5 * width / 6, 5 * height / 6);

            g.setColor(new Color(38, 33, 191));
            g.setFont(new Font("Arial", Font.PLAIN, 48));
            FontMetrics fm = g.getFontMetrics();
            int totalWidth = (fm.stringWidth("Inventory"));
            int x = (width - totalWidth) / 2;
            int y = (height / 2) - 200;
            g.drawString("Inventory", x, y);
            x=width/2;
            y=height/4;
            sX=x;
            sY=y;
            for (int i = 0; i < controller.getPlayer().getInventory().getPack().getCap(); ++i) {
                //g.setFont(new Font("Arial", Font.PLAIN, 36));
                //fm = g.getFontMetrics();
                //totalWidth = (fm.stringWidth(menuItems[i]));
                //x = (width - totalWidth) / 2;
                //y = (height / 2) - 50 + 50 * i;
                //if (i == currentItem) {
                //    g.setColor(Color.ORANGE);
                //   g.fillRect(x, y - fm.getHeight() + (fm.getHeight() / 4), totalWidth, fm.getHeight());
                //    g.setColor(Color.PINK);
                //} else {
                //    g.setColor(Color.GREEN);
                //}
                //System.out.print(s);
                if(s==i){controller.getPlayer().getInventory().render(i,g,x,y,true);
                    //System.out.print("it succeeded");
                }
                else controller.getPlayer().getInventory().render(i,g,x,y,false);
                if((i+1)%4==0 && i!=0){
                    y+=74;
                    x=width/2;
                }
                else x+=74;


                //g.drawString(menuItems[i], x, y);
            }
        }
        else{
            g.setColor(new Color(0, 0, 0));
            g.fillRect(width / 12, height / 12, 5 * width / 6, 5 * height / 6);

            g.setColor(new Color(38, 33, 191));
            g.setFont(new Font("Arial", Font.PLAIN, 48));
            FontMetrics fm = g.getFontMetrics();
            int totalWidth = (fm.stringWidth("Equipment"));
            int x = (width - totalWidth) / 2;
            int y = (height / 2) - 200;
            g.drawString("Equipment", x, y);

            for (int i = 0; i < menuItems.length; ++i) {
                g.setFont(new Font("Arial", Font.PLAIN, 36));
                fm = g.getFontMetrics();
                totalWidth = (fm.stringWidth(menuItems[i]));
                x = (width - totalWidth) / 2;
                y = (height / 2) - 50 + 50 * i;
                if (i == currentItem) {
                    g.setColor(Color.ORANGE);
                    g.fillRect(x, y - fm.getHeight() + (fm.getHeight() / 4), totalWidth, fm.getHeight());
                    g.setColor(Color.PINK);
                } else {
                    g.setColor(Color.GREEN);
                }
                g.drawString(menuItems[i], x, y);
            }
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
            if(s-1>=0){
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
