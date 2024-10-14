import JEngine.*;
import JEngine.Window;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;


public class Program extends Application {



    public static void main(String[] args) {
        JEngine.run(new Program(), RendererType.Renderer3D);
    }


    public JCamera camera;




    @Override
    public void start() {

        Window.setBackgroundColor(RGBA.white());

        camera = new JCamera(Window.getWindowDimensions());

    }

    @Override
    public void update() {
        Window.setWindowName("FPS: " + JEngine.getFps());



    }
}
