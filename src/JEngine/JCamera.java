package JEngine;

import java.awt.*;

public class JCamera extends Canvas {

    public float fov;



    public JCamera(float fieldOfView) {
        fov = fieldOfView;

        Window.window.add(this);
        Window.window.pack();

    }



}
