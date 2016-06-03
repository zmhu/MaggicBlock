package net.zmhu.game.blocktoy.blocks;

/**
 * Created by zmhu on 6/1/16.
 */
public class BlockUtil {
    public static String [][] getBlock (Directions s, String [][] block) {
        String [][] temp;
        switch (s) {

            case RIGHTROTATE90D:
                temp = getRightRotate90Degrees(block);
                break;
            case RIGHTROTATE180D:
                temp = getRightRotate180Degrees(block);
                break;
            case LEFTROTATE90D:
                temp = getLeftRotate90Degrees(block);
                break;
            case TURNOVER:
                temp = getTurnOverBlock(block);
                break;
            case TURNOVERANDRIGHTROTATE90D:
                temp = getTurnOverAndRightRotate90Degrees(block);
                break;
            case TURNOVERRIGHTROTATE180D:
                temp = getTurnOverAndRightRotate180Degrees(block);
                break;
            case TURNOVERANDLEFTROTATE90D:
                temp = getTurnOverAndLeftRotate90Degrees(block);
                break;
            case NORMAL:
            default:
                temp = block;

        }
        return temp;
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
