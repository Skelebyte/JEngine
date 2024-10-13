package JEngine;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Arrays;
import java.util.Vector;

public class JRenderer {

    RGBA[] pixels;

    public BufferStrategy bufferStrategy;
    public Graphics graphics;

    public JRenderer(Vector2 size) {
        pixels = new RGBA[size.x() * size.y()];
    }

    public void updatePixelsArray(Vector2 to) {
        pixels = new RGBA[to.x() * to.y()];
    }

    public void clear(RGBA color) {
        Arrays.fill(pixels, color);
    }

    public void drawPixel(Vector2 pixelPosition, RGBA color) {
        int index = (pixelPosition.x() + pixelPosition.y() * Window.getWindowSize().x());

        pixels[index] = color;

    }

    void copyArray(RGBA[] destination) {
        for(int i = 0; i < Window.getWindowSize().x() * Window.getWindowSize().y(); i++) {
            destination[i] = pixels[i];
        }
    }

}
