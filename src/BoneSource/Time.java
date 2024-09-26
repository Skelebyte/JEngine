package BoneSource;

import java.util.concurrent.TimeUnit;

public class Time {
    static float deltaTime;

    static float startTicks;
    static float currentTicks;

    public static void setStartTicks() {
        startTicks = System.nanoTime();
    }

    public static void setStartTicks(float tick) {
        startTicks = tick;
    }

    public static float getStartTicks() {
        return startTicks;
    }

    public static void setCurrentTicks() {
        currentTicks = System.nanoTime();
    }

    public static float getCurrentTicks() {
        return currentTicks;
    }

    public static void setDeltaTime() {
        deltaTime = currentTicks - startTicks;
    }

    public static float deltaTime() {
        return  deltaTime;
    }

    public static void waitForSeconds(float time) {
        Debug.print("waiting for: " + time + " seconds.");
        try {
            TimeUnit.SECONDS.sleep((long) time);
        } catch (InterruptedException e) {
            Debug.log(LogType.ERROR, e.getMessage() + " : " + e.getCause());
        }
    }
    public static void waitForMilliseconds(float time) {
        Debug.print("waiting for: " + time + " milliseconds.");
        try {
            Debug.print("sleeping... " + time);
            TimeUnit.MILLISECONDS.sleep((long) time); // try round it
            Debug.print("slept...");
        } catch (InterruptedException e) {
            Debug.log(LogType.ERROR, e.getMessage() + " : " + e.getCause());
        }
    }
    public static void waitForMinutes(float time) {
        Debug.print("waiting for: " + time + " minutes.");
        try {
            TimeUnit.MINUTES.sleep((long) time);
        } catch (InterruptedException e) {
            Debug.log(LogType.ERROR, e.getMessage() + " : " + e.getCause());
        }
    }
}
