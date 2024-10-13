package JEngine;

import java.awt.*;

public class RGBA {

    public double r;
    public double g;
    public double b;
    public double a;

    public RGBA() {
        r = 0.0;
        g = 0.0;
        b = 0.0;
        a = 1.0;
    }

    public RGBA(double red, double green, double blue) {
        r = Mathf.clamp(red, 0.0, 1.0);
        g = Mathf.clamp(green, 0.0, 1.0);
        b = Mathf.clamp(blue, 0.0, 1.0);
        a = 1.0;
    }

    public RGBA(double red, double green, double blue, double alpha) {
        r = Mathf.clamp(red, 0.0, 1.0);
        g = Mathf.clamp(green, 0.0, 1.0);
        b = Mathf.clamp(blue, 0.0, 1.0);
        a = Mathf.clamp(alpha, 0.0, 1.0);

    }

    public static RGBA red() {
        return new RGBA(255, 0, 0);
    }

    public static RGBA green() {
        return new RGBA(0, 255, 0);
    }

    public static RGBA blue() {
        return new RGBA(0, 0, 255);
    }
    public static RGBA black() {
        return new RGBA(0, 0, 0);
    }
    public static RGBA white() {
        return new RGBA(255, 255, 255);
    }

    public String toString() {
        return r + ", " + g + ", " + b + ", " + a;
    }

    public Color toColor() {
        return new Color((float) r, (float) g, (float) b, (float) a);
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
