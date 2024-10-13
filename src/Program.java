import JEngine.*;
import JEngine.Window;


public class Program extends Application {

    public static void main(String[] args) {
        JEngine.run(new Program());
    }


    @Override
    public void start() {
        Window.makeWindow("hi mum", 1920, 1080, true);
        Window.setBackgroundColor(RGBA.white());


    }


    @Override
    public void update() {
        Window.setWindowName("FPS: " + JEngine.getFps());


    }
}
