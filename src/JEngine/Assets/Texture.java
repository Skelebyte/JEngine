package JEngine.Assets;

import JEngine.Asset;
import JEngine.Debug;
import JEngine.Loader;
import JEngine.LogType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.io.InputStream;

public class Texture extends Asset {

    public int[] texturePixels;

    public Texture(String path) {
        super(path);

        loadTexture(path);
    }

    public void loadTexture(String path) {
        try {
            InputStream stream = Loader.load(path);

            if(stream == null) {
                Debug.log(LogType.ERROR, "Stream is null.");
                return;
            }

            BufferedImage image = ImageIO.read(stream); // BufferedImage.TYPE_INT_RGB

            Debug.print(image.getWidth() + ", " + image.getHeight());

            texturePixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

        } catch (IOException e) {
            Debug.logException(getClass(), e);
        }
    }

}
