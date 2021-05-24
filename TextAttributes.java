
public class TextAttributes extends Attributes {

    protected static String[] keys = {
        "x", "y",
        "dx", "dy",
        "rotate",
        "lengthAdjust",
        "pathlength",
        "fill", "fill-opacity", "fill-rule",
        "stroke", "stroke-dasharray", "stroke-dashoffset", "stroke-linecap", 
        "stroke-linejoin", "stroke-miterlimit", "stroke-opacity", "stroke-width",
        "font-family", "font-size", "font-size-adjust", "font-stretch", "font-style", 
        "font-variant", "font-weight",
        "text-anchor"
    };

    public TextAttributes()
    {
        super();
    }

    public TextAttributes(Attributes attributes)
    {
        this();
        Attributes.checkKeys(attributes.toArray(), TextAttributes.keys);

        // TODO: here, perform optional value validation

        this.update(attributes);
    }

    public TextAttributes(String[][] attributes) {
        this(new Attributes(attributes));
    }

    // Accessors
    // -------------------------------------------------------------------------
}