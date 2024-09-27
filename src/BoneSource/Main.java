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

    public static void run(Application app) {
        System.out.println("BoneSource is functional...");

        CreateLogDirectory();


        applicationInstance = app;


        Time.setStartTicks();
        applicationInstance.start();

        while(Window.window.isActive()) {

            Time.setCurrentTicks(Mathf.round(Time.getCurrentTicks() + 5, 0));
            Debug.print("current tick: " + Time.getCurrentTicks());

            applicationInstance.update();
            Window.setWindowDimensions(new Vector2(Window.window.getSize().width, Window.window.getSize().height));


            Time.setDeltaTime();
            Debug.print("start tick (before): " + Time.getStartTicks());
            Time.setStartTicks(Mathf.round(Time.getCurrentTicks() + 5, 0));
            Debug.print("start tick (after): " + Time.getStartTicks());

            float time = Mathf.round(Time.deltaTime(), 2);
            Debug.print("deltaTime rounded 2dp: " + time);

            Time.waitForMilliseconds(time);



        }

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

