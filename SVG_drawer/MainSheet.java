import java.util.ArrayList;

/**
 * Write a description of class MainSheet here.
 *
 * @author (Cyril JOLY)
 * @version (06/04/19)
 */
public class MainSheet extends Picture
{
    // instance variables - replace the example below with your own
    private int width;
    private int height;
    private ArrayList<Printable> elements ;



    /**
     * Constructor for objects of class MainSheet
     */
    public MainSheet(int width, int height)
    {
        // initialise instance variables
        this.width = width ;
        this.height = height ; 
        elements = new ArrayList<Printable>();
        descr = "This is a main sheet" ;

    }

    public void add(Printable toAdd){
        elements.add(toAdd);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
  
    public String getXml(){
        String xml = "<svg ";
        xml += Picture.header;
        xml += String.format("width=\"%d\" height=\"%d\">",width,height);
    
        for (int i=0;i<elements.size() ; i++){
            //xml +="\n\t";
            xml += elements.get(i).getXml().replace("\n","\n\t") ;
        }
        xml += "\n</svg>" ;
        return xml ;
    
    }

       public String getDescr(){
        String newDescr = descr ;
        newDescr += "\n" ;
        newDescr +="============";
        for(int i=0;i<elements.size() ; i++){
            newDescr += "\n* " ;
            newDescr += elements.get(i).getDescr().replace("\n","\n  |\t") ;
            newDescr += "\n" ;
        }
        return newDescr ;
    }
    
}
