
package View.Graphics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class Assets {

    private static final int width = 32, height = 32;

    public static BufferedImage grass;
    public static BufferedImage mountain;
    public static ArrayList<BufferedImage> water;
    public static BufferedImage avatar;
    public static BufferedImage potion;
    public static BufferedImage sack;
    public static BufferedImage skullAndBones;
    public static BufferedImage redCross;
    public static BufferedImage goldStar;

    public static void init() {


        SpriteSheet grassSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/GrassTile.png"));
        SpriteSheet mountainSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/MountainTile.png"));

        SpriteSheet avatarSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/CharSpriteSheet.png"));
        SpriteSheet potionSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/PotionSprite.png"));
        SpriteSheet skullAndBonesSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/Skull.png"));
        SpriteSheet crossSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/RedCross.png"));
        SpriteSheet starSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/Star.png"));
        SpriteSheet sackSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/ItemBag.png"));

        SpriteSheet waterSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/WaterTile.png"));


        water = new ArrayList<>(9);

        avatar = avatarSheet.crop(0, 0, width, height);
        grass = grassSheet.crop(0, 0, width, height);
        mountain = mountainSheet.crop(0, 0, width, height);
        water.add(waterSheet.crop(0, 0, width, height));
        water.add(waterSheet.crop(32, 0, width, height));
        water.add(waterSheet.crop(64, 0, width, height));
        water.add(waterSheet.crop(0, 32, width, height));
        water.add(waterSheet.crop(32, 32, width, height));
        water.add(waterSheet.crop(64, 32, width, height));
        water.add(waterSheet.crop(0, 64, width, height));
        water.add(waterSheet.crop(32, 64, width, height));
        water.add(waterSheet.crop(64, 64, width, height));


        potion = potionSheet.crop(0,0,width,height);
        sack = sackSheet.crop(0,0,width,height);
        skullAndBones = skullAndBonesSheet.crop(0, 0, 28, 28);
        redCross = crossSheet.crop(0, 0, 28, 28);
        goldStar = starSheet.crop(0, 0, 28, 28);

    }



}
