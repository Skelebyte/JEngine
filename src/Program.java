import JEngine.*;

import javax.swing.plaf.basic.BasicSplitPaneUI;

public class Program extends Application {

    public static void main(String[] args) {
        JEngine.run(new Program());
    }

    @Override
    public void start() {
        Window.makeWindow("hi mum", 256, 256, true);
        Window.forceWindowNameChange = true;
        Window.setBackgroundColor(new RGBA(25, 50, 75));
    }

    @Override
    public void update() {
        // Window.setWindowName("FPS: " + JEngine.getFps());
        Debug.print("fps: " + JEngine.getFps());
    }
}
