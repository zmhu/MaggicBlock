package net.zmhu.game.blocktoy.blocks;

/**
 * Created by zmhu on 6/3/16.
 */
public class Mblock {
    String [][] blockUnits;
    int blockId;
    int x,y;
    Directions direction;
    private int _hashCode = 0;
    public Mblock(String [][] blockUnits, int blockId) {
        this.blockUnits = blockUnits;
        this.blockId = blockId;
    }

    public int hashCode () {
        if (this._hashCode != 0)
            return this._hashCode;
        int bid = this.blockId;
        int x = this.x;
        int y = this.y;
        int d = this.direction.getValue();
        int hc = 0;
        hc += bid << 16;
        hc += x << 10;
        hc += y << 5;
        hc += d;
        this._hashCode = hc;

        return this._hashCode;
    }

    public String [][] getBlockUnits () {
        return this.blockUnits;
    }

    public int getBlockId () {
        return this.blockId;
    }
    public void setDirection (Directions d) {
        this.direction = d;
    }
    public Directions getDirection () {
        return this.direction;
    }

    public void setCoordinate (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void printBlock () {
        System.out.println("Coordinate: " + this.x + ", " + this.y);
        for (int i = 0; i < this.blockUnits.length; i ++) {
            for (int j = 0; j < this.blockUnits[i].length; j ++) {
                System.out.print(this.blockUnits[i][j]);
            }
            System.out.println();
        }
    }

    public int [] getCoordinate () {
        return new int[] {this.x,this.y};
    }
}
