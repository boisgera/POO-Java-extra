
public class RectangleAttributes extends Attributes {

    protected static String[] keys = {
        "x", "y", 
        "width", "height",
        "rx", "ry",
        "pathlength",
        "fill", "fill-opacity", "fill-rule",
        "stroke", "stroke-dasharray", "stroke-dashoffset", "stroke-linecap", 
        "stroke-linejoin", "stroke-miterlimit", "stroke-opacity", "stroke-width"
    };

    public RectangleAttributes() {
        super();
    }

    public RectangleAttributes(Attributes attributes) {
        this();
        Attributes.checkKeys(attributes.toArray(), RectangleAttributes.keys);

        // TODO: here, perform optional value validation

        this.update(attributes);
    }

    public RectangleAttributes(String[][] attributes) {
        this(new Attributes(attributes));
    }


    // Accessors
    // -------------------------------------------------------------------------
}