package JEngine;

public class Vector3 {
    private final int X;
    private final int Y;
    private final int Z;

    public Vector3() {
        X = 0;
        Y = 0;
        Z = 0;
    }
    public Vector3(int _x, int _y, int _z) {
        X = _x;
        Y = _y;
        Z = _z;
    }

    public int x() {
        return X;
    }
    public int y() {
        return Y;
    }
    public int z() {
        return Z;
    }

    public String toString() {
        return "(" + X + "," + Y + "," + Z + ")";
    }

    public static Vector3 zero() {
        return new Vector3(0, 0, 0);
    }
    public static Vector3 forward() {
        return new Vector3(0, 0, 1);
    }

}
