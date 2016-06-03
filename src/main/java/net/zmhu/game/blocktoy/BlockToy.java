package net.zmhu.game.blocktoy;

import net.zmhu.game.blocktoy.blocks.Block;
import net.zmhu.game.blocktoy.blocks.BlockFactory;

import java.util.Map;

public class BlockToy {

    ToyMap map;
    Level level;
    Map<Integer,Block> blocks;

    public BlockToy (Level level) {
        this.level = level;
        this.map = new ToyMap(level);
        //{"8","10","2","4"}
        this.blocks = BlockFactory.getInstance().getBlocks(new int[] {8,10,2,4});
    }

    public void work () {
        for (Block b: this.blocks.values()) {
            //
        }
    }

    public boolean tryPutOneBlogToMap () {
        return false;
    }
}
