package BoneSource;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BoneSource {

    static Application applicationInstance;

    public static void hiMum() {
        System.out.println("Hi, mum!");
    }

    static int frames;
    static float frameRate;

    public static void run(Application app) {
        System.out.println("BoneSource is functional...");

        CreateLogDirectory();


        applicationInstance = app;

        applicationInstance.start();
        float currentTick = System.currentTimeMillis();
        float currentFrameTime;

        float totalFrameTime = 0.0f;

        float frameDelay;
        //TODO: refactor the frame rate stuff to be in Time class
        while(Window.window.isShowing()) {

            currentFrameTime = System.currentTimeMillis();

            applicationInstance.update();
            Window.setWindowDimensions(new Vector2(Window.window.getSize().width, Window.window.getSize().height));

            Time.setDeltaTime(currentTick, currentFrameTime);


            currentTick = currentFrameTime;

            totalFrameTime += Time.deltaTime();

            frames++;

            if(frames >= 100) {
                frameRate = Mathf.round(frames / totalFrameTime, 2);
                frames = 0;
                totalFrameTime = 0.0f;

            }

            frameDelay = Mathf.round(frameRate / 1000, 2);

            Window.setMinimumWindowDimensions();

            Time.waitForMilliseconds(frameDelay);



        }

        Debug.print("not while");

    }

    public static float getFrameRate() {
        return frameRate;
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

