import BoneSource.*;

public class Program extends Application {

    public static void main(String[] args) {
        Main.run(new Program());
    }

    @Override
    public void start() {
        Window.makeWindow("Hi, mum!", 256, 256);

    }

    @Override
    public void update() {
        Debug.print("fps: " + Main.frameRate);

    }
}
