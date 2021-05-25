import java.util.ArrayList;
import java.util.List;

abstract public class Element implements Node {
    public final String name;
    protected Attributes attributes;
    protected List<Node> children;

    protected Element(String name, Attributes attributes, Node... children) {
        this.name = name;
        this.attributes = attributes;
        this.children = new ArrayList<Node>();
        for (Node child: children) {
            this.children.add(child);
        }
    }

    protected Element(String name, Node... children) {
        this.name = name;
        for (Node child: children) {
            this.children.add(child);
        }
    }

    public String getName() {
        return this.name;
    }

    public Attributes getAttributes() {
        return this.attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public List<Node> getChildren() {
        if (!(children == null)) {
            return new ArrayList<Node>(this.children);
        } else {
            return null;
        }
    }

    public void setChildren(List<Node> children) {
        if (this.children != null) {
            this.children = new ArrayList<Node>(children);
        } else {
            String message = "type " + this.name + " cannot have children.";
            throw new RuntimeException(message);
        }
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

    public void indent() {
        this.indent(0);
    }

    public void indent(int depth) {
        List<Node> children = this.getChildren();
        if (!(children == null) && children.size() != 0) {
            List<Node> newChildren = new ArrayList<Node>();
            for (int i=0; i < children.size(); i++) {
                Node child = children.get(i);
                if (child instanceof Element) {
                    Element childElement = (Element) child;
                    childElement.indent(depth + 1);
                }
                newChildren.add(new TextContent("\n"));
                newChildren.add(new TextContent("  ".repeat(depth + 1)));
                newChildren.add(child);
                if (i == children.size() - 1) {
                    newChildren.add(new TextContent("\n"));
                    newChildren.add(new TextContent("  ".repeat(depth)));
                }
            }
            this.setChildren(newChildren);
        }
    }

    public String toString() {
        return this.toXML();
    }

}