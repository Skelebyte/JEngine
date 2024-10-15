package JEngine.Objects;

import JEngine.Assets.Texture;
import JEngine.JObject;

public class Sprite extends JObject {

    public Texture texture;

    protected Sprite() {
        super();

    }
    protected Sprite(Texture spriteTexture) {
        super();

    }
    protected Sprite(String path) {
        super();
        texture = new Texture(path);
    }

    @Override
    public void start() {

    }

    @Override
    public void tick() {

    }
}
