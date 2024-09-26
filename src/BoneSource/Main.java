package BoneSource;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static Application applicationInstance;

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

            Time.setCurrentTicks();

            applicationInstance.update();
            Window.setWindowDimensions(new Vector2(Window.window.getSize().width, Window.window.getSize().height));


            Time.setDeltaTime();

            Time.setStartTicks(Time.getCurrentTicks());


            float time = Time.deltaTime() / 1000;

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

