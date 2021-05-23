import java.util.Map;

public class SVGAttributes extends GeometryAttributes {

// Attributes
//
// baseProfile
//     The minimum SVG language profile that the document requires.
//     Value type: <string> ; Default value: none; Animatable: no
// contentScriptType
//     The default scripting language used by the SVG fragment.
//     Value type: <string> ; Default value: application/ecmascript; Animatable: no
// contentStyleType
//     The default style sheet language used by the SVG fragment.
//     Value type: <string> ; Default value: text/css; Animatable: no
// height
//     The displayed height of the rectangular viewport. (Not the height of its coordinate system.)
//     Value type: <length>|<percentage> ; Default value: auto; Animatable: yes
// preserveAspectRatio
//     How the svg fragment must be deformed if it is displayed with a different aspect ratio.
//     Value type: (none| xMinYMin| xMidYMin| xMaxYMin| xMinYMid| xMidYMid| xMaxYMid| xMinYMax| xMidYMax| xMaxYMax) (meet|slice)? ; Default value: xMidYMid meet; Animatable: yes
// version
//     Which version of SVG is used for the inner content of the element.
//     Value type: <number> ; Default value: none; Animatable: no
// viewBox
//     The SVG viewport coordinates for the current SVG fragment.
//     Value type: <list-of-numbers> ; Default value: none; Animatable: yes
// width
//     The displayed width of the rectangular viewport. (Not the width of its coordinate system.)
//     Value type: <length>|<percentage> ; Default value: auto; Animatable: yes
// x
//     The displayed x coordinate of the svg container. No effect on outermost svg elements.
//     Value type: <length>|<percentage> ; Default value: 0; Animatable: yes
// y
//     The displayed y coordinate of the svg container. No effect on outermost svg elements.
//     Value type: <length>|<percentage> ; Default value: 0; Animatable: yes 

    public SVGAttributes(Attributes attributes)
    {
        super(attributes);
        Attributes extraAttributes = attributes.filter(
            "baseProfile", 
            "contentScriptType", 
            "contentStyleType",
            "preserveAspectRatio",
            "version",
            "viewBox");
        this.update(extraAttributes);
    }

    public SVGAttributes(Map<String, String> attributesMap)
    {
        this(new Attributes(attributesMap));
    }

    public String getbaseProfile() {
        return this.attributesMap.get("baseProfile");
    }

    public void setbaseProfile(String baseProfile) {
        this.attributesMap.put("baseProfile", baseProfile);
    }

    public String getContentScriptType() {
        return this.attributesMap.get("contentScriptType");
    }

    public void setContentScriptType(String contentScriptType) {
        this.attributesMap.put("contentScriptType", contentScriptType);
    }

    public String getContentStyleType() {
        return this.attributesMap.get("contentStyleType");
    }

    public void setContentStyleType(String contentStyleType) {
        this.attributesMap.put("contentStyleType", contentStyleType);
    }

    public String getPreserveAspectRatio() {
        return this.attributesMap.get("preserveAspectRatio");
    }

    public void setPreserveAspectRatio(String preserveAspectRatio) {
        this.attributesMap.put("preserveAspectRatio", preserveAspectRatio);
    }

    public String getVersion() {
        return this.attributesMap.get("version");
    }

    public void setVersion(String version) {
        this.attributesMap.put("version", version);
    }

    public String getViewBox() {
        return this.attributesMap.get("viewBox");
    }

    public void setViewBox(String viewBox) {
        this.attributesMap.put("viewBox", viewBox);
    }

}