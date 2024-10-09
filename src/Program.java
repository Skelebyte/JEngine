import JEngine.*;
import JEngine.Assets.Mesh;
import JEngine.Assets.Texture;
import JEngine.Window;


public class Program extends Application {

    public static void main(String[] args) {
        JEngine.run(new Program());
    }

    Camera3D camera;
    Mesh monkey;

    @Override
    public void start() {
        Window.makeWindow("hi mum", 256, 256, true);
        Window.setBackgroundColor(RGBA.white());

        camera = new Camera3D(60, 0.01);
        monkey = new Mesh("models/monkey.obj", Texture.blank(), new Transform3D());

    }
    // BUG: Component must have a valid peer
    //      ^ this is caused by the constructor with createBufferStrategy being called BEFORE the window is even spawned.
    //        need to delay the constructor in some way.



    @Override
    public void update() {
        Window.setWindowName("FPS: " + JEngine.getFps());

    }
}
