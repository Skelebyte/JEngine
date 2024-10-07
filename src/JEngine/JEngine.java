package JEngine;

// look at https://www.youtube.com/watch?v=4iPEjFUZNsw, good base for the game loop.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JEngine implements Runnable{

    static Application applicationInstance;

    public static void hiMum() {
        System.out.println("Hi, mum!");
    }

    static int frames;
    static int fps = 0;


    static Thread thread;

    final float updateCap = 1f / 60f;


    public JEngine(Application app) {
        applicationInstance = app;
    }

    public static void run(Application app) {
        thread = new Thread(new JEngine(app));
        thread.start();
    }

    static void CreateLogDirectory() {
        Path path = Paths.get(Debug.logDirectory);
        try {
            Files.createDirectories(path);
        } catch (IOException ex) {
            System.out.println(ex.getMessage() + " : " + ex.getCause());
        }
    }

    //  frames range from 3 to 4 atm, before it was 6 - 8.
    // TODO: fix it
    @Override
    public void run() {
        System.out.println("JEngine is functional...");

        CreateLogDirectory();




        applicationInstance.start();
        boolean render = false;
        float firstTick = 0.0f;
        float lastTick = (float) System.nanoTime() / 1000000000.0f;
        float deltaTime = 0.0f;
        float unprocessedDeltaTime = 0.0f;

        float frameTime = 0.0f;
        int frames = 0;


        while(Window.window.isShowing()) {
            render = false;

            firstTick = (float) System.nanoTime() / 1000000000.0f;

            deltaTime = firstTick - lastTick;

            lastTick = firstTick;
            unprocessedDeltaTime += deltaTime;
            frameTime += unprocessedDeltaTime;

            applicationInstance.update();

            while(unprocessedDeltaTime >= updateCap) {
                unprocessedDeltaTime -= updateCap;

                render = true;

                if(frameTime >= unprocessedDeltaTime) {
                    fps = (int)Mathf.round(frames, 0);
                    frameTime = 0;
                    // frames = 0;
                }

            }



            if(render) {
                frames++;

            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Debug.log(LogType.ERROR, e.getMessage() + " : " + e.getCause());
                }
            }

            Dispose();


            // Window.setWindowDimensions(new Vector2(Window.window.getSize().width, Window.window.getSize().height));
            // Window.setMinimumWindowDimensions();


        }

        Debug.print("not while");

    }

    void Dispose() {

    }

    public static int getFps() {
        return fps;
    }
}

