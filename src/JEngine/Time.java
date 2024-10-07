package JEngine;

import java.util.concurrent.TimeUnit;

public class Time {

    static double dt = 0.0;

    public static void setDeltaTime(double value) {
        dt = value;
    }

    public static double deltaTime() {
        return dt;
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
