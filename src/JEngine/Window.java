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



        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setPreferredSize(new Dimension(w, h));
        window.setSize(w, h);

        window.setLocationRelativeTo(null);

        window.setResizable(resizable);



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

    public static void setWindowDimensions(Vector2 dimensions) {
        windowDimensions = dimensions;
        window.setSize(windowDimensions.x(), windowDimensions.y());
    }

    public static void setBackgroundColor(Color color) {
        window.getContentPane().setBackground(color);
    }
    public static void setBackgroundColor(RGBA color) {

        Color newColor = new Color(color.r, color.g, color.b);

        window.getContentPane().setBackground(newColor);
    }

    public static void setMinimumWindowDimensions() {
        if(window.getHeight() < minimumWindowDimensions.Y) {
            setWindowDimensions(new Vector2(windowDimensions.x(), minimumWindowDimensions.y()));
        }

        if(window.getWidth() < minimumWindowDimensions.X) {
            setWindowDimensions(new Vector2(minimumWindowDimensions.x(), windowDimensions.y()));
        }
    }

}

