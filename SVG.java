// Reference: <https://developer.mozilla.org/en-US/docs/Web/SVG/Element/svg>

public class SVG extends Element {

    public SVG(SVGAttributes attributes, Node... children)
    {
        super("svg", attributes, children);
    }

    @Override
    public void setAttributes(Attributes attributes) {
        attributes = new SVGAttributes(attributes);
        super.setAttributes(attributes);
    }

}