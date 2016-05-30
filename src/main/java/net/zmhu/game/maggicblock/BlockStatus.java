package net.zmhu.game.maggicblock;

public enum BlockStatus {
    NORMAL(1), RIGHTROTATE90D(2), RIGHTROTATE180D(3), LEFTROTATE90D(4),TURNOVER(5),
    TURNOVERANDRIGHTROTATE90D(6), TURNOVERRIGHTROTATE180D(7), TURNOVERANDLEFTROTATE90D(8);

    BlockStatus (int i) {
        this.i = i;
    }
    private int i;

    public int getValue () {
        return this.i;
    }
}