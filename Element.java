import java.util.List;
import java.util.Map;

// TODO : clone, etc.

// TODO: create an indentation function by clone + insertion of blank text nodes.

abstract public class Element extends Node implements XML {
    public String tagName;
    public Map<String, String> attributes;
    public List<Node> children;
    protected String style; // TODO: upgrade as a class.
    // TODO: accept fill, stroke as Colors (does it ALWAYS make sense ? Probaby not)
    // style finally dunno if we really need it ... even font stuff can be
    // specified directly as attributes.
    // TODO: transform

    protected Element(String tagName, Map<String, String> attributes, List<Node> children) {
        this.tagName = tagName;
        this.attributes = attributes;
        this.children = children;
    }

    public String toXML() {
        return ""; // TODO !
    }

    public String toString() {
        return this.toXML();
    }

}