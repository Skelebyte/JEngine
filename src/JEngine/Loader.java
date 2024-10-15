package JEngine;

import java.io.InputStream;

public class Loader {

    public static InputStream load(String path) {
        try {
            return ClassLoader.getSystemResourceAsStream(path);
        } catch (Exception e) {
            Debug.logException(Loader.class, e);
            return null;
        }

    }

}
