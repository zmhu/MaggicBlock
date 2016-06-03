package net.zmhu.game.blocktoy.test;

import net.zmhu.game.blocktoy.blocks.Block;
import net.zmhu.game.blocktoy.blocks.BlockFactory;

import java.util.Map;

/**
 * Created by zmhu on 6/1/16.
 */
public class TestBlock {
    public static void main (String [] args) {
        BlockFactory bf = BlockFactory.getInstance();
        Block b1 = bf.getBlock(12);
        while (b1.hasNextDirection()) {
            b1.nextDirection();
            b1.printCurrent();
            System.out.println();
        }

        Map<Integer,Block> blocks = bf.getBlocks(new int[] {8,10,2,4});
        for(Block b: blocks.values()) {
            System.out.println();
            b.printCurrent();
        }
    }
}
