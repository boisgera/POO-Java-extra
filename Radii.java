import java.util.Map;

// Could split Geometry in XY, WH ... and inherit from XY here.

public class Radii extends Attributes {

    public Radii()
    {
        super();
    }

    public Radii(Attributes attributes)
    {
        super(attributes.filter("rx", "ry"));
    }

    public Radii(Map<String, String> attributesMap)
    {
        this(new Attributes(attributesMap));
    }

    public String getRx() {
        return this.attributesMap.get("rx");
    }

    public void setRx(String rx) {
        this.attributesMap.put("rx", rx);
    }

    public String getRy() {
        return this.attributesMap.get("ry");
    }

    public void setRy(String ry) {
        this.attributesMap.put("ry", ry);
    }

}