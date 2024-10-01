package JEngine;

public class Vector2 {
    int X;
    int Y;

    public Vector2() {
        X = 0;
        Y = 0;
    }
    public Vector2(int _x, int _y) {
        X = _x;
        Y = _y;
    }

    public int x() {
        return X;
    }
    public int y() {
        return Y;
    }

    public String toString() {
        return "(" + X + "," + Y + ")";
    }

}
