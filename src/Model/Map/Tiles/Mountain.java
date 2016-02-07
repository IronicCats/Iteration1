package Model.Map.Tiles;

import Model.Location;
import View.Graphics.Assets;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class Mountain extends Tile {
    public Mountain(BufferedImage image, Location location ) {
        super(image, location, true);
    }
}
