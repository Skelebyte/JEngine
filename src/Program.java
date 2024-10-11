import JEngine.*;
import JEngine.Assets.Mesh;
import JEngine.Assets.Texture;
import JEngine.Window;


public class Program extends Application {

    public static void main(String[] args) {
        JEngine.run(new Program());
    }

    Camera3D camera;
    Mesh cube;

    @Override
    public void start() {
        Window.makeWindow("hi mum", 1920, 1080, true);
        Window.setBackgroundColor(RGBA.white());

        camera = new Camera3D(60, 70);

        cube = new Mesh("JEngine/Resources/cube.obj", new Texture("JEngine/Resources/NoTexture.png"));
        cube.transform.position = new Vector3(1, 1, 1);

        cube.active = true;

    }

    Keybind right = new Keybind("right", Key.KEY_D);
    Keybind left = new Keybind("left", Key.KEY_A);
    Keybind up = new Keybind("up", Key.KEY_W);
    Keybind down = new Keybind("down", Key.KEY_S);
    Keybind forward = new Keybind("forward", Key.KEY_Q);
    Keybind back = new Keybind("back", Key.KEY_E);

    Keybind activate = new Keybind("activate", Key.KEY_SPACE);

    @Override
    public void update() {
        Window.setWindowName("FPS: " + JEngine.getFps());

        cube.transform.position = Vector3.add(cube.transform.position, Vector3.multiply(Vector3.right(), 2 * Time.deltaTime()));
        Debug.print(cube.transform.position.toString());

    }
}
