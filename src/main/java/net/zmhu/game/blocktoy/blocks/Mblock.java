package net.zmhu.game.blocktoy.blocks;

/**
 * Created by zmhu on 6/3/16.
 */
public class Mblock {
    String [][] blockUnits;
    int blockId;
    int x,y;
    Directions direction;
    public Mblock(String [][] blockUnits, int blockId) {
        this.blockUnits = blockUnits;
        this.blockId = blockId;
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

    public int [] getCoordinate () {
        return new int[] {this.x,this.y};
    }
}
