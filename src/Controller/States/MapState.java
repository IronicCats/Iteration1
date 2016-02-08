package Controller.States;

import Controller.Controller;
import View.View;
import View.Views.InventoryView;
import View.Views.MapView;

import java.awt.*;
import java.awt.event.KeyEvent;


public class MapState extends State {
    MapView mapView;
    public static MapState map;

    public MapState(Controller controller, int width, int height){
        super(controller);
        map=this;
        System.out.println("Map State");
        mapView=new MapView(controller, width, height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        controller.getCamera().centerOnPlayer(controller.getPlayer());
        controller.getMap().render(g);

        mapView.render(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            mapView.up();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            mapView.down();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            mapView.left();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            mapView.right();
        }
        if(e.getKeyCode() == KeyEvent.VK_M || e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            setState(GameState.game);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
