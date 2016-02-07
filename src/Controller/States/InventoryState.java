package Controller.States;

import Controller.Controller;
import View.View;
import View.Views.InventoryView;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Dartyx on 2/6/2016.
 */
public class InventoryState extends State {
    InventoryView inv;
    public static InventoryState inventory;

    public InventoryState(Controller controller, int width, int height){
        super(controller);
        inventory=this;
        inv=new InventoryView(controller, width, height);
    }
    public void switchState() {
        System.out.println("Resume Game from Inventory");
        setState(GameState.game);
        inv.setS(0);
    }
    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        controller.getCamera().centerOnPlayer(controller.getPlayer());
        controller.getMap().render(g);
        controller.getPlayer().render(g);
        inv.render(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
            inv.shift();
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            inv.up();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            inv.down();
            System.out.println("Down P");
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            inv.left();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            inv.right();
        }
        if(e.getKeyCode() == KeyEvent.VK_Q) {
            int index=inv.q();
            controller.getPlayer().getInventory().interact(index);
            //else controller.getPlayer().getInventory().unequip(index);
        }
        if(e.getKeyCode() == KeyEvent.VK_D) {
           int index=inv.d();
            if(index!=-1)controller.getPlayer().getInventory().drop(index);
        }
        if(e.getKeyCode() == KeyEvent.VK_I || e.getKeyCode() == KeyEvent.VK_ESCAPE) {
          this.switchState();

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
