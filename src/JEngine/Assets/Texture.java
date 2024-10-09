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
    }

    public void loadTexture(String path) {
        if(!Objects.equals(assetPath, path)) assetPath = path;
        try (InputStream stream = getClass().getResourceAsStream(path)) {
            if (stream != null) {
                BufferedImage temp = ImageIO.read(stream);

                BufferedImage processedTemp = new BufferedImage(temp.getWidth(), temp.getHeight(), BufferedImage.TYPE_INT_ARGB);

                processedTemp.getGraphics().drawImage(temp, 0, 0, null);
                texture = processedTemp;
            } else {
                Debug.log(LogType.ERROR, "Stream is null! Can not load image from '" + path + "'.");
            }
        } catch (Exception e) {
            Debug.logException(e);
        }

    }

    public BufferedImage getTexture() {
        return  texture;
    }

    public static Texture blank() {
        return new Texture("src/JEngine/Resources/NoTexture.png");
    }

}
