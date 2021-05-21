import java.util.List;

// Reference: <https://developer.mozilla.org/en-US/docs/Web/SVG/Element/svg>

public class SVG extends Element {

// version="1.1"
//      baseProfile="full"
//      xmlns="http://www.w3.org/2000/svg">

    public SVG(SVGAttributes attributes, Node... children)
    {
        super("svg", attributes, children);
    }
    
    public void write(String filename) {
        utils.Utils.write(filename, this.toXML());
    }

}