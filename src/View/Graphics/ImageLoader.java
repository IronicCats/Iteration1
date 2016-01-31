package View.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
/**
 * Created by jlkegley on 1/31/2016.
 */
public class ImageLoader {

        public static BufferedImage loadImage(String path){


            try {
                return ImageIO.read(ImageLoader.class.getResource(path));
            } catch(IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
            return null;
        }
    }

