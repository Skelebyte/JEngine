package BoneSource;

public class Mathf {
    public static float sqrt(float a) {
        if(a <= 0)  {
            Debug.log(LogType.ERROR, "Can not find square root of " + a + ". Value must be larger than zero.");
            return 0;
        }
        float root = a / 2;
        float temp = 0.0f;

        while(root != temp) {
            temp = root;
            root = (a / temp + temp) / 2;
        }

        return root;
    }

    public static float pow(float a, float b) {
        float value = 1;

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

    public static float floor(float a) {

        String sValue = String.valueOf(a);
        String[] splitValue = sValue.split("\\.");

        return Float.parseFloat(splitValue[0]);
    }

    public static float ceil(float a) {
        String sValue = String.valueOf(a);
        String[] splitValue = sValue.split("\\.");

        if(Float.parseFloat(splitValue[1]) == 0) {
            return Float.parseFloat(splitValue[0]);
        }

        return Float.parseFloat(splitValue[0]) + 1;
    }

    public static float round(float a, int b) {
        return floor(a * pow(10, b) + 0.5f) / pow(10, b);
    }

    public static float lerp(float a, float b, float alpha) {
        return a + (b - a) * alpha;
    }

}
