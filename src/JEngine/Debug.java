package JEngine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Debug {

    public static String logDirectory = "saved/logs/";

    // This should be the file type of the log, not the name of the file.
    public static String logFile = ".log";
    public static String logTimeAndDateFormat = "dd-MM-yyyy HH:mm:ss";

    public static void print(String message) {
        System.out.println(message);
    }
    public static void print(int message) {
        System.out.println(message);
    }
    public static void print(float message) {
        System.out.println(message);
    }
    public static void print(double message) {
        System.out.println(message);
    }
    public static void print(long message) {
        System.out.println(message);
    }
    public static void print(Vector2 message) {
        System.out.println("(" + message.x() + "," + message.y() + ")");
    }



    public static String log(LogType type, String message) {
        String entry = "";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(logTimeAndDateFormat);

        LocalDateTime now = LocalDateTime.now();

        entry += formatter.format(now) + " - ";

        switch (type) {
            case MESSAGE -> entry += "MESSAGE: ";
            case WARNING -> entry += "WARNING: ";
            case ERROR -> entry += "ERROR: ";
        }

        entry += message;

        print(entry);

        try {
            String[] split = formatter.format(now).split("\\s+");
            BufferedWriter writer = new BufferedWriter(new FileWriter(logDirectory + (split[0] + logFile), true));

            writer.write(entry);
            writer.newLine();
            writer.close();

        } catch (IOException e) {
            System.out.println(e.getMessage() + " : " + e.getCause());

        }

        return entry;

    }

    public static String logException(Exception exception) {
        String entry = "";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(logTimeAndDateFormat);

        LocalDateTime now = LocalDateTime.now();

        entry += formatter.format(now) + " - ";

        entry += "ERROR (EXCEPTION): ";

        entry += exception.getMessage() + " : " + exception.getCause();

        print(entry);

        try {
            String[] split = formatter.format(now).split("\\s+");
            BufferedWriter writer = new BufferedWriter(new FileWriter(logDirectory + (split[0] + logFile), true));

            writer.write(entry);
            writer.newLine();
            writer.close();

        } catch (IOException e) {
            System.out.println(e.getMessage() + " : " + e.getCause());

        }

        return entry;

    }

}
