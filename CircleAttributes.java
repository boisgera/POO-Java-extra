
public class CircleAttributes extends Attributes {

    protected static String[] keys = {
        "cx", "cy", "r",
        "pathlength",
        "fill", "fill-opacity", "fill-rule",
        "stroke", "stroke-dasharray", "stroke-dashoffset", "stroke-linecap", 
        "stroke-linejoin", "stroke-miterlimit", "stroke-opacity", "stroke-width"
    };

    public CircleAttributes()
    {
        super();
    }

    public CircleAttributes(Attributes attributes)
    {
        this();
        Attributes.checkKeys(attributes.toArray(), CircleAttributes.keys);

        // TODO: here, perform optional value validation

        this.update(attributes);
    }

    public CircleAttributes(String[][] attributes) {
        this(new Attributes(attributes));
    }

    // Accessors
    // -------------------------------------------------------------------------
}