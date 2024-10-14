package JEngine;

import java.util.Random;
import java.awt.*;

public class JCamera extends Canvas {



    int[] pixels;

    public JCamera(Vector2 size) {
        Random random = new Random();

        JEngine.camera = this;

        Window.window.add(this);
        Window.window.pack();

        for(int i = 0; i < size.x() * size.y(); i++) {
            JEngine.renderer.rendererPixels[i] = random.nextInt();
        }
    }

    public void render() {
        JEngine.renderer.drawPixel(JEngine.renderer, new Vector2(0, 0));
    }

}
