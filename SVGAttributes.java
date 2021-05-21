public class SVGAttributes extends Attributes {

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

    public SVGAttributes(
        String baseProfile,
        String contentScriptType,
        String contentStyleType,
        String height,
        String preserveAspectRatio,
        String version,
        String viewBox,
        String width,
        String x,
        String y
    )
    {
        this.attributes.put("baseProfile", baseProfile);
        this.attributes.put("contentScriptType", contentScriptType);
        this.attributes.put("contentStyleType", contentStyleType);
        this.attributes.put("height", height);
        this.attributes.put("preserveAspectRatio", preserveAspectRatio);
        this.attributes.put("version", version);
        this.attributes.put("viewBox", viewBox);
        this.attributes.put("width", width);
        this.attributes.put("x", x);
        this.attributes.put("x", y);
    }
}