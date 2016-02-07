package View.Views;

import Controller.Controller;
import Controller.States.GameState;
import Controller.States.GearState;
import Controller.States.States;

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

    public InventoryView(Controller controller, int width, int height){
        this.height=height;
        this.width=width;
        this.controller=controller;
        int s=0;
    }

    public void render(Graphics g) {
        /*
        in inventory view
         */
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

        for (int i = 0; i < controller.getPlayer().getInventory().getPack().getCap(); ++i) {
            controller.getPlayer().getInventory().render(i,g,x,y, true);
            if((i+1)%4==0 && i!=0){
                y+=74;
                x=width/2;
            }
            else x+=74;
        }
    }

    public void up() {
        if(s-4>=0){
            s-=4;
        }
    }
    public void down() {
        if(s+4<16) {
            s += 4;
        }
    }
    public void left() {
        if(s-1>0){
            s-=1;
        }
    }
    public void right() {
        if(s+1<16){
            s+=1;
        }
    }
    public void shift() {
        s=0;
        GameState.game.switchState(States.Gear);
    }
    public int d() {
        return s;
    }
    public int q() {
        return s;
    }
}
