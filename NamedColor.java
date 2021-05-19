import java.util.Map;
import java.util.HashMap;

public class NamedColor extends Color {
    private static final Map<String, String> namedColors;
    
    static {
        namedColors = new HashMap<String, String>();
        namedColors.put("black", "#000000");
        namedColors.put("white", "#ffffff");
        namedColors.put("red", "#ff0000");
        namedColors.put("green", "#00ff00");
        namedColors.put("blue", "#0000ff");
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
