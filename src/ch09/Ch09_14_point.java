package ch09;

import java.io.Serializable;

public class Ch09_14_point implements Serializable {
    private static final long serialVersionUID = 1L;
    int x;
    int y;
    Ch09_14_point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return "[" + x + ";" + y + "]";
    }
//private static final long serialVersionUID = 2L;
//    int[] coord;
//    Ch09_14_point(int x, int y) {
//        coord[0] = x;
//        coord[1] = y;
//    }
//    public String toString() {
//        return "[" + coord[0] + ";" + coord[1] + "]";
//    }
}
