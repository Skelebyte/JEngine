import JEngine.*;
import JEngine.Window;

import java.awt.*;


public class Program extends Application {

    public static void main(String[] args) {
        JEngine.run(new Program());
    }

    @Override
    public void start() {
        Window.makeWindow("hi mum", 256, 256, true);
        Window.forceWindowNameChange = true;
    }

    @Override
    public void update() {
        Window.setWindowName("FPS: " + JEngine.getFps());



    }
}
