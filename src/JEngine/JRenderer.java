package JEngine;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class JRenderer {
    public Vector2 size;
    public int[] rendererPixels;

    BufferStrategy strategy;
    BufferedImage image;

    public Vector2 pixelSize = new Vector2(1, 1);

    public JRenderer(Vector2 _size) {
        JEngine.renderer = this;

        size = _size;
        rendererPixels = new int[_size.x() * _size.y()];

    }

    public void updateRenderData() {

        if(image == null || image.getWidth() != Window.getWindowDimensions().x() || image.getHeight() != Window.getWindowDimensions().y()) {
            image = new BufferedImage(JEngine.renderer.size.x(), JEngine.renderer.size.y(), BufferedImage.TYPE_INT_RGB);
        }
        JEngine.camera.pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();


        if(strategy == null) {
            JEngine.camera.createBufferStrategy(3);
            strategy = JEngine.camera.getBufferStrategy();
        }

        for(int i = 0; i < JEngine.renderer.size.x() * JEngine.renderer.size.y(); i++) {
            JEngine.camera.pixels[i] = JEngine.renderer.rendererPixels[i];
        }


    }


    public void drawPixel(JRenderer renderer, Vector2 position) {
        for(int y = 0; y < size.y(); y++) {
            int yPixel = y + position.y();

            for(int x = 0; x < size.x(); x++) {
                int xPixel = x + position.x();

                rendererPixels[xPixel + yPixel * size.x()] = renderer.rendererPixels[x + y * size.x()];
            }

        }
    }

    public void draw() {
        Graphics graphics = strategy.getDrawGraphics();

        graphics.drawImage(image, 0, 0, JEngine.renderer.size.x() * pixelSize.x(), JEngine.renderer.size.y() * pixelSize.y(), null);

        graphics.dispose();
        strategy.show();
    }

}
