package JEngine;

import java.io.InputStream;

public class Loader {

    public static InputStream load(String path) {
        return ClassLoader.getSystemResourceAsStream(path);
    }

}
