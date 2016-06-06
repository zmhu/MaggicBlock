package net.zmhu.game.blocktoy;

import net.zmhu.game.blocktoy.blocks.Mblock;

import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by zmhu on 6/6/16.
 */
public class BlockSelector {
    Map<Integer,List<Mblock>> allBlocks;
    public BlockSelector (Map<Integer,List<Mblock>> allBlocks) {
        this.allBlocks = allBlocks;
        this.initBlocks();
    }

    public boolean hasNextGroup () {
        //this.printCursor();
        if (this.cursor[0][0] > (this.cursor[0][1] - 1))
            return false;
        else
            return true;
    }

    public void printCursor () {
        for (int i = 0; i < this.cursor.length; i ++) {
            if (i == 0)
                System.out.println("row = " + i + ", cursor = " + this.cursor[i][0] + ", max = " + this.cursor[i][1]);
        }
    }

    Stack<Mblock> oneGroup = new Stack<Mblock>();
    public Stack<Mblock> nextGroup () {
        int i;
        for (i = 0; i < this.cursor.length; i ++) {
            this.oneGroup.push(this.selectOneBlock(i, this.cursor[i][0]));
        }
        this.changeCursor(this.cursor.length - 1);
        return this.oneGroup;
    }

    private void changeCursor (int i) {
        if (i > 0) {
            this.cursor[i][0] += 1;
            if (this.cursor[i][0] > (this.cursor[i][1] - 1)) {
                this.cursor[i][0] = 0;
                this.changeCursor(i - 1);
            }
        } else if (i == 0) {
            this.cursor[0][0] += 1;
            //if (this.cursor[0][0] >= (this.cursor[0][1] - 1)) {
                //this.cursor[0][0] = this.cursor[0][1] - 1;
            //}
        }
    }

    public Mblock selectOneBlock (int row, int cursor) {
        Mblock mblock = this.blocksArray[row].get(cursor);
        return mblock;
    }

    int [][] cursor;

    List<Mblock> [] blocksArray;
    private void initBlocks () {
        this.blocksArray = new List[this.allBlocks.keySet().size()];
        this.cursor = new int[this.blocksArray.length][2];
        int i =0;
        for (int key : this.allBlocks.keySet()) {
            this.blocksArray[i] = this.allBlocks.get(key);
            this.cursor[i][0] = 0;
            this.cursor[i][1] = this.blocksArray[i].size();
            i++;
        }
    }
}
