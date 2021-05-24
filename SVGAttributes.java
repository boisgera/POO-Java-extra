
public class SVGAttributes extends Attributes {

    protected static String[] keys = {
        "x", "y", 
        "width", "height",
        "baseProfile", 
        "contentScriptType", 
        "contentStyleType",
        "preserveAspectRatio",
        "version",
        "viewbox",
        "xmlns"
    };

    public SVGAttributes()
    {
        super();
    }

    public SVGAttributes(Attributes attributes)
    {
        this();
        Attributes.checkKeys(attributes.toArray(), SVGAttributes.keys);

        // TODO: here, perform optional value validation

        this.update(attributes);
    }

    public SVGAttributes(String[][] attributes) {
        this(new Attributes(attributes));
    }

    // Accessors
    // -------------------------------------------------------------------------

    public String getHeight() {
        return this.attributesMap.get("height");
    }

    // public void setHeight(String height) {
    //     this.attributesMap.put("height", height);
    // }

    public String getWidth() {
        return this.attributesMap.get("width");
    }

    // public void setWidth(String width) {
    //     this.attributesMap.put("width", width);
    // }

    public String getX() {
        return this.attributesMap.get("x");
    }

    // public void setX(String x) {
    //     this.attributesMap.put("x", x);
    // }

    public String getY() {
        return this.attributesMap.get("y");
    }

    // public void setY(String y) {
    //     this.attributesMap.put("y", y);
    // }

    public String getbaseProfile() {
        return this.attributesMap.get("baseProfile");
    }

    // public void setbaseProfile(String baseProfile) {
    //     this.attributesMap.put("baseProfile", baseProfile);
    // }

    public String getContentScriptType() {
        return this.attributesMap.get("contentScriptType");
    }

    // public void setContentScriptType(String contentScriptType) {
    //     this.attributesMap.put("contentScriptType", contentScriptType);
    // }

    public String getContentStyleType() {
        return this.attributesMap.get("contentStyleType");
    }

    // public void setContentStyleType(String contentStyleType) {
    //     this.attributesMap.put("contentStyleType", contentStyleType);
    // }

    public String getPreserveAspectRatio() {
        return this.attributesMap.get("preserveAspectRatio");
    }

    // public void setPreserveAspectRatio(String preserveAspectRatio) {
    //     this.attributesMap.put("preserveAspectRatio", preserveAspectRatio);
    // }

    public String getVersion() {
        return this.attributesMap.get("version");
    }

    // public void setVersion(String version) {
    //     this.attributesMap.put("version", version);
    // }

    public String getViewBox() {
        return this.attributesMap.get("viewBox");
    }

    // public void setViewBox(String viewBox) {
    //     this.attributesMap.put("viewBox", viewBox);
    // }

    public String getXMLNS() {
        return this.attributesMap.get("xmlns");
    }

    // public void setXMLNS(String xmlns) {
    //     this.attributesMap.put("xmlns", xmlns);
    // }

}