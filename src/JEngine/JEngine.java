package JEngine;

// look at https://www.youtube.com/watch?v=4iPEjFUZNsw, good base for the game loop.

import JEngine.Assets.*;

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

    static double updateCap = 1.0 / 60.0;

    static ArrayList<Mesh> renderQueue = new ArrayList<Mesh>();

    static Camera3D camera;

    static Texture lerpTexture = new Texture("src/JEngine/Resources/Lerp.png");

    static BufferStrategy bufferStrategy;


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
    @Override
    public void run() {
        System.out.println("JEngine is functional...");

        CreateLogDirectory();




        applicationInstance.start();
        boolean render = false;
        double firstTick = 0.0;
        double lastTick = System.nanoTime() / 1000000000.0;
        double deltaTime = 0.0;
        double unprocessedDeltaTime = 0.0;

        double frameTime = 0.0;
        int frames = 0;


        while(Window.window.isShowing()) {
            render = false;
            firstTick = System.nanoTime() / 1000000000.0;
            deltaTime = firstTick - lastTick;
            Time.setDeltaTime(deltaTime);
            lastTick = firstTick;

            unprocessedDeltaTime += deltaTime;
            frameTime += deltaTime;

            applicationInstance.update();

            if(bufferStrategy == null && camera != null) {
                bufferStrategy = camera.strategy;
            }

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

                if(camera != null && camera.active) {
                    Renderer3D renderer3D = new Renderer3D(Window.getWindowDimensions().x(), Window.getWindowDimensions().y(), camera.fov, camera.nearClipDistance, lerpTexture.getTexture());

                    /* TODO:
                     *  - get buffer strategy can get Graphics2D from it
                     *  - draw each mesh in the render queue
                     */

                    Graphics2D graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
                    renderer3D.drawGraphics(graphics, renderQueue);
                }


            } else {
                try {
                    thread.sleep(1);
                } catch (InterruptedException e) {
                    Debug.logException(e);
                }
            }

            dispose();


            // Window.setWindowDimensions(new Vector2(Window.window.getSize().width, Window.window.getSize().height));
            // Window.setMinimumWindowDimensions();


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

    public static void addMeshToRenderQueue(Mesh mesh) {
        renderQueue.add(mesh);
    }

    public static void setCamera(Camera3D _camera) {
        camera = _camera;
    }

}

