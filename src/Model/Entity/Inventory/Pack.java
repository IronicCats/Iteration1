package Model.Entity.Inventory;

import Model.Item.Item;

/**
 * Created by broskj on 2/1/16.
 */
public class Pack {


    private int size;
    private Item[] items;
    private final int cap;

    Pack(int cap) {
        this.size = 0;
        this.items = new Item[cap];
        this.cap = cap;
    } // end constructor

    Pack (int size, Item[] items, int cap) {
        this.size = size;
        this.items = items;
        this.cap = cap;
    } // end constructor

    public String toString()
    {
        String packString = "";
        for(int i = 0; i < items.length; i++)
        {
            packString = packString + items[i].toString();
        }
        return packString;
    }


} // end class Pack
