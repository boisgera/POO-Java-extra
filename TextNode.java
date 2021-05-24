public class Text extends Node {
    private final String text;

    // TODO: escape text

    public Text(String text) {
        this.text = text;
    }
    public String toString() {
        return this.text;
    }
    public String toXML() {
        return this.text;
    }
}