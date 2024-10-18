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
            BufferedImage temp = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

            texturePixels = ((DataBufferInt) temp.getRaster().getDataBuffer()).getData();

            for(int x = 0; x < image.getWidth(); x++) {
                for(int y = 0; y < image.getHeight(); y++) {
                    for(int i = 0; i < texturePixels.length; i++) {
                        texturePixels[i] = image.getRGB(x, y);
                    }
                }
            }

        } catch (IOException e) {
            Debug.logException(getClass(), e);
        }
    }

}
