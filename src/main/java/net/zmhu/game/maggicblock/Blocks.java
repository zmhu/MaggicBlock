package net.zmhu.game.maggicblock;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zmhu on 5/30/16.
 */
public class Blocks {

    Map<Integer,String[][]> blocks = new HashMap<Integer,String[][]>();

    public Blocks () {
        this.initBlocks();
    }

    public Map<Integer,String[][]> getBlockList () {
        return this.blocks;
    }


    private void initBlocks () {
        // add 1
        String [][] block1 = {
                {"1","1","1","1","1"},
                {"0","0","0","0","0"}
        };
        //this.blockList[0] = block1;
        this.blocks.put(1,block1);

        //add 2
        String [][] block2 = {
                {"2","2","0"},
                {"0","2","2"},
                {"0","2","0"}
        };
        //this.blockList[1] = block2;
        this.blocks.put(2,block2);
        //add 3
        String [][] block3 = {
                {"3","0","0"},
                {"3","0","0"},
                {"3","3","3"}
        };
        //this.blockList[2] = block3;
        this.blocks.put(3,block3);
        //add 4
        String [][] block4 = {
                {"4","4","4","4"},
                {"0","0","4","0"}
        };
        //this.blockList[3] = block4;
        this.blocks.put(4,block4);
        //add 5
        String [][] block5 = {
                {"0","5","0"},
                {"5","5","5"},
                {"0","5","0"}
        };
        //this.blockList[4] = block5;
        this.blocks.put(5,block5);
        //add 6
        String [][] block6 = {
                {"0","6","0"},
                {"0","6","0"},
                {"6","6","6"}
        };
        //this.blockList[5] = block6;
        this.blocks.put(6,block6);
        //add 7
        String [][] block7 = {
                {"7","7","0"},
                {"0","7","0"},
                {"0","7","7"}
        };
        //this.blockList[6] = block7;
        this.blocks.put(7,block7);
        //add 8
        String [][] block8 = {
                {"8","8","8"},
                {"8","8","0"}
        };
        //this.blockList[7] = block8;
        this.blocks.put(8,block8);
        //add 9
        String [][] block9 = {
                {"9","9","0","0"},
                {"0","9","9","9"}
        };
        //this.blockList[8] = block9;
        this.blocks.put(9,block9);
        //add 10
        String [][] block10 = {
                {"A","0","A"},
                {"A","A","A"}
        };
        //this.blockList[9] = block10;
        this.blocks.put(10,block10);
        //add 11
        String [][] block11 = {
                {"0","B","B"},
                {"B","B","0"},
                {"B","0","0"}
        };
        //this.blockList[10] = block11;
        this.blocks.put(11,block11);
        //add 12
        String [][] block12 = {
                {"0","C"},
                {"0","C"},
                {"0","C"},
                {"C","C"}
        };
        //this.blockList[11] = block12;
        this.blocks.put(12,block12);

    }
}
