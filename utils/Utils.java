package utils;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.lang.RuntimeException;
import java.lang.System;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// TODO: simple error handling (RuntimeException only, message)

public class Utils {

    // error or exit ? With optional error code?
    public static void error(String message) {
        throw new RuntimeException(message);
    }

    public static String str(boolean b) {
        return Boolean.valueOf(b).toString();
    }

    public static String str(byte b) {
        return Integer.valueOf(b).toString();
    }

    public static String str(short s) {
        return Integer.valueOf(s).toString();
    }

    public static String str(int i) {
        return Integer.valueOf(i).toString();
    }

    public static String str(float f) {
        return Float.valueOf(f).toString();
    }

    public static String str(double d) {
        return Double.valueOf(d).toString();
    }

    public static String str(char c) {
        return Character.toString(c);
    }

    public static String str(String s) {
        return s;
    }

    public static String str(long l) {
        return Long.valueOf(l).toString();
    }

    public static void print(String string) {
        System.out.print(string);
    }

    public static void println(String string) {
        print(string + "\n");
    }

    public static String read(String filename) {
        Path path = Paths.get(filename);
        try {
            byte[] bytes = Files.readAllBytes(path);
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException error) {
            String message = error.getMessage();
            throw new RuntimeException("IOException: " + message);
        }
    }

    public static void write(String filename, String content) {
        try {
            FileOutputStream output = new FileOutputStream(filename);
            OutputStreamWriter writer = new OutputStreamWriter(output, "UTF-8");
            writer.write(content);
            writer.close();
        } catch (IOException error) {
            String message = error.getMessage();
            throw new RuntimeException("IOException: " + message);
        }
    }

    public static void append(String filename, String content) {
        String fileContent = read(filename);
        String newContent = fileContent + content;
        write(filename, newContent);
    }

    public static int length(String string) {
        return string.length();
    }

    public static <Type> int length(Type[] array) {
        return array.length;
    }

    // That kind of stuff is needed for primitive types.
    public static int length(int[] array) {
        return array.length;
    }

}