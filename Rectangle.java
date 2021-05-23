public class Rectangle extends Element {

    // TODO: add geometry stuff. Generic and specific ? Read the documentation
    // for rect Element.

    public Rectangle(Geometry geometry, Radii radii, Fill fill, Stroke stroke) { 
        super();
        this.name = "rect";
        /// and that is safe .... *except that attributes is public**.
        this.attributes = new Attributes(geometry, radii, fill, stroke);
    }
}