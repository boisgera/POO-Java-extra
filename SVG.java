// Reference: <https://developer.mozilla.org/en-US/docs/Web/SVG/Element/svg>

public class SVG extends Element {

    public SVG(SVGAttributes attributes, Node... children)
    {
        super("svg", attributes, children);
    }
    
    public void write(String filename) {
        utils.Utils.write(filename, this.toXML());
    }

}