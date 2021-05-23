import java.util.Map;

public class Geometry extends Attributes {

// height
//     The displayed height of the rectangular viewport. (Not the height of its coordinate system.)
//     Value type: <length>|<percentage> ; Default value: auto; Animatable: yes
// width
//     The displayed width of the rectangular viewport. (Not the width of its coordinate system.)
//     Value type: <length>|<percentage> ; Default value: auto; Animatable: yes
// x
//     The displayed x coordinate of the svg container.
//     Value type: <length>|<percentage> ; Default value: 0; Animatable: yes
// y
//     The displayed y coordinate of the svg container.
//     Value type: <length>|<percentage> ; Default value: 0; Animatable: yes 

    // TODO: get rid of constructor arguments, use only getters and setters?
    // Or accept "containers" (maps ?) of attributes and check them.
    // Keys ? Filter or raise when foreign ? I'd say filter.
    // Check Values validity too ? *Ideally*, yes.
    // Via a static method.
    public Geometry()
    {
        super();
    }

    public Geometry(Attributes attributes)
    {
        super(attributes.filter("x", "y", "width", "height"));
    }

    public Geometry(Map<String, String> attributesMap)
    {
        this(new Attributes(attributesMap));
    }

    public String getHeight() {
        return this.attributesMap.get("height");
    }

    public void setHeight(String height) {
        this.attributesMap.put("height", height);
    }

    public String getWidth() {
        return this.attributesMap.get("width");
    }

    public void setWidth(String width) {
        this.attributesMap.put("width", width);
    }

    public String getX() {
        return this.attributesMap.get("x");
    }

    public void setX(String x) {
        this.attributesMap.put("x", x);
    }

    public String getY() {
        return this.attributesMap.get("y");
    }

    public void setY(String y) {
        this.attributesMap.put("y", y);
    }

}