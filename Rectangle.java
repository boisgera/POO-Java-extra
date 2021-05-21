public class Rectangle extends Element {

    // TODO: add geometry stuff. Generic and specific ? Read the documentation
    // for rect Element.
    public Rectangle(Fill fill, Stroke stroke) { 
        super("rect", new Attributes(fill, stroke));
    }
}