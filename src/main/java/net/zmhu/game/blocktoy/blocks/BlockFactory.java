package net.zmhu.game.blocktoy.blocks;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zmhu on 6/1/16.
 */
public class BlockFactory {
    private static BlockFactory blockFactory;
    static {
        blockFactory = new BlockFactory();
    }

    private BlockFactory() {
        this.initAllBlocks();
    }

    public static BlockFactory getInstance () {
        return blockFactory;
    }

    public Map<Integer,Block> getBlocks (int [] idarr) {
        Map<Integer, Block> bs = new HashMap<Integer, Block>();
        Block b;
        for (int i = 0; i < idarr.length; i ++) {
            //bs.put()
            b = this.blocks.get(idarr[i]);
            bs.put(b.getBlockId(),b);
        }
        return bs;
    }

    public Block getBlock (int id) {
        return this.blocks.get(id);
    }

    public Map<Integer,Block> getAllBlocks () {
        return this.blocks;
    }

    Map<Integer,Block> blocks = new HashMap<Integer, Block>();
    private void initAllBlocks () {
        //add1
        String [][] block1 = {
                {"1","1","1","1","1"}
        };
        Block b1 = new Block(1,block1);
        b1.setDirections(new Directions[]{
                Directions.NORMAL,
                Directions.RIGHTROTATE90D
        });
        this.blocks.put(1,b1);

        //add 2
        String [][] block2 = {
                {"2","2","0"},
                {"0","2","2"},
                {"0","2","0"}
        };
        Block b2 = new Block(2,block2);
        b2.setDirections(new Directions[]{
                Directions.NORMAL,
                Directions.RIGHTROTATE90D,
                Directions.RIGHTROTATE180D,
                Directions.LEFTROTATE90D,
                Directions.TURNOVER,
                Directions.TURNOVERANDRIGHTROTATE90D,
                Directions.TURNOVERRIGHTROTATE180D,
                Directions.TURNOVERANDLEFTROTATE90D,
        });
        this.blocks.put(2,b2);

        //add 3
        String [][] block3 = {
                {"3","0","0"},
                {"3","0","0"},
                {"3","3","3"}
        };
        Block b3 = new Block(3,block3);
        b3.setDirections(new Directions[]{
                Directions.NORMAL,
                Directions.RIGHTROTATE90D,
                Directions.RIGHTROTATE180D,
                Directions.LEFTROTATE90D
        });
        this.blocks.put(3,b3);

        //add 4
        String [][] block4 = {
                {"4","4","4","4"},
                {"0","0","4","0"}
        };
        Block b4 = new Block(4, block4);
        b4.setDirections(new Directions[]{
                Directions.NORMAL,
                Directions.RIGHTROTATE90D,
                Directions.RIGHTROTATE180D,
                Directions.LEFTROTATE90D,
                Directions.TURNOVER,
                Directions.TURNOVERANDRIGHTROTATE90D,
                Directions.TURNOVERRIGHTROTATE180D,
                Directions.TURNOVERANDLEFTROTATE90D,
        });
        this.blocks.put(4,b4);

        //add 5
        String [][] block5 = {
                {"0","5","0"},
                {"5","5","5"},
                {"0","5","0"}
        };
        Block b5 = new Block(5, block5);
        b5.setDirections(new Directions[]{Directions.NORMAL});
        this.blocks.put(5, b5);

        //add 6
        String [][] block6 = {
                {"0","6","0"},
                {"0","6","0"},
                {"6","6","6"}
        };
        Block b6 = new Block(6, block6);
        b6.setDirections(new Directions[]{
                Directions.NORMAL,
                Directions.RIGHTROTATE90D,
                Directions.RIGHTROTATE180D,
                Directions.LEFTROTATE90D
        });
        this.blocks.put(6,b6);

        //add 7
        String [][] block7 = {
                {"7","7","0"},
                {"0","7","0"},
                {"0","7","7"}
        };
        Block b7 = new Block(7, block7);
        b7.setDirections(new Directions[]{
                Directions.NORMAL,
                Directions.RIGHTROTATE90D,
                Directions.TURNOVER,
                Directions.TURNOVERANDRIGHTROTATE90D
        });
        this.blocks.put(7, b7);

        //add 8
        String [][] block8 = {
                {"8","8","8"},
                {"8","8","0"}
        };
        Block b8 = new Block(8, block8);
        b8.setDirections(new Directions[] {
                Directions.NORMAL,
                Directions.RIGHTROTATE90D,
                Directions.RIGHTROTATE180D,
                Directions.LEFTROTATE90D,
                Directions.TURNOVER,
                Directions.TURNOVERANDRIGHTROTATE90D,
                Directions.TURNOVERRIGHTROTATE180D,
                Directions.TURNOVERANDLEFTROTATE90D,
        });
        this.blocks.put(8, b8);

        //add 9
        String [][] block9 = {
                {"9","9","0","0"},
                {"0","9","9","9"}
        };
        Block b9 = new Block(9, block9);
        b9.setDirections(new Directions[]{
                Directions.NORMAL,
                Directions.RIGHTROTATE90D,
                Directions.RIGHTROTATE180D,
                Directions.LEFTROTATE90D,
                Directions.TURNOVER,
                Directions.TURNOVERANDRIGHTROTATE90D,
                Directions.TURNOVERRIGHTROTATE180D,
                Directions.TURNOVERANDLEFTROTATE90D,
        });
        this.blocks.put(9, b9);

        //add 10
        String [][] block10 = {
                {"A","0","A"},
                {"A","A","A"}
        };
        Block b10 = new Block(10, block10);
        b10.setDirections(new Directions[] {
                Directions.NORMAL,
                Directions.RIGHTROTATE90D,
                Directions.RIGHTROTATE180D,
                Directions.LEFTROTATE90D
        });
        this.blocks.put(10, b10);

        //add 11
        String [][] block11 = {
                {"0","B","B"},
                {"B","B","0"},
                {"B","0","0"}
        };
        Block b11 = new Block(11, block11);
        b11.setDirections(new Directions[] {
                Directions.NORMAL,
                Directions.RIGHTROTATE90D,
                Directions.RIGHTROTATE180D,
                Directions.LEFTROTATE90D
        });
        this.blocks.put(11, b11);

        //add 12
        String [][] block12 = {
                {"0","C"},
                {"0","C"},
                {"0","C"},
                {"C","C"}
        };
        Block b12 = new Block(12, block12);
        b12.setDirections(new Directions[] {
                Directions.NORMAL,
                Directions.RIGHTROTATE90D,
                Directions.RIGHTROTATE180D,
                Directions.LEFTROTATE90D,
                Directions.TURNOVER,
                Directions.TURNOVERANDRIGHTROTATE90D,
                Directions.TURNOVERRIGHTROTATE180D,
                Directions.TURNOVERANDLEFTROTATE90D,
        });
        this.blocks.put(12, b12);
    }
}
