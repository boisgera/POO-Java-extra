public class Circle extends Element {

    public Circle(CircleAttributes attributes) { 
        super("circle", attributes);
        this.children = null;
    }

    @Override
    public void setAttributes(Attributes attributes) {
        attributes = new CircleAttributes(attributes);
        super.setAttributes(attributes);
    }

}