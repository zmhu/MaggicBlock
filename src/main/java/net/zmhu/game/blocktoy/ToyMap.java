package net.zmhu.game.blocktoy;


import net.zmhu.game.blocktoy.blocks.Block;
import net.zmhu.game.blocktoy.blocks.Directions;

/**
 * Created by zmhu on 6/1/16.
 */
public class ToyMap {
    public static int rows = 5;
    Level level;
    String [][] _emtyMap;
    public ToyMap (Level level) {
        this.level = level;
        this.initMap();
        this._emtyMap = this.map.clone();
    }

    public boolean canPut (Block block, int [] coordinate) {
        String [][] blockUnits = block.getCurrentBlockUnits();
        return this.canPut(blockUnits,coordinate);
    }

    public boolean canPut(String [][] blockUnits, int [] coordinate) {
        return this.isInMap(blockUnits, coordinate);
    }

    public boolean isInMap (String [][] blockUnits, int [] coordinate ) {
        int x,y;
        for (int i = 0; i < blockUnits.length; i ++) {
            for (int j = 0; j < blockUnits[i].length; j ++) {
                x = coordinate[0] + i;
                y = coordinate[1] + j;
                if (x >= 0 && y >= 0 && x < rows && y < this.level.getValue()) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasPutSide (int blockId, Directions direc, int [] coordinate) {
        if (blockId == 10) {
            if (direc == Directions.NORMAL) {
                if (coordinate[0] == 0) {
                    return false;
                }
            } else if (direc == Directions.RIGHTROTATE90D) {
                if (coordinate[1] + 2 == this.map[coordinate[0]].length) {
                    return false;
                }
            } else if (direc == Directions.RIGHTROTATE180D) {
                if (coordinate[0] + 2 == this.map.length) {
                    return false;
                }
            } else if (direc == Directions.LEFTROTATE90D) {
                if (coordinate[1] == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean hasPutAngle (String [][] blockUnits, int [] coordinate) {
        this.clearMap(this._emtyMap);
        String [][] _map = this._emtyMap;
        int x,y;
        int maxY = _map[0].length - 1;
        int maxX = _map.length -1;
        for (int i = 0; i< blockUnits.length; i ++) {
            for (int j = 0; j < blockUnits[i].length; j++) {
                x = coordinate[0] + i;
                y = coordinate[1] + j;
                _map[x][y] = blockUnits[i][j];
            }
        }
        if (_map[0][0].equals("0") && !_map[1][0].equals("0") && !_map[0][1].equals("0")) {
            //printMapUnit(_map);
            return false;
        } else if (_map[0][maxY].equals("0") && !_map[0][maxY - 1].equals("0") && !_map[1][maxY].equals("0")) {
            //printMapUnit(_map);
            return false;
        } else if (_map[maxX][0].equals("0") && !_map[maxX][1].equals("0") && !_map[maxX - 1][0].equals("0")) {
            //printMapUnit(_map);
            return false;
        } else if (_map[maxX][maxY].equals("0") && !_map[maxX][maxY-1].equals("0") && !_map[maxX - 1][maxY].equals("0")) {
            //printMapUnit(_map);
            return false;
        }
        return true;
    }

    public boolean isFull () {
        boolean isFull = true;
        for (int i = 0; i < this.map.length; i ++) {
            for (int j = 0; j < this.map[i].length; j ++) {
                if (this.map[i][j].equals("0")) {
                    isFull = false;
                }
            }
        }
        return isFull;
    }

    public void putIntoMap (Block block, int [] coordinate) {
        String [][] blockUnits = block.getCurrentBlockUnits();
        this.putIntoMap(blockUnits, coordinate);
    }

    public boolean putIntoMap (String [][] blockUnits, int [] coordinate) {
        int x,y;
        for (int i = 0; i < blockUnits.length; i ++) {
            for (int j = 0; j < blockUnits[i].length; j ++) {
                x = coordinate[0] + i;
                y = coordinate[1] + j;
                if (!blockUnits[i][j].equals("0") && !this.map[x][y].equals("0")) {
                    return false;
                }
                if (!blockUnits[i][j].equals("0")) {
                    this.map[x][y] = blockUnits[i][j];
                }
            }
        }
        return true;
    }

    public void removeBlock (Block block, int [] coordinate) {
        String [][] blockUnits = block.getCurrentBlockUnits();
        this.removeBlock(blockUnits, coordinate);
    }

    public void removeBlock (String [][] blockUnits, int [] coordinate) {
        int x,y;
        for (int i = 0; i < blockUnits.length; i ++) {
            for (int j = 0; j < blockUnits[i].length; j ++) {
                x = coordinate[0] + i;
                y = coordinate[1] + j;
                this.map[x][y] = "0";
            }
        }
    }

    public void clearMap () {
        this.clearMap(this.map);
    }

    public void clearMap (String [][] _map) {
        for (int i = 0; i < _map.length; i ++) {
            for (int j = 0; j < _map[i].length; j ++) {
                _map[i][j] = "0";
            }
        }
    }


    String [][] map;
    public void initMap () {
        this.map = new String[rows][this.level.getValue()];
        this.clearMap();
    }

    public static void printMapUnit (String [][] mapUnits) {
        System.out.println("Print Map Units:");
        for (int i = 0; i < mapUnits.length; i ++) {
            for (int j = 0; j < mapUnits[i].length; j ++) {
                System.out.print(mapUnits[i][j]);
            }
            System.out.println();
        }
    }

    public void printMap () {
        for (int i = 0; i < this.map.length; i ++) {
            for (int j = 0; j < this.map[i].length; j ++) {
                //this.map[i][j] = "0";
                System.out.print(this.map[i][j]);
            }
            System.out.println();
        }
    }
}
