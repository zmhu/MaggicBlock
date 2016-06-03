package net.zmhu.game.blocktoy.blocks;

/**
 * Created by zmhu on 6/1/16.
 */
public enum Directions {
    NORMAL(1), RIGHTROTATE90D(2), RIGHTROTATE180D(3), LEFTROTATE90D(4),TURNOVER(5),
    TURNOVERANDRIGHTROTATE90D(6), TURNOVERRIGHTROTATE180D(7), TURNOVERANDLEFTROTATE90D(8);

    Directions (int i) {
        this.i = i;
    }
    private int i;

    public int getValue () {
        return this.i;
    }
}