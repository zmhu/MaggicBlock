package net.zmhu.game.blocktoy.blocks;

/**
 * Created by zmhu on 6/1/16.
 */
public class Block {

    public Block(int id, String [][] units) {
        this.blockId = id;
        this.blockunits = units;
        this.resetDirection();
        this.currentDirection = Directions.NORMAL;
        this.currentBlockUnits = this.blockunits;
    }

    private Directions currentDirection;
    private int blockId;
    /**
     * 取得当前块的编号
     * @return 块id号
     */
    public int getBlockId () {
        return this.blockId;
    }

    private String [][] blockunits;
    private String [][] currentBlockUnits;
    /**
     * 取得块的初始点阵
     * @return String [][]
     */
    public String [][] getBlockUnits () {
        return this.blockunits;
    }

    public String [][] getCurrentBlockUnits () {
        return this.currentBlockUnits;
    }

    /**
     * 判断当前块还是否能转向(每个块最多可转8个方向)
     * @return boolean
     */
    public boolean hasNextDirection () {
        if ((this.cursor + 1) >= this.directions.length) {
            return false;
        }

        return true;
    }

    /**
     * 转向前返回块
     * @return Block
     */
    public Block nextDirection () {
        this.cursor ++;
        this.currentDirection = this.directions[this.cursor];
        this.currentBlockUnits = BlockUtil.getBlock(this.currentDirection,this.getBlockUnits());
        return this;
    }

    Directions [] directions;
    public void setDirections (Directions [] ds) {
        this.directions = ds;
    }

    int cursor = -1;
    /**
     * 块归位
     */
    public void resetDirection () {
        this.cursor = -1;
    }

    public void printCurrent () {
        printBlock(this.currentBlockUnits);
    }

    public static void printBlock (String [][] block) {
        for (int i = 0; i < block.length; i ++) {
            for (int j = 0; j < block[i].length; j++) {
                System.out.print(block[i][j]);
            }
            System.out.println();
        }
    }
}
