import java.util.Map;

public class Font extends Attributes {

    public Font(Attributes attributes)
    {
        super(attributes.filter(
            "font-family", 
            "font-size", 
            "font-sizeAdjust",
            "font-stretch",
            "font-style",
            "font-variant",
            "font-weight"));
    }

    public Font(Map<String, String> attributesMap)
    {
        this(new Attributes(attributesMap));
    }

    public String getFamily() {
        return this.attributesMap.get("font-family");
    }

    public void setFamily(String family) {
        this.attributesMap.put("font-family", family);
    }

    public String getSize() {
        return this.attributesMap.get("font-size");
    }

    public void setSize(String size) {
        this.attributesMap.put("font-size", size);
    }

    public String getSizeAdjust() {
        return this.attributesMap.get("font-sizeAdjust");
    }

    public void setSizeAdjust(String sizeAdjust) {
        this.attributesMap.put("font-size-adjust", sizeAdjust);
    }

    public String getStretch() {
        return this.attributesMap.get("font-stretch");
    }

    public void setStretch(String stretch) {
        this.attributesMap.put("font-strech", stretch);
    }

    public String getStyle() {
        return this.attributesMap.get("font-style");
    }

    public void setStyle(String style) {
        this.attributesMap.put("font-style", style);
    }

    public String getVariant() {
        return this.attributesMap.get("font-variant");
    }

    public void setVariant(String variant) {
        this.attributesMap.put("font-variant", variant);
    }

    public String getWeight() {
        return this.attributesMap.get("font-weight");
    }

    public void setWeight(String weight) {
        this.attributesMap.put("font-weight", weight);
    }

}