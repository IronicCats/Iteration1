package Model.Entity;

import Controller.Controller;
import Model.Entity.Inventory.Inventory;
import Model.Entity.Stats.StatStructure;
import Model.Game;
import Model.Entity.Occupation.Occupation;
import Model.Entity.Inventory.Inventory;
import Model.Entity.Stats.Stats;
import Model.Location;
import Model.Map.Tiles.Tile;
import View.Graphics.Assets;


import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Aidan on 1/31/2016.
 */
public class Player extends Entity {
    private Nav navigation;
    private Inventory inventory;
    public static final int DEFAULT_CREATURE_WIDTH = 52,
                            DEFAULT_CREATURE_HEIGHT = 52;


    public Player(Controller controller, Location location, Inventory inventory, Occupation occupation, Stats stats) {
        super(controller, location, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT, occupation, stats);
        bounds.x = DEFAULT_CREATURE_WIDTH;
        bounds.y = DEFAULT_CREATURE_HEIGHT;
        navigation = new Nav(location, bounds, controller, this);
        this.inventory = inventory;
    }



    @Override
    public void tick() {
        getStats().tick();
        navigation.move();
    }

    public void PickUpItem(){
        if(controller.getTiles(location.getX()/64,location.getY()/64).hasItem()) {
            System.out.println(location.getX()+"  "+location.getY());
            inventory.store(controller.getTiles(location.getX() / 64, location.getY() / 64).getItems());
        }
        System.out.println(location.getX()+"  "+location.getY());
    }

    public void move(int x){
        if(!navigation.isMoving) {
            if (x == 0) {
                location.setDir(0);
                navigation.move(x);
            } else if (x == 1) {
                location.setDir(1);
                navigation.move(x);
            } else if (x == 2) {
                location.setDir(2);
                navigation.move(x);
            } else if (x == 3) {
                location.setDir(3);
                navigation.move(x);
            } else if (x == 4) {
                navigation.move(x);
            } else if (x == 5) {
                navigation.move(x);
            } else if (x == 6) {
                navigation.move(x);
            } else if (x == 7) {
                navigation.move(x);
            }
        }

    }

    @Override
    public void render(Graphics g) {
        if (location.getDir() == 0) {
            g.drawImage(Assets.avatar,
                    (int) (getX() - controller.getCamera().getxOffset()) + Tile.TILEWIDTH / 2 - width / 2,
                    (int) (getY() - controller.getCamera().getyOffset()),
                    width,
                    height,
                    null
            );
        }
        else if(location.getDir() == 1){
            g.drawImage(Assets.sword,
                    (int) (getX() - controller.getCamera().getxOffset()) + Tile.TILEWIDTH / 2 - width / 2,
                    (int) (getY() - controller.getCamera().getyOffset()),
                    width,
                    height,
                    null
            );
        }
        else if(location.getDir() == 2){
            g.drawImage(Assets.sack,
                    (int) (getX() - controller.getCamera().getxOffset()) + Tile.TILEWIDTH / 2 - width / 2,
                    (int) (getY() - controller.getCamera().getyOffset()),
                    width,
                    height,
                    null
            );
        }
        else if(location.getDir() == 3){
            g.drawImage(Assets.boots,
                    (int) (getX() - controller.getCamera().getxOffset()) + Tile.TILEWIDTH / 2 - width / 2,
                    (int) (getY() - controller.getCamera().getyOffset()),
                    width,
                    height,
                    null
            );
        }

    }


    public Inventory getInventory(){return inventory;}
    public Nav getNavigation(){
        return this.navigation;
    }

    public void savePlayer(ArrayList<Object> saveFile)
    {


        //needs to get the stats next
        //needs to get the inventory
        //
        //as a VERY possible possibility i can instead of getting an Object array, just get an array List of ints for location, stats, and maybe inventory
        saveFile.add(this.getLocation());

        saveFile.add(this.getStats()); //okay as a note I should now be able to do getStats().(specific stat)
        //getInventory().saveInventory(saveFile); //fixme


    }

    public void loadPlayer(ArrayList<Object> saveFile)
    {
        Location l = new Location((int)saveFile.get(0),(int)saveFile.get(1),0);
        this.setLocation(l);
        this.getStats().getPrimaryStats().setLivesLeft((int)saveFile.get(2));
        this.getStats().getPrimaryStats().setBaseLives((int)saveFile.get(3)); //idk if this is being changed 3
        this.getStats().getPrimaryStats().setStrength((int)saveFile.get(4));
        this.getStats().getPrimaryStats().setBaseStr((int)saveFile.get(5));
        this.getStats().getPrimaryStats().setAgility((int)saveFile.get(6));
        this.getStats().getPrimaryStats().setBaseAgi((int)saveFile.get(7));
        this.getStats().getPrimaryStats().setIntellect((int)saveFile.get(8));
        this.getStats().getPrimaryStats().setBaseIntel((int)saveFile.get(9));
        this.getStats().getPrimaryStats().setHardiness((int)saveFile.get(10));
        this.getStats().getPrimaryStats().setBaseHard((int)saveFile.get(11));
        this.getStats().getPrimaryStats().setExperience((int)saveFile.get(12));
        this.getStats().getPrimaryStats().setMovement((int)saveFile.get(13));
        this.getStats().getPrimaryStats().setBaseMovement((int)saveFile.get(14));
        this.getStats().getDerivedStats().setLevel((int)saveFile.get(15));
        this.getStats().getDerivedStats().setLife((int)saveFile.get(16));
        this.getStats().getDerivedStats().setBaseLife((int)saveFile.get(17));
        this.getStats().getDerivedStats().setMana((int)saveFile.get(18));
        this.getStats().getDerivedStats().setBaseMana((int)saveFile.get(19));
        this.getStats().getDerivedStats().setOffensiveRating((int)saveFile.get(20));
        this.getStats().getDerivedStats().setDefensiveRating((int)saveFile.get(21));
        this.getStats().getDerivedStats().setArmorRating((int)saveFile.get(22));

        System.out.println(this.getStats().toString());



                /*
                The Order it is read in.
                public int getLivesLeft() { return primaryStats.getLivesLeft(); }
                public int getBaseLives() { return primaryStats.getBaseLives(); }
                 public int getStrength() { return primaryStats.getStrength(); }
                public int getBaseStr() { return primaryStats.getBaseStr(); }
                public int getAgility() { return primaryStats.getAgility(); }
                public int getBaseAgi() { return primaryStats.getBaseAgi(); }
    public int getIntellect() { return primaryStats.getIntellect(); }
    public int getBaseIntel() { return primaryStats.getBaseIntel(); }
    public int getHardiness() { return primaryStats.getHardiness(); }
    public int getBaseHard() { return primaryStats.getBaseHard(); }
    public int getExperience() { return primaryStats.getExperience(); }
    public int getMovement() { return primaryStats.getMovement(); }
    public int getBaseMovement() { return primaryStats.getBaseMovement(); }
    public int getLevel() { return derivedStats.getLevel(); }
    public int getLife() { return derivedStats.getLife(); }
    public int getBaseLife() { return derivedStats.getBaseLife(); }
    public int getMana() { return derivedStats.getMana(); }
    public int getBaseMana() { return derivedStats.getBaseMana(); }
    public int getOffensiveRating() { return derivedStats.getOffensiveRating(); }
    public int getDefensiveRating() { return derivedStats.getDefensiveRating(); }
    public int getArmorRating() { return derivedStats.getArmorRating(); }
    public EquipmentStats getEquipmentStats() { return primaryStats.getEquipmentStats();

                 */



    }
    public Location getLocation(){
        return location;
    }
}
