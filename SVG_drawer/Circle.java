
/**
 * Write a description of class Circle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.lang.Math.*;

public class Circle extends Printable implements GeometricInformation
{
    // instance variables - replace the example below with your own
    private double x,y,radius ;
    private static int count = 0 ;

    /**
     * Constructor for objects of class Circle
     */
    Circle(double x, double y, double radius)
    {
        // initialise instance variables
        this.x = x ;
        this.y = y ;
        this.radius = radius;
        this.descr = String.format("Circle No %d",count);
        count ++ ;
    }

    public Circle makeCopy(){
        Circle circle = new Circle(x,y,radius);
        return circle ;
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
        // Does nothing.
    }
    
    public void scale(double scale){
        radius *= scale ;
    }
    
    
    public double getArea(){
        return Math.PI*radius*radius ;
    }
    
    public double getPerimeter(){
        return 2*Math.PI*radius;
    }
    
    public String getXml(){
        String xml = String.format("\n<circle cx = \"%.1f\" cy = \"%.1f\" r = \"%.1f\"/>",
        x ,y , radius);
        return xml ;
    
    }
    
}
