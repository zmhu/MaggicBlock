package net.zmhu.game.blocktoy;

import net.zmhu.game.blocktoy.blocks.Block;
import net.zmhu.game.blocktoy.blocks.BlockFactory;
import net.zmhu.game.blocktoy.blocks.Mblock;

import java.util.*;

public class BlockToy {

    ToyMap map;
    Level level;
    Map<Integer,Block> blocks;

    public BlockToy (Level level) {
        this.level = level;
        this.map = new ToyMap(level);
        //{"8","10","2","4"}
        this.blocks = BlockFactory.getInstance().getBlocks(new int[] {8,10,2,4});
        this.initAllBlocks();
    }

    public void work () {
        //
    }

    Map<Integer,Integer> cusor = new HashMap<Integer, Integer>();
    Stack<Mblock> finishedBlock = new Stack<Mblock>();
    public void tryingPut () {
        Mblock mblock;
        do {
            for (int blockid : this.mblocks.keySet()) {
                if ((this.mblocks.get(blockid).size() -1) == this.cusor.get(blockid)) {
                    mblock = this.finishedBlock.pop();
                    this.map.removeBlock(mblock.getBlockUnits(),mblock.getCoordinate());
                    this.cusor.put(blockid,0);
                    break;
                }
                if (this.tryPutOneBlock(blockid)) {
                    this.finishedBlock.push(this.mblocks.get(blockid).get(this.cusor.get(blockid)));
                } else {
                    break;
                }
            }
        }while (true);
    }

    public boolean tryPutOneBlock (int blockid) {
        boolean bl = false;
        int curs = this.cusor.get(blockid);
        curs ++;
        Mblock mblock = this.mblocks.get(blockid).get(curs);
        if (this.map.canPut(mblock.getBlockUnits(), mblock.getCoordinate())) {
            this.map.putIntoMap(mblock.getBlockUnits(), mblock.getCoordinate());
            bl = true;
        }
        /*
        if (curs >= (this.mblocks.get(blockid).size() -1)) {
            curs = 0;
        }*/
        this.cusor.put(blockid, curs);
        if (curs < (this.mblocks.get(blockid).size() - 1) && !bl) {
            return this.tryPutOneBlock(blockid);
        } else {
            return bl;
        }
    }

    Map<Integer,List<Mblock>> mblocks = new HashMap<Integer, List<Mblock>>();
    public void initAllBlocks () {
        List<Mblock> oneblocks = new ArrayList<Mblock>();
        Mblock mblock = null;
        for (Block b: this.blocks.values()) {
            for (int i = 0; i < this.map.map.length; i ++) {
                for (int j = 0; j < this.map.map[i].length; j ++) {
                    //
                    while (b.hasNextDirection()) {
                        mblock = new Mblock(b.getCurrentBlockUnits().clone(),b.getBlockId());
                        mblock.setCoordinate(i,j);
                        mblock.setDirection(b.getCurrentDirection());
                        oneblocks.add(mblock);
                    }
                }
            }
            this.mblocks.put(b.getBlockId(),oneblocks);
            this.cusor.put(b.getBlockId(),0);
        }
    }
}
