package JEngine;

import java.awt.*;

public class JCamera extends Canvas {

    public float fov;

    public RGBA[] screenPixels;

    public JCamera(float fieldOfView) {
        fov = fieldOfView;

        JEngine.camera = this;

        Window.window.add(this);
        Window.window.pack();

    }



}
