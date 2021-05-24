public class TextContent implements Node {
    private final String text;

    // TODO: escape text

    public TextContent(String text) {
        this.text = text;
    }
    public String toString() {
        return this.text;
    }
    public String toXML() {
        return this.text;
    }
}