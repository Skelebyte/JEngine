package JEngine;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

public class JRenderer {

    RGBA[] pixels;

    public BufferedImage image;
    public BufferStrategy bufferStrategy;
    public Graphics graphics;

    public JRenderer(Vector2 size) {
        pixels = new RGBA[size.x() * size.y()];
    }

    public void updateRendererData(Vector2 to) {
        pixels = new RGBA[to.x() * to.y()];


        if(image == null || image.getWidth() != to.x() || image.getHeight() != to.y()) {
            image = new BufferedImage(to.x(), to.y(), BufferedImage.TYPE_INT_ARGB);
        }

        JEngine.camera.screenPixels = new RGBA[to.x() * to.y()];
        int[] temp = new int[0];
        for(int i = 0; i < to.x() * to.y(); i++) {
            temp = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
        }
        for (int b : temp) {
            Debug.print(b);
        }
        Debug.print("done");
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
