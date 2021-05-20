import java.util.Map;
import java.util.HashMap;

public class NamedColor extends Color {
    private static Map<String, String> namedColors = new HashMap<String, String>();
    
    static {
        NamedColor.namedColors.put("black", "#000000");
        NamedColor.namedColors.put("white", "#ffffff");
        NamedColor.namedColors.put("red", "#ff0000");
        NamedColor.namedColors.put("green", "#00ff00");
        NamedColor.namedColors.put("blue", "#0000ff");
    }

    private static String find(String name) {
        String hexString = namedColors.get(name);
        if (hexString == null) {
            String message;
            message = "Invalid color name: " + name;
            throw new IllegalArgumentException(message);
        } else {
            return hexString;
        }
    }

    public NamedColor(String name) {
        super(NamedColor.find(name));
    }
}
