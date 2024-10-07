package JEngine;

public class RGBA {

    public int r;
    public int g;
    public int b;
    public float a;

    public RGBA() {
        r = 0;
        g = 0;
        b = 0;
        a = 1;
    }

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

    public String toString() {
        return r + ", " + g + ", " + b + ", " + a;
    }

    public static RGBA lerp(RGBA a, RGBA b, float alpha) {
        RGBA newColour = a;

        newColour.r = (int) Mathf.lerp(newColour.r, b.r, alpha);
        newColour.g = (int) Mathf.lerp(newColour.g, b.g, alpha);
        newColour.b = (int) Mathf.lerp(newColour.b, b.b, alpha);
        newColour.a = (int) Mathf.lerp(newColour.a, b.a, alpha);

        return newColour;
    }
    public static RGBA lerp(RGBA a, RGBA b, double alpha) {
        RGBA newColour = a;

        newColour.r = (int) Mathf.lerp(newColour.r, b.r, alpha);
        newColour.g = (int) Mathf.lerp(newColour.g, b.g, alpha);
        newColour.b = (int) Mathf.lerp(newColour.b, b.b, alpha);
        newColour.a = (int) Mathf.lerp(newColour.a, b.a, alpha);

        return newColour;
    }

}
