public class Text extends Node implements XML {
    private final String text;
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