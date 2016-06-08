package net.zmhu.game.blocktoy;

import net.zmhu.game.blocktoy.blocks.Mblock;

import java.io.*;

public class SelectorPattern {
    String fileName = "p.ser";
    PattersSerializ _patterns;// = new PattersSerializ();
    public SelectorPattern () {
        this.initPatters();
    }

    public void savePatterns () {
        try{
            FileOutputStream fs = new FileOutputStream(this.fileName);
            ObjectOutputStream os =  new ObjectOutputStream(fs);
            os.writeObject(this._patterns);
            os.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private void initPatters () {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(this.fileName)));
            this._patterns = (PattersSerializ)ois.readObject();
            System.out.println("init cache :" +this._patterns.size());
        } catch (Exception e) {
            //e.printStackTrace();
            this._patterns = new PattersSerializ();
        }
    }

    public boolean isOverlapBlock (Mblock m1, Mblock _m) {
        //return this.isOverlapBlockCal(m1, _m);
        boolean b;
        b = this._patterns.isMutex(m1.hashCode(), _m.hashCode());
        if (!b) {
            b = this.isOverlapBlockCal(m1, _m);
            if (b)
                this._patterns.add(m1.hashCode(), _m.hashCode());
        }
        return b;
    }

    // 判断两块是否有可能覆盖
    public boolean isOverlapBlockCal (Mblock m1, Mblock _m) {
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
