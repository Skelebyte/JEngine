package BoneSource;

import java.util.concurrent.TimeUnit;

public class Time {
    static float deltaTime;

    static float startTicks;
    static float currentTicks;

    public static void setStartTicks() {
        startTicks = Mathf.round(System.nanoTime(), 2);
    }

    public static void setStartTicks(float tick) {
        startTicks = tick;
    }

    public static float getStartTicks() {
        return startTicks;
    }

    public static void setCurrentTicks() {
        currentTicks = Mathf.round(System.nanoTime(), 2);
    }
    public static void setCurrentTicks(float value) {
        currentTicks = Mathf.round(value, 2);
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
        try {
            TimeUnit.SECONDS.sleep((long) time);
        } catch (InterruptedException e) {
            Debug.log(LogType.ERROR, e.getMessage() + " : " + e.getCause());
        }
    }
    public static void waitForMilliseconds(float time) {
        try {
            TimeUnit.MILLISECONDS.sleep((long) time); // try round it
        } catch (InterruptedException e) {
            Debug.log(LogType.ERROR, e.getMessage() + " : " + e.getCause());
        }
    }
    public static void waitForMinutes(float time) {
        try {
            TimeUnit.MINUTES.sleep((long) time);
        } catch (InterruptedException e) {
            Debug.log(LogType.ERROR, e.getMessage() + " : " + e.getCause());
        }
    }
}
