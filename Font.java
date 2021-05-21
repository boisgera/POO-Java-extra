public class Font extends Attributes {

    public Font(
        String family,
        String size,
        String sizeAdjust,
        String stretch,
        String style,
        String variant,
        String weight
        )
    {
        this.attributes.put("font-family", family);
        this.attributes.put("font-size", size);
        this.attributes.put("font-size-adjust", sizeAdjust);
        this.attributes.put("font-stretch", stretch);
        this.attributes.put("font-style", style);
        this.attributes.put("font-variant", variant);
        this.attributes.put("font-weight", weight);
    }
    
}