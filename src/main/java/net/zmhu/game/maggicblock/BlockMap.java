package net.zmhu.game.maggicblock;

/**
 * Created by zmhu on 5/28/16.
 */
public class BlockMap {
    public static final int num = 5;
    Level level;
    private String [][] map;
    public BlockMap (Level l) {
        this.level = l;
        this.map = new String[num][this.level.getValue()];
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[i].length; j ++) {
                this.map[i][j] = "0";
            }
        }
    }

    public void printMap () {
        for (int i = 0; i < this.map.length; i ++) {
            for (int j = 0; j < this.map[i].length; j++) {
                System.out.print(this.map[i][j]);
            }
            System.out.println();
        }
    }
}
