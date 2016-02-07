package View.Graphics;

import java.awt.image.BufferedImage;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class Assets {

    private static final int width = 32, height = 32;

    public static BufferedImage grass;
    public static BufferedImage mountain;
    public static BufferedImage water;
    public static BufferedImage avatar;
    public static BufferedImage potion;
    public static BufferedImage skullandbones;

    public static void init() {
        SpriteSheet grassSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/GrassTile.jpg"));
        SpriteSheet mountainSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/MountainTile.png"));
        SpriteSheet waterSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/WaterTile.png"));
        SpriteSheet avatarSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/SwordSprite.png"));
        SpriteSheet potionSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/PotionSprite.png"));
        SpriteSheet skullAndBonesSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/SkullAndCrossBones.png"));

        avatar = avatarSheet.crop(0, 0, width, height);
        grass = grassSheet.crop(0, 0, width, height);
        mountain = mountainSheet.crop(0, 0, width, height);
        water = waterSheet.crop(0, 0, width, height);
        potion = potionSheet.crop(0,0,width,height);
        skullandbones = skullAndBonesSheet.crop(0,0,width,height);

    }



}
