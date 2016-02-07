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
    public static BufferedImage sack;
    public static BufferedImage sword;
    public static BufferedImage boots;


    public static void init() {
        SpriteSheet grassSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/GrassTile.png"));
        SpriteSheet mountainSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/MountainTile.png"));
        SpriteSheet waterSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/WaterTile.png"));
        SpriteSheet avatarSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/CharSpriteSheet.png"));
        SpriteSheet potionSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/PotionSprite.png"));
        SpriteSheet sackSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/ItemBag.png"));
        SpriteSheet swordSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/SwordSprite.png"));
        SpriteSheet bootsSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/BootsSprite.png"));

        avatar = avatarSheet.crop(0, 0, width, height);
        grass = grassSheet.crop(0, 0, width, height);
        mountain = mountainSheet.crop(0, 0, width, height);
        water = waterSheet.crop(0, 0, width, height);
        potion = potionSheet.crop(0,0,width,height);
        sword = swordSheet.crop(0,0,width,height);
        sack = sackSheet.crop(0,0,width,height);
        boots = bootsSheet.crop(0,0,width,height);


    }



}
