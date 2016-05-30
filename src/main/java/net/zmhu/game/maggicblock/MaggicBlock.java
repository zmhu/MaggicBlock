package net.zmhu.game.maggicblock;

/**
 * Created by zmhu on 5/28/16.
 */

public class MaggicBlock {
    public static void main (String [] args) {

        //testLevel();
        testMap();
    }

    public static void testMap () {
        BlockMap bm = new BlockMap(Level.TWELEVE);
        bm.printMap();
    }


    public static void testLevel () {
        //AnsiConsole.systemInstall();
        //System.out.println(Level.TEN.getValue());
        //Ansi a = ansi().eraseScreen().fg(RED);
        //String str = "";
        for (Level l : Level.values()) {
            System.out.println("" + l.name() + ": " + l.getValue());
            //System.out.print(l.name());
            //System.out.println(a.a(l.name() + ": " + l.getValue()).reset());
            //str += (l.name() + ": " + l.getValue());
        }
        //System.out.println(a.a(str));
    }
}
