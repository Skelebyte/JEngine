package JEngine;



import JEngine.Renderers.Renderer2D;
import JEngine.Renderers.Renderer3D;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JEngine implements Runnable {

    static Application applicationInstance;
    static RendererType rendererType;

    public static void hiMum() {
        System.out.println("Hi, mum!");
    }

    static double fps = 0;


    static Thread thread;

    static double updateCap = 1.0 / 999.0;

    static JRenderer renderer;
    public static JCamera camera;

    public JEngine(Application app, RendererType type) {
        applicationInstance = app;
        rendererType = type;
    }

    public static void run(Application app, RendererType type) {
        thread = new Thread(new JEngine(app, type));
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
    @Override
    public void run() {
        System.out.println("JEngine is functional...");

        CreateLogDirectory();
        Window.makeWindow("JEngine Window", 1000, 600, true);

        if(rendererType == RendererType.Renderer3D) {
            Debug.print("renderer is 3D");
            renderer = new Renderer3D(Window.getWindowSize());
        } else if(rendererType == RendererType.Renderer2D) {
            Debug.print("renderer is 2D");
            renderer = new Renderer2D(Window.getWindowSize());
        } else {
            Debug.print("renderer is null");
            renderer = null;
        }


        applicationInstance.start();



        boolean render = false;
        double firstTick = 0.0;
        double lastTick = System.nanoTime() / 1000000000.0;
        double deltaTime = 0.0;
        double unprocessedDeltaTime = 0.0;

        double frameTime = 0.0;
        int frames = 0;



        while(Window.window.isShowing()) {

            renderer.updateRendererData(Window.getWindowSize());


            render = false;
            firstTick = System.nanoTime() / 1000000000.0;
            deltaTime = firstTick - lastTick;
            Time.setDeltaTime(deltaTime);
            lastTick = firstTick;

            unprocessedDeltaTime += deltaTime;
            frameTime += deltaTime;



            applicationInstance.update();



            while(unprocessedDeltaTime >= updateCap) {
                unprocessedDeltaTime -= updateCap;
                render = true;


                if(frameTime >= 1.0) {
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                }

            }

            if(render) {
                frames++;


            } else {
                try {
                    thread.sleep(1);
                } catch (InterruptedException e) {
                    Debug.logException(getClass(), e);
                }
            }

            dispose();





        }

        Debug.print("not while");

    }

    void dispose() {

    }

    public static double getFps() {
        return fps;
    }

    public static void setFrameCap(double value) {
        updateCap = 1.0 / value;
    }

    public static JRenderer getRenderer() {
        return renderer;
    }

}

