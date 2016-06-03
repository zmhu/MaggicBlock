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
        int x,y;
        for (int i = 0; i < blockUnits.length; i ++) {
            for (int j = 0; j < blockUnits[i].length; j ++) {
                x = coordinate[0] + i;
                y = coordinate[1] + j;
                if (x >= 0 && y >= 0 && x < rows && y < this.level.getValue() && this.map[x][y].equals("0")) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public void putIntoMap (Block block, int [] coordinate) {
        String [][] blockUnits = block.getCurrentBlockUnits();
        int x,y;
        for (int i = 0; i < blockUnits.length; i ++) {
            for (int j = 0; j < blockUnits[i].length; j ++) {
                x = coordinate[0] + i;
                y = coordinate[1] + j;
                this.map[x][y] = blockUnits[i][j];
            }
        }
    }

    public void removeBlock (Block block, int [] coordinate) {
        String [][] blockUnits = block.getCurrentBlockUnits();
        int x,y;
        for (int i = 0; i < blockUnits.length; i ++) {
            for (int j = 0; j < blockUnits[i].length; j ++) {
                x = coordinate[0] + i;
                y = coordinate[1] + j;
                this.map[x][y] = "0";
            }
        }
    }


    String [][] map;
    public void initMap () {
        this.map = new String[rows][this.level.getValue()];
        for (int i = 0; i < this.map.length; i ++) {
            for (int j = 0; j < this.map[i].length; j ++) {
                this.map[i][j] = "0";
            }
        }
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
