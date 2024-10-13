package JEngine;


public class Mathf {

    public static double clamp(double value, double min, double max) {

        double temp = value;

        if(temp > max) {
            temp = max;
        }
        if(temp < min) {
            temp = min;
        }

        return temp;
    }

    public static double lerp(double a, double b, double alpha) {
        return a + (b - a) * alpha;
    }

}
