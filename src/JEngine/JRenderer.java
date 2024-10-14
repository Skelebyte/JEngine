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

        graphics = JEngine.camera.getGraphics();


        JEngine.camera.paint(graphics);


        bufferStrategy.show();

//
//        JEngine.camera.screenPixels = new RGBA[to.x() * to.y()];
//        int[] temp = new int[0];
//        for(int i = 0; i < to.x() * to.y(); i++) {
//            temp = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
//        }
    }

    public void clear(RGBA color) {
        Arrays.fill(pixels, color);

//        for(int i = 0; i < pixels.length; i++) {
//            image.setRGB();
//        }

    }

    public void drawPixel(Vector2 pixelPosition, RGBA color) {
        int index = (pixelPosition.x() + pixelPosition.y() * Window.getWindowSize().x());

        image.setRGB(pixelPosition.x(), pixelPosition.y(), color.toColor().getRGB());

        pixels[index] = color;

    }

    public void drawSquare(Vector2 position, int width, int height, RGBA color) {
        for(int x = 0; x < width; x++) {
            drawPixel(new Vector2(position.x() + x, position.y()), color);
        }
        for(int y = 0; y < width; y++) {
            drawPixel(new Vector2(position.x(), position.y() - y), color);
        }
    }

    void copyArray(RGBA[] destination) {
        for(int i = 0; i < Window.getWindowSize().x() * Window.getWindowSize().y(); i++) {
            destination[i] = pixels[i];
        }
    }

}
