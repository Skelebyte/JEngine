package BoneSource;

import javax.swing.*;
import java.awt.*;

public class Window {
    public static JFrame window;

    // public void Start();
    private static Vector2 windowDimensions;

    public static void makeWindow(String name, int w, int h) {
        Window.window = new JFrame(name);

        Window.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Window.window.setPreferredSize(new Dimension(w, h));
        Window.window.setSize(w, h);

        Window.window.setLocationRelativeTo(null);
        Window.window.pack();
        Window.window.setVisible(true);


        Input.Input = new Input();

        Window.window.addKeyListener(Input.Input);
    }

    public static void setIcon(String iconPath) {
        Image iconImage = new ImageIcon(iconPath).getImage();
        Window.window.setIconImage(iconImage);
    }

    public static Vector2 getWindowDimensions() {
        return windowDimensions;
    }

    public static void setWindowDimensions(Vector2 windowDimensions) {
        Window.windowDimensions = windowDimensions;
    }
}

