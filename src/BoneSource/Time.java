package BoneSource;

import java.util.concurrent.TimeUnit;

public class Time {
    static float deltaTime;

    static float startTicks;
    static float currentTicks;

    public static void setStartTicks() {
        startTicks = (float) System.currentTimeMillis();
    }

    public static void setStartTicks(float tick) {
        startTicks = tick;
    }

    public static float getStartTicks() {
        return startTicks;
    }

    public static void setCurrentTicks() {
        currentTicks = (float) System.currentTimeMillis();
    }
    public static void setCurrentTicks(float value) {
        currentTicks = Mathf.round(value, 2);
    }

    public static float getCurrentTicks() {
        return currentTicks;
    }

    public static void setDeltaTime() {
        deltaTime = (currentTicks - startTicks); // / 1000000000;

        if(deltaTime < 0) {
            deltaTime = (deltaTime - (deltaTime * 2)); // / 1000000000;
        }

        if (deltaTime < 0.001f) {
            deltaTime = 0.001f;
        }
    }

    public static void setDeltaTime(float a, float b) {
        deltaTime = (b - a); // / 1000000000;

        if(deltaTime < 0) {
            deltaTime = (deltaTime - (deltaTime * 2)); // / 1000000000;
        }

        if (deltaTime < 0.01f) {
            deltaTime = 0.01f;
        }
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
