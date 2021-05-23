public class Circle extends Element {

    // TODO: add geometry stuff. Generic and specific ? Read the documentation
    // for rect Element.

    public Circle(CircleAttributes attributes, Fill fill, Stroke stroke) { 
        super();
        this.name = "circle";
        /// and that is safe .... *except that attributes is public**.
        this.attributes = new Attributes(attributes, fill, stroke);
    }
}