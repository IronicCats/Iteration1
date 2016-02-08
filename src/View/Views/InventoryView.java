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
    int barStartX, barStartY;

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
        //g.setFont(new Font("Arial", Font.BOLD, 12));
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        //fm = g.getFontMetrics();
        for (int i = 0; i < controller.getPlayer().getInventory().getPack().getCap(); ++i) {
            if(s == i)
                controller.getPlayer().getInventory().render(i,g,x,y, true,width,height);
            else
                controller.getPlayer().getInventory().render(i,g,x,y, false,width,height);
            if((i+1)%4==0 && i!=0){
                y+=74;
                x=width/2;
            }
            else x+=74;
        }

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

    }

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
        if(s-1>=0){
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
