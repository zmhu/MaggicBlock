package net.zmhu.game.blocktoy;

import net.zmhu.game.blocktoy.blocks.Block;
import net.zmhu.game.blocktoy.blocks.BlockFactory;
import net.zmhu.game.blocktoy.blocks.Mblock;

import java.util.*;

public class BlockToy {

    ToyMap map;
    Level level;
    Map<Integer,Block> blocks;

    public BlockToy (Level level, int [] blocks) {
        this.level = level;
        this.map = new ToyMap(level);
        System.out.println("init map");
        this.map.printMap();
        //{"8","10","2","4"}
        this.blocks = BlockFactory.getInstance().getBlocks(blocks);
        this.initAllBlocks();
        this.blockSelector = new BlockSelector(this.mblocks);
    }

    BlockSelector blockSelector;

    Stack<Mblock> oneGroup = new Stack<Mblock>();
    public void work () {
        int key = this.mblocks.keySet().iterator().next();
        List<Mblock> firstBlocks = this.mblocks.get(key);
        this.mblocks.remove(key);
        //System.out.println("First Blocks :" + firstBlocks.size());
        while (this.blockSelector.hasNextGroup()) {
            this.tryPutOneGroup(this.blockSelector.nextGroup());
        }
    }

    public boolean tryPutOneGroup (Stack<Mblock> oneGroup) {
        Mblock _mblock;
        boolean bl = false;
        while (!oneGroup.empty()) {
            _mblock = oneGroup.pop();
            if (!this.map.putIntoMap(_mblock.getBlockUnits(), _mblock.getCoordinate())) {
                bl = false;
                break;
            }
        }
        if (this.map.isFull()) {
            System.out.println("Successful!");
            this.map.printMap();
            bl = true;
        }
        oneGroup.clear();
        this.map.clearMap();
        return bl;
    }

    Map<Integer,List<Mblock>> mblocks = new HashMap<Integer, List<Mblock>>();
    public void initAllBlocks () {
        List<Mblock> oneblocks;
        Mblock mblock = null;
        System.out.println("Init mblocks, maplen:" + this.map.map[0].length);
        int i,j;
        for (Block b: this.blocks.values()) {
            oneblocks = new ArrayList<Mblock>();
            while(b.hasNextDirection()) {
                b.nextDirection();
                for (i = 0; i < this.map.map.length; i++) {
                    for (j = 0; j < this.map.map[i].length; j++) {
                        if (this.map.isInMap(b.getCurrentBlockUnits(), new int[]{i,j})) {
                            mblock = new Mblock(b.getCurrentBlockUnits().clone(), b.getBlockId());
                            mblock.setCoordinate(i, j);
                            mblock.setDirection(b.getCurrentDirection());
                            oneblocks.add(mblock);
                        }
                    }
                }
            }
            this.mblocks.put(b.getBlockId(), oneblocks);
        }
        System.out.println("Init mblocks done");
    }

    public static void main (String [] args) {
        Level _level;
        int [] _bs;
        /*
        _level = Level.FOUR;
        _bs = new int[] {8,10,2,4};
        */
        _level = Level.SIX;
        _bs = new int[] {8,11,4,3,9,1};
        /*
        _level = Level.TWELEVE;
        _bs = new int[] {1,2,3,4,5,6,7,8,9,10,11,12};
        */

        BlockToy blockToy = new BlockToy(_level, _bs);
        blockToy.work();
    }
}
