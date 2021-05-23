import java.util.Map;

public class Stroke extends Attributes {

    public Stroke()
    {
        super();
    }

    public Stroke(Attributes attributes)
    {
        super(attributes.filter(
            "stroke",
            "stroke-dasharray",
            "stroke-dashoffset",
            "stroke-linecap",
            "stroke-linejoin",
            "stroke-miterlimit",
            "stroke-opacity",
            "stroke-width"));
    }

    public Stroke(Map<String, String> attributesMap)
    {
        this(new Attributes(attributesMap));
    }

    public String getColor() {
        return this.attributesMap.get("stroke");
    }

    public void setColor(String color) {
        this.attributesMap.put("stroke", color);
    }


    public String getDashArray() {
        return this.attributesMap.get("stroke-dasharray");
    }

    public void setDashArray(String dashArray) {
        this.attributesMap.put("stroke-dasharray", dashArray);
    }


    public String getDashOffset() {
        return this.attributesMap.get("stroke-dashoffset");
    }

    public void setDashOffset(String dashOffset) {
        this.attributesMap.put("stroke-dashoffset", dashOffset);
    }


    public String getLineCap() {
        return this.attributesMap.get("stroke-linecap");
    }

    public void setLineCap(String lineCap) {
        this.attributesMap.put("stroke-linecap", lineCap);
    }


    public String getLineJoin() {
        return this.attributesMap.get("stroke-linejoin");
    }

    public void setLineJoin(String lineJoin) {
        this.attributesMap.put("stroke-linejoin", lineJoin);
    }


    public String getMiterLimit() {
        return this.attributesMap.get("stroke-miterlimit");
    }

    public void setMiterLimit(String miterLimit) {
        this.attributesMap.put("stroke-miterlimit", miterLimit);
    }

    public String getOpacity() {
        return this.attributesMap.get("stroke-opacity");
    }

    public void setOpacity(String opacity) {
        this.attributesMap.put("stroke-opacity", opacity);
    }


    public String getWidth() {
        return this.attributesMap.get("width");
    }

    public void setWidth(String width) {
        this.attributesMap.put("width", width);
    }


} 