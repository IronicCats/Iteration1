package Model.Entity.Inventory;

import Model.Item.Item;

/**
 * Created by broskj on 2/1/16.
 */

public class Pack {
    protected int size;
    protected Item[] items;
    protected final int cap;

    public Pack(int cap) {
        this.size = 0;
        this.items = new Item[cap];
        this.cap = cap;
    } // end constructor

    public Pack (int size, Item[] items, int cap) {
        this.size = size;
        this.items = items;
        this.cap = cap;
        for(int i=0;i<cap;i++)
            items[i]=null;

    } // end constructor
    public void add(Item item){


    }


} // end class Pack
