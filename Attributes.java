import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

// Should Attributes implement also Map ? Inherit LinkedHashMap ?

// TODO? Fromstring (parser) with attribute checker ?

// TODO: rename XMLAttributes ?

// TODO: not abstract ? As a bag of unchecked attributes ? Let's say yes.

// TODO: filter a list of attributes ?


public class Attributes implements XML {

    // Preserve insertion order. Display as a LinkedHashMap to make it obvious?
    // Do we want to preserve this warrantee ? Our constructor do not allow us
    // to preserve the order, so drop it? If we don't know, Map is appropriate.
    // Mmm ; ok now we have a better chance with the explicit getters and 
    // setters to preserve keys order, so the question is open again.
    protected final Map<String, String> attributesMap; 
    // Should the attributes be final ? Probably yes (rebind would SUCK).
    
    public Attributes() {
        attributesMap = new HashMap<String, String>();
    }

    protected static void checkArray(String[][] attributes) {
        if (attributes == null) {
            throw new IllegalArgumentException("null attributes array");
        }
        for (String[] kv: attributes) {
            if (kv.length != 2) {
                String message = "attributes should contain pairs of strings. ";
                message += "One item of length " + kv.length + " != 2 has been found.";
                throw new IllegalArgumentException(message);
            } else {
                for (String string: kv) {
                    if (string == null) {
                        String message = "attributes: null string found.";
                        throw new IllegalArgumentException(message);
                    }
                }
            }

        }
    }

    protected static void checkKeys(String[][] attributes, String[] keys) {
        List<String> keyList = Arrays.asList(keys);
        for (String[] kv: attributes) {
            String key = kv[0];
            if (!(keyList.contains(key))) {
                String message = "invalid Attributes key: " + key;
                throw new IllegalArgumentException(message);
            }
        }
    }


    public Attributes(String[][] attributes) {
        this();
        Attributes.checkArray(attributes);
        for (String[] kv: attributes) {
            String key = kv[0];
            String value = kv[1];
            this.attributesMap.put(key, value);
        }
    }

    public String[][] toArray() {
        int length = 0;
        for (String key: attributesMap.keySet()) {
            String value = attributesMap.get(key);
            if (value != null) {
                length += 1;
            }
        }
        String[][] array = new String[length][];
        int i = 0;
        for (String key: attributesMap.keySet()) {
            String value = attributesMap.get(key);
            if (value != null) {
                String[] kv = new String[2];
                kv[0] = key;
                kv[1] = value;
                array[i] = kv;
                i += 1;
            }
        }
        return array;
    }

    // protected Attributes update(Map<String, String> attributes) {
    //     for (String key: attributes.keySet()) {
    //         String value = attributes.get(key);
    //         this.attributesMap.put(key, value);
    //     }
    //     return this;
    // }

    // public Attributes(Map<String, String> attributesMap) {
    //     this();
    //     this.update(attributesMap);
    // }

    // public Map<String, String> toMap() {
    //     return new HashMap<String, String>(this.attributesMap);
    // }


    protected void update(Attributes attributes) {
        for (String[] kv: attributes.toArray()) {
            String key = kv[0];
            String value = kv[1];
            this.attributesMap.put(key, value);
        }
    }

    public Attributes(Attributes attributes) {
        this();
        this.update(attributes);
    }

    public Attributes(Attributes... attributesArray) {
        this();
        for (Attributes attributes: attributesArray) {
            this.update(attributes);
        }
    }

    public Attributes filter(String... keys) {
        Attributes filteredAttributes = new Attributes();
        for (String key: keys) {
            String value = this.attributesMap.get(key);
            if (value != null) {
                filteredAttributes.attributesMap.put(key, value);
            }
        }
        return filteredAttributes;
    }

    // TODO: escape keys(?) and (at least) values.
    public String toXML() {
        String string = "";
        for (String key: attributesMap.keySet()) {
            String value = this.attributesMap.get(key);
            if (value != null) { // don't insert if null value;
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
        return this.attributesMap.toString(); // or .toXML() ?
    }
}