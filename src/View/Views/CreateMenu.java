package View.Views;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Controller.Controller;
import Controller.States.States;
import View.*;
import View.Graphics.Assets;
import View.Views.MainMenu;

/**
 * Created by Peter Camejo on 2/6/2016.
 * Basically just studied Josh's Main Menu code and made appropriate modifications.
 */
public class CreateMenu {

        int width, height;

        private String[] menuItems = {"Summoner" , "Smasher" , "Sneak" , "Back"};
        private States[] menuStates = {States.Game,States.Game, States.Game, States.Menu};

        private int currentItem = 0;
        public CreateMenu(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public void render(Graphics g) {
            g.setColor(new Color(38, 166, 91));
            g.fillRect(0, 0, width, height);

            g.setFont(new Font("Arial", Font.PLAIN, 128));
            g.drawImage(Assets.background, 0, 0, 800, 600, null);
            g.setColor(new Color(12, 12, 12, 130));
            g.fillRect(0, 0, width, height);
            FontMetrics fm = g.getFontMetrics();
            g.setColor(new Color(155, 89, 182));

            g.drawString("Choose Class", width / 2 - fm.stringWidth("Choose Class") / 2, fm.getHeight()/2 + 25 );

            for(int i = 0; i < menuItems.length; ++i) {
                g.setFont(new Font("Arial", Font.PLAIN, 54));
                fm = g.getFontMetrics();
                int totalWidth = (fm.stringWidth(menuItems[i]));
                int x = (width - totalWidth) / 2;
                int y = (height / 2) - 100 + 100 * i;
                if(i == currentItem){
                    g.setColor(new Color(149, 165, 166, 175));
                    g.fillRect(x, y - fm.getHeight() + (fm.getHeight() / 4), totalWidth, fm.getHeight() );
                    g.setColor(new Color(243, 156, 18));
                }else {
                    g.setColor(new Color(231, 76, 60));
                    if(i == 3) {
                        g.setColor(new Color(0, 0, 0));
                    }

                }
                g.drawString(menuItems[i], x, y);
            }
        }

        public void next() {
            ++currentItem;
            if(currentItem > menuItems.length - 1){
                currentItem = 0;
            }
        }

        public void previous() {
            --currentItem;
            if(currentItem < 0){
                currentItem = menuItems.length - 1;
            }
        }

        public States getSelection() {
            return menuStates[currentItem];
        }

        //Gets the Occupation a user selected (0 = Summoner, 1 = smasher, 2 = sneak)
        public int getOccSelection() { return currentItem;}

}


