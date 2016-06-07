package net.zmhu.game.blocktoy;

import net.zmhu.game.blocktoy.blocks.Mblock;

import java.util.ArrayList;
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

    public synchronized Stack<Mblock> nextGroupWithThread () {
        if (this.hasNextGroup())
            return nextGroup();
        else
            return null;
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
    List<Mblock> aGroup = new ArrayList<Mblock>();
    public List<Mblock> nextGroupWithPattern () {
        if (this.cursor[0][0] >= this.cursor[0][1])
            return null;
        this.selectBlockWithPattern(0);
        this.moveCursor(this.cursor.length - 1);
        if (this.aGroup.size() > 2) {
            return this.aGroup;
        } else {
            return null;
        }
    }

    SelectorPattern selectorPattern = new SelectorPattern();
    protected void selectBlockWithPattern (int row) {
        Mblock _mblock;
        if (this.cursor[0][0] >= this.cursor[0][1])
            return;
        if (row < this.cursor.length ) {
            _mblock = this.selectOneBlock(row, this.cursor[row][0]);
            if (row > 0 && row < (this.cursor.length - 1) && this.isOverlapBlock(this.aGroup,_mblock)) {
                this.moveCursor(row);
                this.resetLowerCursor(row);
                this.aGroup.clear();
                this.selectBlockWithPattern(0);
            } else {
                this.aGroup.add(_mblock);
                this.selectBlockWithPattern(row + 1);
            }
        }
    }

    protected boolean isOverlapBlock (List<Mblock> _aGroup ,Mblock mblock) {
        if (this.selectorPattern.isOverlapBlock(_aGroup.get(_aGroup.size() - 1), mblock)) {
            return true;
        }
        if (_aGroup.size() >= 2) {
            if (this.selectorPattern.isOverlapBlock(_aGroup.get(_aGroup.size() - 2), mblock)) {
                return true;
            }
        }
        return false;
    }

    Stack<Mblock> oneGroup = new Stack<Mblock>();
    public Stack<Mblock> nextGroup () {
        int i;
        for (i = 0; i < this.cursor.length; i ++) {
            this.oneGroup.push(this.selectOneBlock(i, this.cursor[i][0]));
        }
        this.moveCursor(this.cursor.length - 1);
        return this.oneGroup;
    }

    private void resetLowerCursor (int i) {
        int j = i + 1;
        for (; j < this.cursor.length; j ++) {
            this.cursor[j][0] = 0;
        }
    }

    private void moveCursor (int i) {
        this.cursor[i][0] += 1;
        if (i > 0) {
            if (this.cursor[i][0] >= this.cursor[i][1]) {
                this.cursor[i][0] = 0;
                this.moveCursor(i - 1);
            }
        } else if (i == 0) {
            if (this.cursor[0][0] >= this.cursor[0][1]) {
                this.cursor[0][0] = this.cursor[0][1];
            }
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
