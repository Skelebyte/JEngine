package JEngine;

import javax.swing.*;

public class JCamera extends JPanel {

    public float fov;

    public RGBA[] screenPixels;

    public JCamera(float fieldOfView) {
        fov = fieldOfView;

        JEngine.camera = this;

        setVisible(true);

        Window.window.add(this);
        Window.window.pack();

    }



}
