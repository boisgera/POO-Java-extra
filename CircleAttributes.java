import java.util.Map;

public class CircleAttributes extends Attributes {


    public CircleAttributes(Attributes attributes)
    {
        super(attributes.filter("cx", "cy", "fr"));
    }

    public CircleAttributes(Map<String, String> attributesMap)
    {
        this(new Attributes(attributesMap));
    }

    public String getCx() {
        return this.attributesMap.get("cx");
    }

    public void setCx(String cx) {
        this.attributesMap.put("cx", cx);
    }

    public String getCy() {
        return this.attributesMap.get("cy");
    }

    public void setCy(String cy) {
        this.attributesMap.put("cy", cy);
    }

    public String getR() {
        return this.attributesMap.get("r");
    }

    public void setR(String r) {
        this.attributesMap.put("r", r);
    }



}