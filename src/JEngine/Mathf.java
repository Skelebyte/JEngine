package JEngine;

public class Mathf {
    public static double sqrt(double a) {
        if(a <= 0)  {
            Debug.log(LogType.ERROR, "Can not find square root of " + a + ". Value must be larger than zero.");
            return 0;
        }
        double root = a / 2;
        double temp = 0.0f;

        while(root != temp) {
            temp = root;
            root = (a / temp + temp) / 2;
        }

        return root;
    }

    public static double pow(double a, double b) {
        double value = 1;

        if(b == 0) {
            return value;
        }
        if(b < 0) {
            return 1 / pow(a, b - (b * 2));
        }

        for(int i = 0; i < b; i++) {
            value = value * a;
        }

        return value;
    }

    public static double floor(double a) {

        String sValue = String.valueOf(a);
        String[] splitValue = sValue.split("\\.");

        return Double.parseDouble(splitValue[0]);
    }

    public static double ceil(float a) {
        String sValue = String.valueOf(a);
        String[] splitValue = sValue.split("\\.");

        if(Double.parseDouble(splitValue[1]) == 0) {
            return Double.parseDouble(splitValue[0]);
        }

        return Double.parseDouble(splitValue[0]) + 1;
    }

    // this function breaks when given huge numbers, like 7972437.0 to round.
    // TODO: find out why it breaks when rounding numbers like ^
    public static double round(double a, int b) {
        return floor(a * pow(10, b) + 0.5) / pow(10, b);
    }

    public static double lerp(double a, double b, double alpha) {
        return a + (b - a) * alpha;
    }
    public static double lerp(double a, double b, float alpha) {
        return a + (b - a) * alpha;
    }

}
