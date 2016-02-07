package Model.Map;

import java.awt.Panel;

/**
 * Created by Peter Camejo on 2/7/2016.
 * Optional feature that may not be fully implemented by end of development.
 *
 * Plan of action : Take in player's current view + the view that is slightly outside the player's and , starting from
 * pixel 0,0 in that view, color the corresponding pixel in Minimap the appropriate color( Green:Grass , Brown:Mountain,
 * Blue : water, Red: Entity)
 *
 * Must be fairly optomized or it could lag game
 *
 * Player View width : 800;
 * Player View height : 600;
 *
 * Therefore, the view the minimap shows the player should be something like (900,700);
 *
 */
public class MiniMap extends Panel{
    private Map map;

    //Constructor
    public MiniMap(Map map) {
        this.map = map;
    }

    public MiniMap(){
        this.map = null;
    }

    //Methods
    public Map getMap(){
        return this.map;
    }

    public void setMap(Map map){
        this.map = map;
        return;
    }





}
