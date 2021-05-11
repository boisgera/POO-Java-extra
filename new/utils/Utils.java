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

public class Utils {
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
}