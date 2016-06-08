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
        this.blocks = BlockFactory.getInstance().getBlocks(blocks);
        this.initAllBlocks();
        this.blockSelector = new BlockSelector(this.mblocks);
    }
    BlockSelector blockSelector;

    int tryCount = 0;
    public void work () {
        while (this.blockSelector.hasNextGroup()) {
            //this.tryPutOneGroup(this.blockSelector.nextGroup(),this.map);//1474560
            this.tryPutAGroup(this.blockSelector.nextGroupWithPattern(),this.map);//1129582
            tryCount ++;
        }
        System.out.print("Try Count: " + this.tryCount);
        System.out.println("\tSuccess Count: " + this.successCount);
        this.blockSelector.savePatterns();
    }

    int successCount = 0;

    public boolean tryPutAGroup (List<Mblock> aGroup, ToyMap _map) {
        Mblock _mblock;
        boolean bl = false;
        if (aGroup == null) return false;
        for (int i=0 ; i < aGroup.size(); i ++ ) {
            _mblock = aGroup.get(i);
            if (!_map.putIntoMap(_mblock.getBlockUnits(), _mblock.getCoordinate())) {
                bl = false;
                break;
            }
        }
        if (_map.isFull()) {
            System.out.println("SuccessFul!");
            _map.printMap();
            bl = true;
            this.successCount ++;
        }
        aGroup.clear();
        _map.clearMap();
        return bl;
    }

    public boolean tryPutOneGroup (Stack<Mblock> oneGroup, ToyMap _map) {
        Mblock _mblock;
        boolean bl = false;
        while (!oneGroup.empty()) {
            _mblock = oneGroup.pop();
            if (!_map.putIntoMap(_mblock.getBlockUnits(), _mblock.getCoordinate())) {
                bl = false;
                break;
            }
        }
        if (_map.isFull()) {
            System.out.println("Successful!");
            _map.printMap();
            bl = true;
        }
        oneGroup.clear();
        _map.clearMap();
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
                            if (this.map.hasPutAngle(b.getCurrentBlockUnits(), new int[]{i,j})) {
                                if (this.map.hasPutSide(b.getBlockId(),b.getCurrentDirection(),new int[] {i,j})) {
                                    mblock = new Mblock(b.getCurrentBlockUnits().clone(), b.getBlockId());
                                    mblock.setCoordinate(i, j);
                                    mblock.setDirection(b.getCurrentDirection());
                                    oneblocks.add(mblock);
                                }
                            }
                        }
                    }
                }
            }
            this.mblocks.put(b.getBlockId(), oneblocks);
            System.out.println("block id: " + b.getBlockId() + ", count: " + oneblocks.size());
        }
        System.out.println("Init mblocks done");
    }

    public static void main (String [] args) {
        Level _level;
        int [] _bs;
        //_level = Level.FOUR;
        //_bs = new int[] {8,10,2,4};
        /*
        _level = Level.TWELEVE;
        _bs = new int[] {1,2,3,4,5,6,7,8,9,10,11,12};
        */

        //Try Count: 180674269	Success Count: 22
        //Try Count: 441471042, Success Count: 24
        //Try Count: 305770410	Success Count: 22
        //Try Count: 635830272	Success Count: 24
        //Try Count: 28314113	Success Count: 24
        //Try Count: 1814529	Success Count: 24
        //Try Count: 167229441	Success Count: 24
        //_level = Level.FIVE;
        //_bs = new int[] {8,12,9,4,3};

        //Try Count: 1008307697	Success Count: 64
        //Try Count: 50826865	Success Count: 64
        _level = Level.SIX;
        //_bs = new int[] {8,11,4,3,9,1};
        //_bs = new int[] {12,4,6,8,11,7};//A
        //_bs = new int[] {9,8,10,12,7,4};//B
        //_bs = new int[] {12,3,8,4,9,10};//C
        _bs = new int[] {4,8,10,9,3,2};//D
        //_bs = new int[] {12,9,3,7,10,6};//E


        BlockToy blockToy = new BlockToy(_level, _bs);
        blockToy.work();
    }
}
