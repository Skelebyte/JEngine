package BoneSource;


import com.sun.jdi.InconsistentDebugInfoException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    static Application applicationInstance;

    public static void hiMum() {
        System.out.println("Hi, mum!");
    }

    static int frames;
    public static float frameRate;

    public static void run(Application app) {
        System.out.println("BoneSource is functional...");

        CreateLogDirectory();


        applicationInstance = app;

        applicationInstance.start();
        Time.setStartTicks();


        while(Window.window.isShowing()) {
            frames++;
            Time.setCurrentTicks(System.nanoTime());

            applicationInstance.update();
            // Window.setWindowDimensions(new Vector2(Window.window.getSize().width, Window.window.getSize().height));


            Time.setStartTicks(System.nanoTime());


            Time.setDeltaTime();

            float time = Mathf.round(Time.deltaTime(), 2);

            float tempfps = (frames / Time.deltaTime() ) / 1000;

            frameRate = Mathf.round(tempfps, 10);

            frames = 0;

            Time.waitForMilliseconds(time);



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

