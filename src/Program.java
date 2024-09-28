import BoneSource.*;

public class Program extends Application {

    public static void main(String[] args) {
        BoneSource.run(new Program());
    }


    @Override
    public void start() {
        Window.makeWindow("FPS: " + BoneSource.getFrameRate(), 256, 256);
    }

    @Override
    public void update() {
        Window.window.setTitle("FPS: " + BoneSource.getFrameRate());


    }
}
