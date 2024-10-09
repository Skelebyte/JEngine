import JEngine.*;
import JEngine.Assets.Mesh;
import JEngine.Assets.Texture;
import JEngine.Window;


public class Program extends Application {

    public static void main(String[] args) {
        JEngine.run(new Program());
    }

    Keybind space = new Keybind("space", Key.KEY_SPACE);

    double currentMoney = 1;
    int day = 1;

    @Override
    public void start() {
        Window.makeWindow("hi mum", 256, 256, true);

        // Window.window.getContentPane().add(new Renderer3D());
        Window.setBackgroundColor(RGBA.red());

        Debug.print("day: " + day + ". Money: " + currentMoney);
    }

    Mesh monkey = new Mesh("./models/monkey.obj", Texture.blank(), new Transform3D());

    @Override
    public void update() {
        Window.setWindowName("FPS: " + JEngine.getFps());

        

    }
}
