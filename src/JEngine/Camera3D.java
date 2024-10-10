package JEngine;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Camera3D extends Canvas {
    public boolean active = true;

    // In degrees
    public double fov;
    public double nearClipDistance;

    BufferStrategy strategy;

    public Camera3D(double _fov, double _nearClipDistance) {
        fov = _fov;
        nearClipDistance = _nearClipDistance;

        JEngine.camera = this;
        Window.window.add(this);

        try {
            Window.window.createBufferStrategy(2);
            strategy = Window.window.getBufferStrategy();
        } catch (Exception e) {
            Debug.logException(getClass(), e);
        }

    }

    public BufferStrategy getBufferStrategy() {
        return strategy;
    }

}
