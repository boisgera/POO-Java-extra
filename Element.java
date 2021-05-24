import java.util.ArrayList;
import java.util.List;

// TODO : clone, etc.

// TODO: create an indentation function by clone + insertion of blank text nodes.

abstract public class Element implements Node {
    public String name;
    public Attributes attributes;
    public List<Node> children;

    protected Element() {
    }

    protected Element(String name, Attributes attributes, Node... children) {
        this.name = name;
        this.attributes = attributes;
        this.children = new ArrayList<Node>();
        for (Node child: children) {
            this.children.add(child);
        }
    }
    protected Element(String name, Node... children) {
        this(name, new Attributes(), children);
    }

    public String toXML() {
        String xml = "<" + this.name ;
        String attrString = this.attributes.toXML();
        if (attrString.length() > 0) {
            xml += " " + attrString;
        }
        xml += ">";
        if (this.children != null) {
            for (Node child: this.children) {
                xml += child.toXML();
            }
        }
        xml += "</" + this.name + ">";
        return xml;
    }

    public String toString() {
        return this.toXML();
    }

}