package JEngine.Objects;

import JEngine.Debug;

public class Sprite2D extends Sprite {
    @Override
    public void start() {
        Debug.print("This is my sprite start");
    }

    @Override
    public void tick() {
        Debug.print("This is my sprite tick");
    }
}
