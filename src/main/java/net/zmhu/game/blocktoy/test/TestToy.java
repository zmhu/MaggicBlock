package net.zmhu.game.blocktoy.test;

import net.zmhu.game.blocktoy.BlockToy;
import net.zmhu.game.blocktoy.Level;
import net.zmhu.game.blocktoy.blocks.Mblock;

import java.util.Stack;

/**
 * Created by zmhu on 6/6/16.
 */
public class TestToy {
    public static void main (String [] args) {
        Stack<Mblock> _mblocks = new Stack<Mblock>();
        String [][] b1 = new String[][] {
                {"8","8","8"},
                {"8","8","0"}
        };
        int [] ct1 = new int[] {0,0};
        Mblock bl1 = new Mblock(b1, 8);
        bl1.setCoordinate(ct1[0],ct1[1]);
        _mblocks.push(bl1);

        String [][] b2 = new String[][] {
                {"A","A"},
                {"A","0"},
                {"A","A"}
        };
        int [] ct2 = new int[] {2,0};
        Mblock bl2 = new Mblock(b2,10);
        bl2.setCoordinate(ct2[0],ct2[1]);
        _mblocks.push(bl2);

        String [][] b3 = new String[][] {
                {"0","4"},
                {"4","4"},
                {"0","4"},
                {"0","4"}
        };
        int [] ct3 = new int[] {0,2};
        Mblock bl3 = new Mblock(b3,4);
        bl3.setCoordinate(ct3[0],ct3[1]);
        _mblocks.push(bl3);


        String [][] b4 = new String[][] {
                {"0","2","0"},
                {"2","2","0"},
                {"0","2","2"}
        };
        int [] ct4 = new int[] {2,1};
        Mblock bl4 = new Mblock(b4,2);
        bl4.setCoordinate(ct4[0],ct4[1]);
        _mblocks.push(bl4);
        BlockToy bt = new BlockToy(Level.FOUR,new int[]{2,8,10,4});
        //bt.tryPutOneGroup(_mblocks);



    }
}
