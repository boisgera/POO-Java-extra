import java.util.Collections;
import java.util.ArrayList;


/**
 * Write a description of class Group here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public  class Group extends Printable
{
    // instance variables - replace the example below with your own
    private double x,y,alpha,scale;
    private ArrayList<Printable> elements ;
    private static int count = 0 ;

    /**
     * Constructor for objects of class Group
     */
    public Group()
    {
        // initialise instance variables
        x = 0;
        y = 0;
        alpha = 0 ;
        scale = 1 ;
        elements = new ArrayList<Printable>();
        this.descr = String.format("Group No %d",count);
        count ++ ;
    }

    public Group makeCopy(){
        Group group = new Group();
        group.x = this.x ;
        group.y = this.y ;
        group.alpha = this.alpha ;
        group.scale = this.scale ;
        for (int i=0;i<elements.size() ; i++){
            Printable current = elements.get(i).makeCopy() ;
            group.add(current);
        }
        return group ;
        
    }
    
    public void add(Printable toAdd){
        elements.add(toAdd);
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
    
    public void scale(double scale){
        this.scale *= scale ;
    }
    
    
    public String getXml(){
        String xml = String.format("\n<g transform=\"translate(%.1f,%.1f) rotate(%.1f) scale(%.1f)\">",x,y,alpha,scale);
    
        for (int i=0;i<elements.size() ; i++){
            //xml +="\n" ;
            xml += elements.get(i).getXml().replace("\n","\n\t") ;
        }
        xml += "\n</g>" ;
        return xml;
    
    }
    
    /* 
     * Overload of getDescr
     */
    public String getDescr(){
        String newDescr = descr ;
        newDescr += "\n" ;
        //newDescr +="-->";
        for(int i=0;i<elements.size() ; i++){
            newDescr += "\n" ;
            newDescr += elements.get(i).getDescr().replace("\n","\n|\t") ;
        }
        //newDescr +="\n<-- (end of ";
        //newDescr +=descr ;
        //newDescr += ")\n";
        newDescr+="\n";
        return newDescr ;
    }
}
