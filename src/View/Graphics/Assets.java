package View.Graphics;

import View.Graphics.ImageLoader;
import View.Graphics.SpriteSheet;

import java.awt.image.BufferedImage;





import java.util.ArrayList;


/**
 * Created by jlkegley on 1/31/2016.
 */
public class Assets {

    private static final int width = 32, height = 32;

    public static ArrayList<BufferedImage> grass;
    public static ArrayList<BufferedImage> water;
    public static ArrayList<BufferedImage> mountain;


    public static BufferedImage avatarFacingDown;
    public static BufferedImage avatarFacingUp;
    public static BufferedImage avatarFacingLeft;
    public static BufferedImage avatarFacingRight;
    public static BufferedImage potion;
    public static BufferedImage sack;
    public static BufferedImage skullAndBones;
    public static BufferedImage redCross;
    public static BufferedImage goldStar;
    public static BufferedImage sword;
    public static BufferedImage boots;
    public static BufferedImage emptyInv;
    public static BufferedImage emptyInvSelect;
    public static BufferedImage pants;
    public static BufferedImage accessory1;
    public static BufferedImage accessory2;
    public static BufferedImage glove;
    public static BufferedImage manapotion;
    public static BufferedImage menucursor;
    public static BufferedImage chestArmor;
    public static BufferedImage helmet;
    public static BufferedImage house;
    public static BufferedImage key;


    public static void init() {
        SpriteSheet grassSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/GrassTiles.png"));
        SpriteSheet mountainSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/MountainTile.png"));
        SpriteSheet waterSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/WaterTile.png"));


        SpriteSheet avatarSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/CharSpriteSheet.png"));
        SpriteSheet potionSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/PotionSprite.png"));
        SpriteSheet skullAndBonesSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/Skull.png"));
        SpriteSheet crossSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/RedCross.png"));
        SpriteSheet starSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/Star.png"));
        SpriteSheet sackSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/ItemBag.png"));
        SpriteSheet swordSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/SwordSprite.png"));
        SpriteSheet bootsSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/BootsSprite.png"));
        SpriteSheet emptyInvSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/InventoryBlock.png"));
        SpriteSheet selectInvSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/InventoryBlockSelect.png"));
        SpriteSheet pantsSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/pants.png"));
        SpriteSheet accessory1Sheet = new SpriteSheet(new ImageLoader().loadImage("/textures/Accessory1.png"));
        SpriteSheet accessory2Sheet = new SpriteSheet(new ImageLoader().loadImage("/textures/Accessory2.png"));
        SpriteSheet gloveSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/Glove.png"));
        SpriteSheet manapotionSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/ManaPotion.png"));
        SpriteSheet menuCursorSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/MenuCursor.png"));
        SpriteSheet chestSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/ChestArmorSprite.png"));
        SpriteSheet helmetSheet = new SpriteSheet(new ImageLoader().loadImage("/textures/Helmet.png"));
        SpriteSheet keysheet = new SpriteSheet(new ImageLoader().loadImage("/textures/KeySprite.png"));

        water = new ArrayList<>(9);
        mountain = new ArrayList<>(9);
        grass = new ArrayList<>(9);

        avatarFacingDown = avatarSheet.crop(0, 0, width, height);
        avatarFacingUp = avatarSheet.crop(32,0,width,height);
        avatarFacingLeft = avatarSheet.crop(64,0,width,height);
        avatarFacingRight = avatarSheet.crop(96,0,width,height);
        potion = potionSheet.crop(0,0,width,height);
        sack = sackSheet.crop(0,0,width,height);
        sword = swordSheet.crop(0,0,width,height);
        boots = bootsSheet.crop(0,0,width,height);

        //Water Tiles
        water.add(waterSheet.crop(0, 0, width, height));
        water.add(waterSheet.crop(32, 0, width, height));
        water.add(waterSheet.crop(64, 0, width, height));
        water.add(waterSheet.crop(0, 32, width, height));
        water.add(waterSheet.crop(32, 32, width, height));
        water.add(waterSheet.crop(64, 32, width, height));
        water.add(waterSheet.crop(0, 64, width, height));
        water.add(waterSheet.crop(32, 64, width, height));
        water.add(waterSheet.crop(64, 64, width, height));

        //Mountain Tiles
        mountain.add(mountainSheet.crop(0, 0, width, height));
        mountain.add(mountainSheet.crop(32, 0, width, height));
        mountain.add(mountainSheet.crop(64, 0, width, height));
        mountain.add(mountainSheet.crop(0, 32, width, height));
        mountain.add(mountainSheet.crop(32, 32, width, height));
        mountain.add(mountainSheet.crop(64, 32, width, height));
        mountain.add(mountainSheet.crop(0, 64, width, height));
        mountain.add(mountainSheet.crop(32, 64, width, height));
        mountain.add(mountainSheet.crop(64, 64, width, height));

        //Grass Tiles
        grass.add(grassSheet.crop(0, 0, width, height));
        grass.add(grassSheet.crop(32, 0, width, height));
        grass.add(grassSheet.crop(64, 0, width, height));
        grass.add(grassSheet.crop(0, 32, width, height));
        grass.add(grassSheet.crop(32, 32, width, height));
        grass.add(grassSheet.crop(64, 32, width, height));
        grass.add(grassSheet.crop(0, 64, width, height));
        grass.add(grassSheet.crop(32, 64, width, height));
        grass.add(grassSheet.crop(64, 64, width, height));


        potion = potionSheet.crop(0,0,width,height);
        sack = sackSheet.crop(0,0,width,height);
        skullAndBones = skullAndBonesSheet.crop(0, 0, 28, 28);
        redCross = crossSheet.crop(0, 0, 28, 28);
        goldStar = starSheet.crop(0, 0, 28, 28);
        emptyInv = emptyInvSheet.crop(0,0,width,height);
        emptyInvSelect =selectInvSheet.crop(0,0,width,height);
        pants = pantsSheet.crop(0,0,width,height);
        accessory1 = accessory1Sheet.crop(0,0,width,height);
        accessory2 = accessory2Sheet.crop(0,0,width,height);
        glove = gloveSheet.crop(0,0,width,height);
        manapotion = manapotionSheet.crop(0,0,width,height);
        menucursor = menuCursorSheet.crop(0,0,width,height);
        chestArmor = chestSheet.crop(0,0,width,height);
        helmet = helmetSheet.crop(0,0,width,height);
        key = keysheet.crop(0,0,width,height);
    }
}
