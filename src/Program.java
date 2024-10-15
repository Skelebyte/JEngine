import JEngine.*;
import JEngine.Window;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;


public class Program extends Application {
    public static void main(String[] args) {
        JEngine.run(new Program(), RendererType.Renderer2D);
    }


    public JCamera camera;




    @Override
    public void start() {
        camera = new JCamera();

    }

    @Override
    public void update() {
        Window.setWindowName("FPS: " + JEngine.getFps());

    }
}
