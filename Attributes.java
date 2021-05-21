import java.util.Map;
import java.util.LinkedHashMap;

// Should Attributes implement also Map ? Inherit LinkedHashMap ?

// TODO? Fromstring (parser) with attribute checker ?

// TODO: rename XMLAttributes ?

// TODO: not abstract ? As a bag of unchecked attributes ? Let's say yes.

public class Attributes implements XML {

    // Preserve insertion order. Display as a LinkedHashMap to make it obvious?
    protected final Map<String, String> attributes = new LinkedHashMap<String, String>();
    
    public Attributes(Attributes... attributesArray) {
        for (Attributes attributes: attributesArray) {
            for (String key: attributes.attributes.keySet()) {
                String value = attributes.attributes.get(key);
                this.attributes.put(key, value);
            }
        }
    }

    // TODO: escape keys(?) and (at least) values.
    // TODO: don't insert if null value;
    public String toXML() {
        String string = "";
        for (String key: attributes.keySet()) {
            String value = attributes.get(key);
            if (value != null) {
                string += key + "=\"" + value + "\"" + " ";
            }
        }
        if (string.length() > 0) {
            // remove trailing extra space.
            return string.substring(0, string.length() - 1);
        }
        return string;

    }

    public String toString() {
        return this.attributes.toString(); // or .toXML() ?
    }
}