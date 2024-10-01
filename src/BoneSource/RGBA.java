package BoneSource;

public class RGBA {

    public int r;
    public int g;
    public int b;
    public float a;

    public RGBA(int red, int green, int blue) {
        r = red;
        g = green;
        b = blue;
        a = 1;
    }

    public RGBA(int red, int green, int blue, float alpha) {
        r = red;
        g = green;
        b = blue;
        if(alpha > 1f) {
            a = 1f;
        } else if(alpha < 0f) {
            a = 0f;
        } else {
            a = alpha;
        }

    }

    public RGBA red() {
        return new RGBA(255, 0, 0);
    }

    public RGBA green() {
        return new RGBA(0, 255, 0);
    }

    public RGBA blue() {
        return new RGBA(0, 0, 255);
    }

}
