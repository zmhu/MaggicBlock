package net.zmhu.game.maggicblock;

/**
 * Created by zmhu on 5/30/16.
 */
public class Block {
    String [][] block;
    String [][] currentBlock;
    BlockStatus blockSatus;

    public Block (String [][] block) {
        this.block = block;
    }

    public String [][] getNormalBlock () {
        return this.block;
    }

    public String [][] getBlock (BlockStatus s) {
        this.blockSatus = s;
        switch (this.blockSatus) {

            case RIGHTROTATE90D:
                this.currentBlock = getRightRotate90Degrees(this.getNormalBlock());
                break;
            case RIGHTROTATE180D:
                this.currentBlock = getRightRotate180Degrees(this.getNormalBlock());
                break;
            case LEFTROTATE90D:
                this.currentBlock = getLeftRotate90Degrees(this.getNormalBlock());
                break;
            case TURNOVER:
                this.currentBlock = getTurnOverBlock(this.getNormalBlock());
                break;
            case TURNOVERANDRIGHTROTATE90D:
                this.currentBlock = getTurnOverAndRightRotate90Degrees(this.getNormalBlock());
                break;
            case TURNOVERRIGHTROTATE180D:
                this.currentBlock = getTurnOverAndRightRotate180Degrees(this.getNormalBlock());
                break;
            case TURNOVERANDLEFTROTATE90D:
                this.currentBlock = getTurnOverAndLeftRotate90Degrees(this.getNormalBlock());
                break;
            case NORMAL:
            default:
                this.currentBlock = this.getNormalBlock();

        }
        return this.currentBlock;
    }




    public static String [][] getTurnOverBlock (String [][] b) {
        String [][] temp = new String[b.length][b[0].length];
        for (int i = 0; i < b.length; i ++) {
            for (int j = 0; j < b[i].length; j ++) {
                temp[b.length - i - 1][j] = b[i][j];
            }
        }
        return temp;
    }
    public static String [][] getTurnOverAndRightRotate90Degrees (String [][] b) {
        return getRightRotate90Degrees(getTurnOverBlock(b));
    }

    public static String [][] getTurnOverAndRightRotate180Degrees(String [][] b) {
        return getRightRotate180Degrees(getTurnOverBlock(b));
    }

    public static String [][] getTurnOverAndLeftRotate90Degrees (String [][] b) {
        return getLeftRotate90Degrees(getTurnOverBlock(b));
    }

    public static String [][] getRightRotate90Degrees (String [][] b) {
        String [][] temp = new String[b[0].length][b.length];
        for (int i = 0; i < b.length; i ++) {
            for (int j=0; j < b[i].length; j++) {
                temp[j][b.length - i - 1] = b[i][j];
            }
        }
        return temp;
    }

    public static String [][] getRightRotate180Degrees (String [][] b) {
        String [][] temp = new String[b.length][b[0].length];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j<b[i].length;j++) {
                temp[b.length - i - 1][b[0].length - j - 1] = b[i][j];
            }
        }
        return temp;
    }

    public static String [][] getLeftRotate90Degrees (String [][] b) {
        String [][] temp = new String[b[0].length][b.length];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j<b[i].length;j++) {
                temp[b[i].length - j - 1][i] = b[i][j];
            }
        }
        return temp;
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
