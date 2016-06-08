package net.zmhu.game.blocktoy;

import java.io.Serializable;
import java.util.*;

public class PattersSerializ implements Serializable {
    Set _setTree = new HashSet();
    public void add (int v1, int v2) {
        //_setTree.add(getArrayHashCode(v1,v2));
        _setTree.add(getUniqCode(v1,v2));
    }
    public static long getUniqCode (int v1, int v2) {
        int a[];
        long l;
        if (v1 > v2) {
            a = new int[] {v2,v1};
        } else {
            a = new int[] {v1,v2};
        }
        l = a[0];
        l = l << 32;
        l += a[1];
        return l;
    }
    public boolean isMutex (int v1, int v2) {
        return _setTree.contains(getUniqCode(v1,v2));
    }

    public int size () {
        return this._setTree.size();
    }

}
