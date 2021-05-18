import static utils.Utils.*;

public class Preamble {

    public static void println(String string) {
        print(string + "\n");
    }

    public static void printInt(int i) {
        print(str(i));
    }

    public static void printlnInt(int i) {
        println(str(i));
    }

    public static void append(String filename, String content) {
        String fileContent = read(filename);
        String newContent = fileContent + content;
        write(filename, newContent);
    }

    public static void openThePodBayDoors() {
        error("I am afraid I can't do that Dave.");
    }
    public static void main(String[] args) {
        print("Hello world! 👋\n");
        println("Hello world! 👋");
        printlnInt(42);
        write("Hello.txt", "Hello World! 👋");
        println(read("Hello.txt"));
        append("Hello.txt", " v2");
        println(read("Hello.txt"));
        openThePodBayDoors();
    }
}