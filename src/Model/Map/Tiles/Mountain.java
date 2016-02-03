package Model.Map.Tiles;

import Model.Location;
import View.Graphics.Assets;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class Mountain extends Tile {
    public Mountain(Location location ) {
        super(Assets.mountain, location, true);
    }
}
