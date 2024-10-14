package JEngine;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Window {

    public static JFrame window;

    // public void Start();
    private static Vector2 windowDimensions;

    public static Vector2 minimumWindowDimensions = new Vector2();

    public static void makeWindow(String name, int w, int h, boolean resizable) {
        windowDimensions = new Vector2();
        window = new JFrame(name);

        windowDimensions = new Vector2(w, h);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setMinimumSize(new Dimension(w, h));
        window.setSize(w, h);

        window.setLocationRelativeTo(null);

        window.setResizable(resizable);

        Input.Input = new Input();

        window.addKeyListener(Input.Input);

        window.pack();
        window.setVisible(true);




    }

    public static void setIcon(String iconPath) {
        Image iconImage = new ImageIcon(iconPath).getImage();
        Window.window.setIconImage(iconImage);
    }


    public static void setWindowName(String value) {
        try {
            if(Objects.equals(window.getTitle(), value)) {
                return;
            }

            if(Objects.equals(value, "") || Objects.equals(value, " ")) {
                window.setTitle("JEngine Window");
                return;
            }

            window.setTitle(value);
        } catch (Exception e) {
            Debug.print(e.getMessage() + " : " + e.getCause());
        }
    }

    public static Vector2 getWindowDimensions() {
        return windowDimensions;
    }



    public static void setBackgroundColor(Color color) {
        window.getContentPane().setBackground(color);
    }
    public static void setBackgroundColor(RGBA color) {

        Color newColor = new Color(color.r, color.g, color.b);

        window.getContentPane().setBackground(newColor);
    }

}

