package Model.Map.Tiles;

import Model.Location;
import View.Graphics.Assets;

import java.awt.image.BufferedImage;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class Water extends Tile {
    public Water(BufferedImage image, Location location ) {
        super(image, location, true);
    }
}
