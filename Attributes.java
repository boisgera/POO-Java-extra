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
        attributesMap = new LinkedHashMap<String, String>();
    }

    public void update(Map<String, String> attributes) {
        for (String key: attributes.keySet()) {
            String value = attributes.get(key);
            this.attributesMap.put(key, value);
        }
    }

    public Map<String, String> toMap() {
        return new LinkedHashMap<String, String>(this.attributesMap);
    }

    public Attributes(Map<String, String> attributesMap) {
        this();
        this.update(attributesMap);
    }

    public void update(Attributes attributes) {
        this.update(attributes.toMap());
    }

    public Attributes(Attributes attributes) {
        this(attributes.toMap());
    }


    // Needed / useful ? Corresponding constructor with arrays ? maps ?
    // ATM the derived class directly leverage the attributes map.
    // Here this is a "concatenator + duplicator" of Attributes essentially. 
    // But it would accept 0 attributes, which would be weird ...
    // public Attributes(Attributes... attributesArray) {
    //     this();
    //     for (Attributes attributes: attributesArray) {
    //         this.update(attributes);
    //     }
    // }

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