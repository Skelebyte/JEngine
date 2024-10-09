package JEngine;

public class Vector3 {
    private final double X;
    private final double Y;
    private final double Z;

    public Vector3() {
        X = 0;
        Y = 0;
        Z = 0;
    }
    public Vector3(double _x, double _y, double _z) {
        X = _x;
        Y = _y;
        Z = _z;
    }

    public double x() {
        return X;
    }
    public double y() {
        return Y;
    }
    public double z() {
        return Z;
    }

    public static Vector3 multiply(Vector3 a, double b) {
        return new Vector3(a.x() * b, a.y() * b, a.z() * b);
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
