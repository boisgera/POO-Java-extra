import static utils.Utils.*;

public class App {    
    public static void main(String[] args) {
        String source = read("App.java");
        println(source);
        write("App.java.bak", source);
        append("App.java.bak", "\n\\\\ That's all folks.\n");
    }
}