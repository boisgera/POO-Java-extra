import java.util.Map;

public class Fill extends Attributes {

    public Fill()
    {
        super();
    }

    public Fill(Attributes attributes)
    {
        super(attributes.filter("fill", "fill-opacity", "fill-rule"));
    }

    public Fill(Map<String, String> attributesMap)
    {
        this(new Attributes(attributesMap));
    }

    public String getColor() {
        return this.attributesMap.get("fill");
    }

    public void setColor(String color) {
        this.attributesMap.put("fill", color);
    }

    public String getOpacity() {
        return this.attributesMap.get("fill-opacity");
    }

    public void setOpacity(String opacity) {
        this.attributesMap.put("fill-opacity", opacity);
    }

    public String getRule() {
        return this.attributesMap.get("fill-rule");
    }

    public void setRule(String rule) {
        this.attributesMap.put("fill-rule", rule);
    }



}