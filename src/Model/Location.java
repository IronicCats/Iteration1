package Model;

/**
 * Created by jlkegley on 1/31/2016.
 */
public class Location {
    private int x, y, dir;

    public Location(int x, int y, int dir) {
        this.x = x * 64;
        this.y = y * 64;
        this.dir = dir;
    }

    public int getX() {
        return x/64;
    }

    public void setX(int x) {
        this.x = x*64;
    }

    public int getY() {
        return y/64;
    }

    public void setY(int y) {
        this.y = y*64;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }


    public String toString(){
        String locString;
        locString = (this.x + "\n" + this.y + "\n");
        return locString;
    }
}
