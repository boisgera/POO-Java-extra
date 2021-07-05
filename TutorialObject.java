import static utils.Utils.*;

public class TutorialObject {

    public static void testInteger(){
        Integer a,b,c,d ; // Ajout d'une façon supplémentaire avec la variable 'd'

        /*
        a = new Integer(400);
        b = Integer.valueOf(400);
        c = 3 ;
        d = 3 ;
        */

        a = new Integer(400);
        b = Integer.valueOf(400);
        c = 400 ;
        d = 400 ;
        System.out.println("Test avec == :");
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(b==c);
        System.out.println(c==d);
        System.out.println("\nTests avec equals :");
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(b.equals(c));
        System.out.println(c.equals(d));
        System.out.print("\n Nombre d'octets dans un int : ");
        System.out.println(Integer.BYTES);
        System.out.println("\n Tests de comparaison : ");
        a = 4 ;
        System.out.print("\"4.compareTo(400)\" : ");
        System.out.println(a.compareTo(b));
        System.out.print("\"400.compareTo(4)\" : ");
        System.out.println(b.compareTo(a));
        System.out.print("\"4.compareTo(4)\" : ");
        System.out.println(a.compareTo(a));
    }

    public static void main(String[] args){
        testInteger();

    }
    
}
