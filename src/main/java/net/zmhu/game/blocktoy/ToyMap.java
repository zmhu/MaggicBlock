package net.zmhu.game.blocktoy;


import net.zmhu.game.blocktoy.blocks.Block;

/**
 * Created by zmhu on 6/1/16.
 */
public class ToyMap {
    public static int rows = 5;
    Level level;
    public ToyMap (Level level) {
        this.level = level;
        this.initMap();
    }

    public boolean canPut (Block block, int [] coordinate) {
        String [][] blockUnits = block.getCurrentBlockUnits();
        return this.canPut(blockUnits,coordinate);
    }

    public boolean canPut(String [][] blockUnits, int [] coordinate) {
        return this.isInMap(blockUnits, coordinate);
    }

    public boolean isInMap (String [][] blockUnits, int [] coordinate ) {
        int x,y;
        for (int i = 0; i < blockUnits.length; i ++) {
            for (int j = 0; j < blockUnits[i].length; j ++) {
                x = coordinate[0] + i;
                y = coordinate[1] + j;
                if (x >= 0 && y >= 0 && x < rows && y < this.level.getValue()) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isFull () {
        boolean isFull = true;
        for (int i = 0; i < this.map.length; i ++) {
            for (int j = 0; j < this.map[i].length; j ++) {
                if (this.map[i][j].equals("0")) {
                    isFull = false;
                }
            }
        }
        return isFull;
    }

    public void putIntoMap (Block block, int [] coordinate) {
        String [][] blockUnits = block.getCurrentBlockUnits();
        this.putIntoMap(blockUnits, coordinate);
    }

    public boolean putIntoMap (String [][] blockUnits, int [] coordinate) {
        int x,y;
        for (int i = 0; i < blockUnits.length; i ++) {
            for (int j = 0; j < blockUnits[i].length; j ++) {
                x = coordinate[0] + i;
                y = coordinate[1] + j;
                if (!blockUnits[i][j].equals("0") && !this.map[x][y].equals("0")) {
                    return false;
                }
                if (!blockUnits[i][j].equals("0")) {
                    this.map[x][y] = blockUnits[i][j];
                }
            }
        }
        return true;
    }

    public void removeBlock (Block block, int [] coordinate) {
        String [][] blockUnits = block.getCurrentBlockUnits();
        this.removeBlock(blockUnits, coordinate);
    }

    public void removeBlock (String [][] blockUnits, int [] coordinate) {
        int x,y;
        for (int i = 0; i < blockUnits.length; i ++) {
            for (int j = 0; j < blockUnits[i].length; j ++) {
                x = coordinate[0] + i;
                y = coordinate[1] + j;
                this.map[x][y] = "0";
            }
        }
    }

    public void clearMap () {
        for (int i = 0; i < this.map.length; i ++) {
            for (int j = 0; j < this.map[i].length; j ++) {
                this.map[i][j] = "0";
            }
        }
    }


    String [][] map;
    public void initMap () {
        this.map = new String[rows][this.level.getValue()];
        this.clearMap();
    }

    public void printMap () {
        for (int i = 0; i < this.map.length; i ++) {
            for (int j = 0; j < this.map[i].length; j ++) {
                //this.map[i][j] = "0";
                System.out.print(this.map[i][j]);
            }
            System.out.println();
        }
    }
}
