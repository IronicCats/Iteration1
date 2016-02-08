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
    private int s;
    int barStartX, barStartY;
    String itemNames[]={" ","Head"," ","Weapon", "Chest", "Gloves"," ", "Pants"," ","Accessory","Boots","Accessory"};

    public GearView (Controller controller, int width, int height) {
        this.controller = controller;
        this.width = width;
        this.height = height;
        this.slot = 0;
        this.currentItem = 0;
        s=1;
    } // end constructor

    public void render(Graphics g) {
        //sets the gear screen
        g.setColor(new Color(0, 0, 0, 170));
        g.fillRect(width / 12, height / 12, 5 * width / 6, 5 * height / 6);
        //sets the stats screen
        g.setColor(Color.DARK_GRAY);
        g.fillRect(100,height/4-30,width/2-125,height/2);
      //  g.fillRect(100,3*height/4-10,width/2-125,3*height/24+10);

        //done setting the rectangle screens
        g.setColor(new Color(38, 33, 191));
        g.setFont(new Font("Arial", Font.PLAIN, 48));
        FontMetrics fm = g.getFontMetrics();
        int totalWidth = (fm.stringWidth("Gear"));
        int x = (width - totalWidth) / 2;
        int y = (height / 2) - 200;
        g.drawString("Gear", x, y);
        x=width/2+25;
        y=height/4-40;
        int place=0;
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        fm = g.getFontMetrics();
        for(int total=0;total<12;++total){
            if(total!=0&&total!=2&&total!=6&&total!=8) {
                //++place;

                if(s == total)
                    controller.getPlayer().getInventory().getEquipment().render(total, g, x, y, true, width, height);
                else
                    controller.getPlayer().getInventory().getEquipment().render(total, g, x, y, false, width, height);
                g.setColor(Color.WHITE);
                //g.drawString("HEALTH: " + (int)playerStats[0] + "%", (width/8 - fm.stringWidth("HEALTH: 99%") / 2), y + 2);
                g.setFont(new Font("Arial", Font.BOLD, 12));
                g.drawString(itemNames[total], x+(64-fm.stringWidth(itemNames[total]))/2, y);

            }
            if ((total + 1) % 3 == 0 && total != 0) {
                y += 94;
                x = width / 2+25;
            } else x += 94;
        }
        /*for (int i = 0; i < controller.getPlayer().getInventory().getPack().getCap(); ++i) {
            if(slot == i)
                controller.getPlayer().getInventory().render(i, g, x, y, true);
            else
                controller.getPlayer().getInventory().render(i, g, x, y, false);
            if ((i + 1) % 4 == 0 && i != 0) {
                y += 74;
                x = width / 2;
            } else x += 74;
        }*/
        double[] playerStats = calculatePercentages();


        g.setFont(new Font("Arial", Font.BOLD, 12));
        fm = g.getFontMetrics();

        x = (barStartX) + 5;
        y = height - fm.getHeight() + 5;



        int baseX=100+ (width/2-125)/2-width/8;;
        int baseY=height/4-10;
        //SET HEALTH BAR COLOR
        int gr,red,blu;
        gr=255;red=255;blu=255;
        g.setColor(new Color(red, gr, blu));
        g.fillRect(baseX, baseY,  width/4 , fm.getHeight() + 1);


        gr = (int)(255 * playerStats[0]) / 100;
        red = (int)(255 * (100 - playerStats[0])) / 100;
        blu = 0;


        g.setColor(new Color(red, gr, blu));

        g.fillRect(baseX, baseY,  (int)((playerStats[0]/100.0) * (width/4)) , fm.getHeight() + 1);



        //SET HEALTH PERCENTAGE
        g.setColor(Color.black);
        //g.drawString("HEALTH: " + (int)playerStats[0] + "%", (width/8 - fm.stringWidth("HEALTH: 99%") / 2), y + 2);
        g.drawString("HEALTH: " + (int)playerStats[0] + "%", baseX-10+fm.stringWidth("HEALTH: 99%"), baseY+13);
        x = x + 100 + 10;


        //SET MANA BAR COLOR

        g.setColor(Color.BLUE);
        g.fillRect(baseX, baseY+30, (int)((playerStats[1]/100.0) * (width/4)) , fm.getHeight() + 1);

        //SET MANA PERCENTAGE
        g.setColor(Color.black);

        g.drawString("MANA: " + (int)playerStats[1] + "%", baseX+7 + fm.stringWidth("MANA: 99%"), baseY+43);
        x = x + 100 + 10;


        //SET EXP BAR COLOR
        gr=255;red=255;blu=255;
        g.setColor(new Color(red, gr, blu));
        g.fillRect(baseX, baseY+60,  width/4 , fm.getHeight() + 1);

        gr = (int)(255 * playerStats[6]) / 100;
        red = (int)(255 * (100 - playerStats[6])) / 100;
        blu = 100;

        g.setColor(Color.GRAY);


        //Making the EXP Bar fill the rest of the game screen
        g.fillRect(baseX, baseY+60, (int) (playerStats[6]/100.0 * width/4) , fm.getHeight() + 1);
        //SET EXP PERCENTAGE
        g.setColor(Color.black);
        g.drawString("EXP: " + (int)playerStats[4] + "/" + (int)playerStats[5]  ,baseX-7 + (fm.stringWidth("EXP: 220/099%")), baseY+73);
        x = x + 100 + 10;

        //g.setColor(Color.YELLOW);
        //g.fillRect(barStartX, y + 5, width, 5);

    } // end render
    public double[] calculatePercentages() {
        double[] playerStats = new double[7];
        //HEALTH
        playerStats[0] = (double)controller.getPlayer().getStats().getLife() / controller.getPlayer().getStats().getBaseLife() * 100.0;
        if(playerStats[0] <= 0) playerStats[0] = 0;
        //MANA
        playerStats[1] = (double)controller.getPlayer().getStats().getMana() / controller.getPlayer().getStats().getBaseMana() * 100.0;
        if(playerStats[1] <= 0) playerStats[1] = 0;
        //LEVEL
        playerStats[2] = controller.getPlayer().getStats().getLevel();
        //LIVES LEFT
        playerStats[3] = controller.getPlayer().getStats().getLivesLeft();


        //EXP
        playerStats[4] = controller.getPlayer().getStats().getExperience();
        if(playerStats[4] <= 0) playerStats[4] = 0;
        //EXP TO LEVEL
        playerStats[5] = controller.getPlayer().getStats().getXpThreshold();
        //EXP divided by EXP TO LEVEL
        playerStats[6] = (int) 100 * (playerStats[4]/ ( playerStats[5]));

        return playerStats;

    }
    public void up() {
        /*
        move the selector up
         */
        if(s==4||s==7||s==10){s-=3;}

    } // end up
    public void down() {
        /*
        move the selector down
         */
        if(s==1||s==4||s==7){s+=3;}
    } // end down
    public void left() {
        /*
        move the selector left
         */
        if(s==4||s==5||s==10||s==11){s-=1;}
    } // end left
    public void right() {
        /*
        move the selector right
         */
        if(s==3||s==4||s==9||s==10){s+=1;}
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
        return s;
    } // end q
}
