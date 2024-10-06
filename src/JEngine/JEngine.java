package JEngine;

// look at https://www.youtube.com/watch?v=4iPEjFUZNsw, good base for the game loop.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JEngine {

    static Application applicationInstance;

    public static void hiMum() {
        System.out.println("Hi, mum!");
    }

    static int frames;
    static float frameRate;



    public static void run(Application app) {
        System.out.println("JEngine is functional...");

        CreateLogDirectory();


        applicationInstance = app;

        applicationInstance.start();

        float firstTick = 0.0f;
        float lastTick = (float) System.nanoTime() / 1000000000;
        float deltaTime = 0;
        float unprocessedDeltaTime = 0;

        while(Window.window.isShowing()) {

            firstTick = (float) System.nanoTime() / 1000000000;

            deltaTime = firstTick - lastTick;

            lastTick = firstTick;

            unprocessedDeltaTime += deltaTime;

            applicationInstance.update();
            Window.setWindowDimensions(new Vector2(Window.window.getSize().width, Window.window.getSize().height));


            Window.setMinimumWindowDimensions();


        }

        Debug.print("not while");

    }

    static void CreateLogDirectory() {
        Path path = Paths.get(Debug.logDirectory);
        try {
            Files.createDirectories(path);
        } catch (IOException ex) {
            System.out.println(ex.getMessage() + " : " + ex.getCause());
        }
    }


}

