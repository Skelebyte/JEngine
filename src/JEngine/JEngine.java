package JEngine;

// look at https://www.youtube.com/watch?v=4iPEjFUZNsw, good base for the game loop.


import JEngine.Renderers.Renderer2D;
import JEngine.Renderers.Renderer3D;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;

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

    public static double getFps() {
        return fps;
    }

    public static void setFrameCap(double value) {
        updateCap = 1.0 / value;
    }

}

