package JEngine.Assets;

import JEngine.Asset;
import JEngine.Debug;
import JEngine.LogType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Objects;

public class Texture extends Asset {

    BufferedImage texture;

    public Texture(String path) {
        super(path);
        loadTexture(path);
    }

    public void loadTexture(String path) {

        InputStream stream = ClassLoader.getSystemResourceAsStream(path);
        if(stream == null) {
            Debug.log(LogType.ERROR, "Image directory is incorrect: " + path);
            return;
        }

        try {
            BufferedImage temp = ImageIO.read(stream);

            BufferedImage processedTemp = new BufferedImage(temp.getWidth(), temp.getHeight(), BufferedImage.TYPE_INT_ARGB);

            processedTemp.getGraphics().drawImage(temp, 0, 0, null);
            texture = processedTemp;
        } catch (Exception e) {
            Debug.logException(getClass(), e);
        }

    }

    public BufferedImage getTexture() {
        return  texture;
    }

    public static Texture blank() {
        return new Texture("JEngine/Resources/NoTexture.png");
    }

}
