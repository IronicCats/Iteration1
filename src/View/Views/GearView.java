package View.Views;

import Controller.Controller;
import Controller.States.GameState;
import Controller.States.InventoryState;
import Controller.States.States;

import java.awt.*;
import java.awt.font.GraphicAttribute;

/**
 * Created by broskj on 2/7/16.
 *
 *                  [0]
 *              [1]     [2]
 *                  [3]
 *              [4] [5] [6]
 *                  [7]
 *
 * Key:
 *      [0] Helmet
 *      [1] Accessory 1
 *      [2] Accessory 2
 *      [3] Chestplate
 *      [4] Hand 1
 *      [5] Platelegs
 *      [6] Hand 2
 *      [7] Boots
 *
 *
 *
 */
public class GearView {
    private int slot, currentItem;
    private int width, height;
    Controller controller;

    public GearView (Controller controller, int width, int height) {
        this.controller = controller;
        this.width = width;
        this.height = height;
        this.slot = 0;
        this.currentItem = 0;
    } // end constructor

    public void render(Graphics g) {
        g.setColor(new Color(0, 0, 0, 170));
        g.fillRect(width / 12, height / 12, 5 * width / 6, 5 * height / 6);

        g.setColor(new Color(38, 33, 191));
        g.setFont(new Font("Arial", Font.PLAIN, 48));
        FontMetrics fm = g.getFontMetrics();
        int totalWidth = (fm.stringWidth("Gear"));
        int x = (width - totalWidth) / 2;
        int y = (height / 2) - 200;
        g.drawString("Gear", x, y);
        x=width/2;
        y=height/4;

        for (int i = 0; i < controller.getPlayer().getInventory().getPack().getCap(); ++i) {
            controller.getPlayer().getInventory().render(i, g, x, y);
            if ((i + 1) % 4 == 0 && i != 0) {
                y += 74;
                x = width / 2;
            } else x += 74;
        }
    } // end render

    public void up() {
        /*
        move the selector up
         */

    } // end up
    public void down() {
        /*
        move the selector down
         */

    } // end down
    public void left() {
        /*
        move the selector left
         */

    } // end left
    public void right() {
        /*
        move the selector right
         */

    } // end right
    public void shift() {
        /*
        switch view to inventory view
         */
        GameState.game.switchState(States.Inventory);
    } // end shift
    public int q() {
        /*
        unequip equipment
         */
        return slot;
    } // end q
}
