package net.zmhu.game.maggicblock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by zmhu on 5/28/16.
 */

public class MaggicBlock {

    Level level;
    public void setLevel (Level level) {
        this.level = level;
    }

    BlockMap blockMap;
    public void initBlockMap () {
        this.blockMap = new BlockMap(this.level);
    }

    Blocks blocks;
    Map<Integer,Block> blockList;
    public void initBlocks () {
        this.blocks = new Blocks();
        this.blockList = this.blocks.getBlocks(this.blockDefine);
    }

    public void run () {
        System.out.println("Run:");
        this.initBlockMap();
        this.initBlocks();
        Block bl;
        boolean b;
        System.out.println("blocks: " +this.blockList.keySet().size());
        for (int i: this.blockList.keySet()) {
            bl = this.blockList.get(i);
            System.out.println("process block:" + i + "," + bl);
            for (BlockStatus bs : BlockStatus.values()) {
                b = this.putOneBlockToMap(bl.getBlock(bs));
                if (b) {
                    Block.printBlock(bl.getCurrentBlock());
                    System.out.println();
                    this.blockMap.printMap();
                }
                //else this.blockMap.printMap();
            }
        }
        //System.out.println("faild");
    }

    Stack<Block> finishedBlocks = new Stack<Block>();
    Stack<Block> surplusBlocks = new Stack<Block>();
    public void work () {
        this.initBlockMap();
        this.initBlocks();
        System.out.println("working...");
        Block block;
        for (int i: this.blockList.keySet()) {
            block = this.blockList.get(i);
            this.surplusBlocks.push(block);
        }
        boolean rt;
        do {
            block = this.surplusBlocks.pop();
            //rt = this.putOneBlockToMap(block.getCurrentBlock());
            if (block.hasNextDirection()) {
                rt = this.putOneBlockToMap(block.getNextDirection().getCurrentBlock());
            } else {
                System.out.println("faild");
                break;
            }
            if (rt) {
                this.finishedBlocks.push(block);
                Block.printBlock(block);
                this.blockMap.printMap();
            } else {
                block.resetBlockDirection();
                this.surplusBlocks.push(block);
                this.surplusBlocks.push(this.finishedBlocks.pop());
                //TODO: remove block from map
            }
        } while (!this.surplusBlocks.empty());
    }

    private boolean putOneBlockToMap (String [][] block) {
        int [] cx = new int[2];
        for (int i = 0; i < this.level.getValue(); i ++) {
            for (int j = 0; j < BlockMap.getRow(); j ++) {
                cx[0] = i;
                cx[1] = j;
                if (this.blockMap.hasAddBlock(block, cx)) {
                    this.blockMap.addBlock2Map(block, cx);
                    //this.blockMap.printMap();
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    String [] blockDefine = {"8","10","2","4"};

    public void setBlockDefine (String [] bd) {
        this.blockDefine = bd;
    }

    public static void main (String [] args) {
        MaggicBlock maggicBlock = new MaggicBlock();
        maggicBlock.setLevel(Level.FOUR);
        maggicBlock.work();
    }
}
