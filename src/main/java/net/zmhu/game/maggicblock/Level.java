package net.zmhu.game.maggicblock;

public enum Level {
    THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
    TEN(10), ELEVEN(11), TWELEVE(12);

    private int l;
    Level (int l) {
        this.l = l;
    }

    public int getValue () {
        return this.l;
    }
}