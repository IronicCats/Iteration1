package Model.Entity.Inventory;

import Model.Item.*;

/**
 * Created by broskj on 2/1/16.
 */


public class Pack {

    protected int size;
    protected Takeable[] items;
    protected final int cap;


    public Pack(int cap) {
        this.size = 0;
        this.items = new Takeable[cap];
        this.cap = cap;
        for(int i = 0; i < cap; ++i) {
            items[i] = null;
        }
    } // end constructor

    public Pack (int size, Takeable[] items, int cap) {
        this.size = size;
        this.items = items;
        this.cap = cap;
        for(int i=0;i<cap;i++)
            items[i]=null;

    } // end constructor
    public void add(Item item){


    }



    public String toString()
    {
        String packString = "";
        for(int i = 0; i < size; i++)
        {

            //System.out.print(items[i]);
            if(items[i].getType() == ItemsEnum.WEAPON)
            {
                //System.out.println("A WEAPON TO SURPASS METAL GEAR");
                packString = packString + ((Weapon)items[i]).toString();
            }
            else if(items[i].getType() == ItemsEnum.ARMOR){
                //System.out.println("so safe");
                packString = packString + ((Armor)items[i]).toString();
            }
            else if(items[i].getType() == ItemsEnum.USEABLE)
            {
                //System.out.println("don't do drugs kids" + i);
                packString = packString + ((Useable)items[i]).toString();
            }

        }
        return packString;
    }

    public int getCap() {
        return cap;
    }

    public int getSize() {
        return size;
    }



} // end class Pack
