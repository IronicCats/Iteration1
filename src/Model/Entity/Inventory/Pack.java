package Model.Entity.Inventory;

import Model.Item.*;
import Model.Item.Takeable.Takeable;

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

    public int indexOf(String name) {
        for(int i = 0; i < cap; i++)
            if(items[i] != null)
                if(items[i].getName().equals(name))
                    return i;
        return -1;
    }


    public String toString()
    {
        String packString = "";
        int position = 0;
        for(int i = 0; i < size; i++)
        {


            System.out.println(position);
            if(items[position] == null)
            {
                //System.out.println(position + " out loop");
                while(items[position] == null)
                {
                    //System.out.println(position + " in loop");
                    position++;
                }
            }
            if(items[position].getType() == ItemsEnum.WEAPON)
            {
                packString = packString + ((Weapon)items[position]).toString();
                position++;
            }
            else if(items[position].getType() == ItemsEnum.ARMOR){

                packString = packString + ((Armor)items[position]).toString();
                position++;
            }
            else if(items[position].getType() == ItemsEnum.USEABLE)
            {

                packString = packString + ((Useable)items[position]).toString();
                position++;
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

    public void deleteItem(int index) {
        items[index] = null;
    }

} // end class Pack
