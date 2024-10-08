import JEngine.*;
import JEngine.Window;

import java.awt.*;


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

        // Window.window.getContentPane().add(new Renderer2D());
        Window.setBackgroundColor(RGBA.red());

        Debug.print("day: " + day + ". Money: " + currentMoney);
    }



    @Override
    public void update() {
        Window.setWindowName("FPS: " + JEngine.getFps());
        Window.setBackgroundColor(RGBA.red());

        if(Input.isKeyJustPressed("space")) {
            currentMoney *= 1.5;
            currentMoney = Mathf.round(currentMoney, 0);
            day++;
            Debug.print("day: " + day + ". Money: " + currentMoney);
        }

    }
}
