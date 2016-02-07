package Model.Map.Tiles;

import Model.Location;
import View.Graphics.Assets;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class Grass extends Tile {
    public Grass(BufferedImage image, Location location ) {
        super(image, location, false);
    }

}
