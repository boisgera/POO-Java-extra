public class Rectangle extends Element {

    public Rectangle(RectangleAttributes attributes) { 
        super("rect", attributes);
        this.children = null;
    }

    @Override
    public void setAttributes(Attributes attributes) {
        attributes = new RectangleAttributes(attributes);
        super.setAttributes(attributes);
    }

}