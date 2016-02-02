package View.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
/**
 * Created by jlkegley on 1/31/2016.
 */
public class ImageLoader {

        public BufferedImage loadImage(String path){
            System.out.println(path);
            try {
                return ImageIO.read(getClass().getResourceAsStream(path));
            } catch(IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
            System.out.println("Failed");
            return null;
        }
    }

