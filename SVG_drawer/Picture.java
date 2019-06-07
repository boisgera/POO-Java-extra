
/**
 * Write a description of class Picture here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Picture
{
    // instance variables - replace the example below with your own
    protected static final String header= "xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" ";
    protected String descr ;
  

    /**
     * Constructor for objects of class Picture
     */
 
     /**
     * Method that builds the xml String associated to the object
     *
     * @param  none
     * @return the xml String
     * 
     * Need to be overriden by children
     */
    public abstract  String getXml() ;
    
    public String getDescr(){
        return descr ;
    }

    
}
