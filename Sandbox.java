import static utils.Utils.*;

public class Sandbox {    
    public static void main(String[] args) {
        String source = read("App.java");
        println(source);
        write("App.java.bak", source);
        append("App.java.bak", "\n\\\\ That's all folks.\n");

        int[] integers = {4, 5, 6};
        println(str(length(integers)));

        String string = "some text";
        println(str(length(string)));
    }
}