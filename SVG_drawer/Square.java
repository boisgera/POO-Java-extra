
/**
 * Write a description of class Square here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Square extends Printable implements GeometricInformation
{
    // instance variables - replace the example below with your own
    private double x,y,width,height,alpha ;
    private static int count = 0 ;

    /**
     * Constructor for objects of class Square
     */
    Square(double x, double y, double width, double height)
    {
        // initialise instance variables
        this.x = x ;
        this.y = y ;
        this.width = width ;
        this.height = height ;
        this.descr = String.format("Rectangle No %d",count);
        count ++ ;
    }
 
    public Square makeCopy(){
        Square square = new Square(x,y,width,height);
        square.alpha = this.alpha ;
        return square ;
    }
    
        /**
     * translate method
     *
     * @param  x,y  translation coordinates
     * @return      void
     */
    public void translate(double x, double y)
    {
        this.x += x ;
        this.y += y ;
    }
        
    /**
     * rotate method
     *
     * @param  alpha  add rotation
     * @return      void
     */
    public void rotate(double alpha)
    {
        this.alpha +=alpha ;
    }
     
    public void scale(double scale)
    {
        width *=scale ;
        height *= scale ;
    }
    
    public double getArea(){
        return width*height ;
    }
    
    public double getPerimeter(){
        return 2*(width+height);
    }
    
    public String getXml(){
        String xml = String.format("\n<rect transform=\"rotate(%.1f)\" x = \"%.1f\" y = \"%.1f\" height = \"%.1f\" width = \"%.1f\"/>",
        alpha ,x , y, height, width);
        return xml ;
    
    }
}
