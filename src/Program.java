import JEngine.*;
import JEngine.Cameras.Camera3D;
import JEngine.Window;


public class Program extends Application {

    public static void main(String[] args) {
        JEngine.run(new Program(), RendererType.Renderer3D);
    }

    Camera3D camera;


    @Override
    public void start() {
        camera = new Camera3D(60.0f);
        // Window.setBackgroundColor(RGBA.red());
        JEngine.getRenderer().clear(RGBA.blue());
    }


    @Override
    public void update() {
        Window.setWindowName("FPS: " + JEngine.getFps());

        JEngine.getRenderer().drawSquare(new Vector2(100, 100), 100, 100, RGBA.red());

    }
}
