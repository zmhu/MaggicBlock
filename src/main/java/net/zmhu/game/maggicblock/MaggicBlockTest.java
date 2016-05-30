package net.zmhu.game.maggicblock;

import java.util.Map;

/**
 * Created by zmhu on 5/30/16.
 */
public class MaggicBlockTest {
    public static void main (String [] args) {

        //testLevel();
        testMap();
        testBlockList();
        testBlock();
    }

    public static void testBlock () {
        Blocks bs = new Blocks();
        Map<Integer,String[][]> bl = bs.getBlockList();
        String [][] b;
        Block block;
        for (int i : bl.keySet()) {
            b = bl.get(i);
            block = new Block(b);
            System.out.println("Print Normal Block:");
            Block.printBlock(block.getNormalBlock());
            System.out.println("Print Right Rotate 90 Degrees:");
            Block.printBlock(Block.getRightRotate90Degrees(block.getNormalBlock()));
            System.out.println("Print Right Rotate 180 Degrees:");
            Block.printBlock(Block.getRightRotate180Degrees(block.getNormalBlock()));
            System.out.println("Print left Rotate 90 Degrees:");
            Block.printBlock(Block.getLeftRotate90Degrees(block.getNormalBlock()));

            System.out.println("Print Turn Over Block:");
            Block.printBlock(Block.getTurnOverBlock(block.getNormalBlock()));
            System.out.println("Print Turn Over And Right Rotate 90 Degrees Block:");
            Block.printBlock(Block.getTurnOverAndRightRotate90Degrees(block.getNormalBlock()));
            System.out.println("Print Turn Over And Right Rotate 180 Degrees Block:");
            Block.printBlock(Block.getTurnOverAndRightRotate180Degrees(block.getNormalBlock()));
            System.out.println("Print Turn Over And left Rotate 90 Degrees Block:");
            Block.printBlock(Block.getTurnOverAndLeftRotate90Degrees(block.getNormalBlock()));
        }
    }

    public static void testBlockList () {
        Blocks bs = new Blocks();
        Map<Integer,String[][]> bl = bs.getBlockList();
        String [][] b;
        for (int i : bl.keySet()) {
            //System.out.println("keys:" + i);
            b = bl.get(i);
            System.out.println("block: " + i);
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < b[j].length; k ++) {
                    System.out.print(b[j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void testMap () {
        BlockMap bm = new BlockMap(Level.TWELEVE);
        bm.printMap();
    }


    public static void testLevel () {
        for (Level l : Level.values()) {
            System.out.println("" + l.name() + ": " + l.getValue());
        }
    }
}
