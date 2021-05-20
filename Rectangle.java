public class Rectangle extends Element
{
    // Attributs
    private double x;
    private double y;
    private double rx;
    private double ry;
    private double height;
    private double width;

    public Rectangle(double x, double y, double height, double width, double rx, double ry, String style)
    {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.rx = rx;
        this.ry = ry;
        this.style = style;
    }
    
    public Rectangle()
    {
        this(0.0, 0.0, 1.0, 1.0, 0.0, 0.0, "");
    }
        
    public String toString()
    {
        return  "Rectangle("
                + x
                + ", "
                + y
                + ", "
                + height
                + ", "
                + rx
                + ","
                + ry 
                + ","
                + style + ")";
    }
    
    public String toXML()
    {
        return "<rect x=\""
                + x
                + "\" y=\""
                + y
                + "\" width=\""
                + width
                + "\" height=\""
                + height
                + "\" rx=\""
                + rx
                + "\" ry=\""
                + ry + "\" " 
                +  "style=\"" + style + "\" "
                + "/>";
    }
}
