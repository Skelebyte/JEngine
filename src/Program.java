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
        monkey = new Mesh("/JEngine/Resources/cube.obj", Texture.blank(), new Transform3D());

        monkey.transform.position = Vector3.multiply(Vector3.forward(), 10);
        monkey.transform.scale = Vector3.multiply(monkey.transform.scale, 10);

    }



    @Override
    public void update() {
        Window.setWindowName("FPS: " + JEngine.getFps());

    }
}
