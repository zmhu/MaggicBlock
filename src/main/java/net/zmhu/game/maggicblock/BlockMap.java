package net.zmhu.game.maggicblock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zmhu on 5/28/16.
 */
public class BlockMap {
    public static final int num = 5;
    Level level;
    private String [][] map;
    private String [][] map_tmp;
    public BlockMap (Level l) {
        this.level = l;
        this.map = new String[num][this.level.getValue()];
        this.cleanMap();
    }

    public void cleanMap () {
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[i].length; j ++) {
                this.map[i][j] = "0";
            }
        }
        //this.map_tmp = this.map.clone();
    }

    public boolean hasAddBlock (String [][] block, int [] ct) {
        int x, y;
        for (int i = 0; i < block.length; i ++) {
            for (int j = 0; j < block.length; j ++) {
                x = ct[0] + i;
                y = ct[1] + j;
                if (x < num && y < level.getValue() && x >= 0 && y >= 0 && this.map[x][y].equals("0")) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    public void removeBlock2Map (String [][] block, int [] ct) {
        this.optionBlock2Map(block,ct,false);
    }
    public void addBlock2Map (String [][] block, int [] ct) {
        this.optionBlock2Map(block,ct,true);
    }
    public void optionBlock2Map (String [][] block, int [] ct, boolean add) {
        int x, y;
        int [] b = new int[2];
        for (int i = 0; i < block.length; i ++) {
            for (int j = 0; j < block.length; j ++) {
                x = ct[0] + i;
                y = ct[1] + j;
                if (add)
                    this.map[x][y] = block[i][j];
                else
                    this.map[x][y] = "0";
            }
        }
    }

    public void printMap () {
        for (int i = 0; i < this.map.length; i ++) {
            for (int j = 0; j < this.map[i].length; j++) {
                System.out.print(this.map[i][j]);
            }
            System.out.println();
        }
    }

    public static int getRow () {
        return num;
    }
}
