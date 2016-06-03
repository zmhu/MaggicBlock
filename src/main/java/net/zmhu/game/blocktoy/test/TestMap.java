package net.zmhu.game.blocktoy.test;

import net.zmhu.game.blocktoy.Level;
import net.zmhu.game.blocktoy.ToyMap;
import net.zmhu.game.blocktoy.blocks.Block;
import net.zmhu.game.blocktoy.blocks.BlockFactory;

/**
 * Created by zmhu on 6/1/16.
 */
public class TestMap {

    public static void main (String [] args) {
        //{"8","10","2","4"}
        ToyMap tm = new ToyMap(Level.TWELEVE);
        tm.printMap();
        BlockFactory bf = BlockFactory.getInstance();
        Block b1 = bf.getBlock(1);
        System.out.println("test map");
        boolean bl = tm.canPut(b1,new int[] {0,0});
        System.out.println(bl);
        if (bl) {
            tm.putIntoMap(b1, new int[] {0,0});
            tm.printMap();
        }
        System.out.println();
        Block b2 = bf.getBlock(2);
        b2.nextDirection();
        b2.nextDirection();
        if (tm.canPut(b2,new int[]{1,5})) {
            tm.putIntoMap(b2,new int[] {1,5});
            tm.printMap();
        }

        System.out.println();

        Block b3 = bf.getBlock(3);
        if (tm.canPut(b3, new int[] {0,1})) {
            tm.putIntoMap(b3,new int[]{1,1});
            tm.printMap();
        }

        tm.removeBlock(b2, new int[] {1,5});
        tm.printMap();
    }
}
