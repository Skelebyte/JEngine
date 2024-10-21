import JEngine.*;
import JEngine.Assets.Texture;
import JEngine.Objects.Sprite2D;
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

    public Sprite2D testingSprite = new Sprite2D();


    @Override
    public void start() {
        camera = new JCamera();

        testingSprite.texture = new Texture("JEngine/Resources/NoTexture.png");

        JEngine.renderer.pixelSize = new Vector2(5, 5);

    }

    @Override
    public void tick() {
        Window.setWindowName(JEngine.getFpsAndDelta());

    }
}
