package Model.Map.Tiles;

import Model.Location;
import View.Graphics.Assets;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class Water extends Tile {
    public Water(Location location ) {
        super(Assets.water, location, true);
    }
}
