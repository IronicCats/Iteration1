package Model.Item;

/**
 * Created by Wimberley on 2/3/16.
 */
public class Takeable {

    private int usesLeft;
    private int id;
    public Takeable(int id, int usesLeft)
    {
        this.id = id;
        this.usesLeft = usesLeft;
    }

    public String toString()
    {
        String string;
        string = (this.id + " " + this.usesLeft + "\n");
        return string;
    }
}
