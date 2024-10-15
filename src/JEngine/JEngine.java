package JEngine;

// look at https://www.youtube.com/watch?v=4iPEjFUZNsw, good base for the game loop.


import JEngine.Assets.Texture;
import JEngine.Objects.Sprite2D;
import JEngine.Renderers.Renderer2D;
import JEngine.Renderers.Renderer3D;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JEngine implements Runnable {

    static Application applicationInstance;

    public static void hiMum() {
        System.out.println("Hi, mum!");
    }

    static int frames;
    static double fps = 0;


    static Thread thread;

    static double updateCap = 1.0 / 999.0;

    public static JRenderer renderer;
    static RendererType rendererType;
    public static JCamera camera;

    public static ArrayList<JObject> objects = new ArrayList<>();
    public static ArrayList<Texture> textureRenderQueue = new ArrayList<>();

    public JEngine(Application app) {
        applicationInstance = app;
    }

    public static void run(Application app, RendererType _rendererType) {
        thread = new Thread(new JEngine(app));
        rendererType = _rendererType;
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


        Window.makeWindow("hi mum", 1000, 600, true);



        if(rendererType == RendererType.DefaultRenderer) {
            renderer = new JRenderer(Window.getWindowDimensions());
        } else if(rendererType == RendererType.Renderer3D) {
            renderer = new Renderer3D(Window.getWindowDimensions());
        } else {
            renderer = new Renderer2D(Window.getWindowDimensions());
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

            renderer.updateRenderData(Window.getWindowDimensions());

            render = false;
            firstTick = System.nanoTime() / 1000000000.0;
            deltaTime = firstTick - lastTick;
            Time.setDeltaTime(deltaTime);
            lastTick = firstTick;

            unprocessedDeltaTime += deltaTime;
            frameTime += deltaTime;



            applicationInstance.tick();

            updateJObjects();

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

                if(rendererType == RendererType.Renderer3D) {
                    // TODO: render 3D stuff
                } else if(rendererType == RendererType.Renderer2D) {
                    render2D();
                }

                renderer.draw();

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

    void updateJObjects() {
        if(!objects.isEmpty()) {
            for(JObject jObject : objects) {
                if(!jObject.loopExecuted) {
                    jObject.objectThread.start();
                }

                if(jObject.getClass() == Sprite2D.class) {
                    Sprite2D sprite2D = (Sprite2D) jObject;

                    textureRenderQueue.add(sprite2D.texture);

                }

            }
        }
    }

    void render2D() {



        textureRenderQueue.clear();
    }

    public static double getFps() {
        return fps;
    }

    public static void setFrameCap(double value) {
        updateCap = 1.0 / value;
    }

}

