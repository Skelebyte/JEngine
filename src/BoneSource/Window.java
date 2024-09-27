package BoneSource;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Window {
    public static JFrame window;

    // public void Start();
    private static Vector2 windowDimensions;

    public static void makeWindow(String name, int w, int h) {

        window = new JFrame(name);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setPreferredSize(new Dimension(w, h));
        window.setSize(w, h);

        window.setLocationRelativeTo(null);
        window.pack();
        window.setVisible(true);


        Input.Input = new Input();

        window.addKeyListener(Input.Input);

    }

    public static void setIcon(String iconPath) {
        Image iconImage = new ImageIcon(iconPath).getImage();
        Window.window.setIconImage(iconImage);
    }

    public static void setWindowName(String value) {

//        if(Objects.equals(value, "") || Objects.equals(value, " ")) {
//            window.setName("BoneSource Window");
//            return;
//        }

        window.setName(value);
    }

    public static Vector2 getWindowDimensions() {
        return windowDimensions;
    }

    public static void setWindowDimensions(Vector2 windowDimensions) {
        Window.windowDimensions = windowDimensions;
    }
}

