import java.util.Locale;
/**
 * Write a description of class TestBench here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestBench
{
   static String test()
   {
       Locale.setDefault(Locale.US);
       Circle circle1 = new Circle(100,100, 10) ;
       Circle circle2 = circle1.makeCopy(); // Deep copy of cicle1
       circle2.translate(0,200); // We move independently circle2 with respect to circle1
       Square rect1   = new Square(1,1,100,100) ; // My squares are rectangle... WTF
       
       MainSheet sheet = new MainSheet(500,500);
       Group group1 = new Group() ;
       group1.add(circle1) ;
       group1.add(rect1) ;
       sheet.add(group1) ;
    
       Group group2 = group1.makeCopy();
       group2.translate(300,0);
       group2.rotate(45);
       group2.scale(1.8);
       sheet.add(group2);
       sheet.add(circle2);
       
       Group group3 = new Group();
       group3.add(group1);
       group3.add(group2); // Group3 will be affected by any change in group1/2
       group3.scale(0.2); // Will not affect group1/2
       group3.translate(120,50);// Will not affect group1/2
       sheet.add(group3);
       
       System.out.println("TEST1");
       System.out.println(sheet.getDescr()); // Gives the "tree" of the SVG elements in the terminal
       System.out.println("TEST2");
       System.out.println(sheet.getXml()); // Gives the XML to copy / paste in a blank svg file (TODO: file writer)
       return sheet.getXml();
       
       
   }
}
