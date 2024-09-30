package BoneSource;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Window {

    public static boolean forceWindowNameChange;

    public static JFrame window;

    // public void Start();
    private static Vector2 windowDimensions;

    public static void makeWindow(String name, int w, int h) {
        windowDimensions = new Vector2();
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

    static boolean nameWarningTriggered; // TODO: fix the crashing issue, this is a temp fix.

    public static void setWindowName(String value) {

        if(!forceWindowNameChange) {
            if(!nameWarningTriggered) {
                Debug.log(LogType.ERROR, "This function will crash the program and/or your computer, if you are using linux. If you wish to continue, please set `forceWindowNameChange` to true.");
                nameWarningTriggered = true;
            }
            return;
        }

        if(window.getTitle() == value) {
            return;
        }

        if(Objects.equals(value, "") || Objects.equals(value, " ")) {
            window.setTitle("BoneSource Window");
            return;
        }

        window.setTitle(value);
    }

    public static Vector2 getWindowDimensions() {
        return windowDimensions;
    }

    public static void setWindowDimensions(Vector2 windowDimensions) {
        Window.windowDimensions = windowDimensions;
    }
}

