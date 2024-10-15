package JEngine.Assets;

import JEngine.Asset;
import JEngine.Loader;

import java.io.InputStream;

public class Texture extends Asset {

    int[] texturePixels;

    public Texture(String path) {
        super(path);
    }

    public void loadTexture(String path) {
        InputStream stream = Loader.load(path);
    }

}
