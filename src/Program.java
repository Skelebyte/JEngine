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

        cube.active = false;

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

        if(Input.isKeyJustPressed("activate")) {
            cube.active = !cube.active;
            Debug.print(String.valueOf(cube.active));
        }

        if(right.pressed) {
            cube.transform.position = Vector3.add(cube.transform.position, Vector3.right());
            Debug.print(cube.transform.position.toString());
        }
        if(up.pressed) {
            cube.transform.position = Vector3.add(cube.transform.position, Vector3.up());
            Debug.print(cube.transform.position.toString());
        }
        if(left.pressed) {
            cube.transform.position = Vector3.add(cube.transform.position, Vector3.left());
            Debug.print(cube.transform.position.toString());
        }
        if(down.pressed) {
            cube.transform.position = Vector3.add(cube.transform.position, Vector3.down());
            Debug.print(cube.transform.position.toString());
        }

        if(forward.pressed) {
            cube.transform.position = Vector3.add(cube.transform.position, Vector3.forward());
            Debug.print(cube.transform.position.toString());
        }
        if(back.pressed) {
            cube.transform.position = Vector3.add(cube.transform.position, Vector3.back());
            Debug.print(cube.transform.position.toString());
        }

    }
}
