package net.zmhu.game.blocktoy;

import net.zmhu.game.blocktoy.blocks.Mblock;

import java.util.List;

/**
 * Created by zmhu on 6/7/16.
 */
public class SelectorPattern {

    List<Mblock> mblockList;
    Mblock currentMblock;
    public SelectorPattern (List<Mblock> mblockList, Mblock _mblock) {
        this.currentMblock = _mblock;
        this.mblockList = mblockList;
    }

    public boolean maybeNotFit () {
        Mblock _mblock;

        /*
        for (int i = 0; i < this.mblockList.size(); i ++) {
            _mblock = this.mblockList.get(i);

            //起始点位置一样,并且都有内容
            if (this.mblockCoordinateEquals(_mblock, this.currentMblock))  return true;

            //方块之间是否有覆盖
            //if (this.isOverlapBlock(_mblock, this.currentMblock)) return true;

        }*/
        //if (this.mblockList.size() > 1) {
            //if (this.isOverlapBlock(this.mblockList.get(this.mblockList.size() - 1), this.currentMblock)) return true;
        //}
        //if (this.mblockCoordinateEquals(this.mblockList.get(this.mblockList.size() - 1), this.currentMblock))  return true;
        if (this.isOverlapBlock(this.mblockList.get(this.mblockList.size() - 1), this.currentMblock)) return true;
        return false;
    }


    private boolean isOverlapBlock (Mblock m1, Mblock _m) {
        String [][] m1Units = m1.getBlockUnits();
        int [] c1 = m1.getCoordinate();
        int [] mapC = new int[2];
        for (int i = 0; i < m1Units.length; i ++) {
            for (int j = 0; j < m1Units[i].length; j++) {
                if (!m1Units[i][j].equals("0")) {
                    mapC[0] = c1[0] + i;
                    mapC[1] = c1[1] + j;
                    if (this.duplicateCoordinate(mapC,_m)) {
                    //if (this.duplicateCoordinateStart(mapC, _m)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean duplicateCoordinate (int [] mapC, Mblock _m) {
        int [] c = _m.getCoordinate();
        int x,y;
        String [][] units = _m.getBlockUnits();
        x = mapC[0] - c[0];
        y = mapC[1] - c[1];
        if (x >= 0 && y >= 0 && x < units.length && y < units[0].length) {
            if (!units[x][y].equals("0")) return true;
        }
        return false;
    }

    private boolean duplicateCoordinateStart (int [] mapC, Mblock _m) {
        int[] c = _m.getCoordinate();
        String[][] units = _m.getBlockUnits();
        if (!units[0][0].equals("0")) {
            if (c[0] == mapC[0] && c[1] == mapC[1]) {
                return true;
            }
        }
        return false;
    }


    private boolean mblockCoordinateEquals (Mblock m1, Mblock _m) {
        int [] c1 = m1.getCoordinate();
        int [] _c = _m.getCoordinate();
        String [][] m1Units = m1.getBlockUnits();
        String [][] _mUnits = _m.getBlockUnits();
        if (c1[0] == _c[0] && c1[1] == _c[1]) {
            if (!m1Units[0][0].equals("0") && !_mUnits[0][0].equals("0")) {
                return true;
            }
        }
        return false;
    }
}
