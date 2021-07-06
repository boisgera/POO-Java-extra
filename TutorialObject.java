import static utils.Utils.*;
import java.util.*;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.Div;


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

    public static void testDouble(){
        Double inf = Double.POSITIVE_INFINITY;
        Double moinsInf = -1.0/0.0 ; 
        Double nan = Double.NaN ;
        Double nan2 = inf + moinsInf ;
        Double fini = 3.14 ;
        System.out.println("Résultats de testDouble : ");
        System.out. println("inf et moinsInf sont infinis ?");
        System.out.println(inf.isInfinite());
        System.out.println(moinsInf.isInfinite());
        System.out. println("fini, nan et nan2 sont infinis ?");
        System.out.println(fini.isInfinite());
        System.out.println(nan.isInfinite());
        System.out.println(nan2.isInfinite());
        System.out.println("nan et nan2 sont NaN ?");
        System.out.println(nan.isNaN());
        System.out.println(nan2.isNaN());
        System.out.println("fini et nan sont finis ?");
        System.out.println(Double.isFinite(fini)); // ATTENTION : seulement en méthode statique
        System.out.println(Double.isFinite(nan));
    }

    static void completeLetter(String name, boolean isFemale){
        String content = read("lettre.txt"); // contenu du fichier
        content = content.replace("$NOM$",name);
        if (isFemale){
            content = content.replace("$MADAME_MONSIEUR$","Madame");
            content = content.replace("$X$","se");
            content = content.replace("$E$","e");
        }else
        {
            // Version en une ligne
            content = content.replace("$MADAME_MONSIEUR$","Monsieur").replace("$X$","x").replace("$E$","");
        }
        write("lettre_finale.txt", content);
    }

    static void completeLetter(String filename,String name, boolean isFemale){
        // Surcharge de la version de base pour ne pas l'écraser...

        // Traitement du nom de fichier
        String basename,newFilename ;
        if (filename.toLowerCase().endsWith(".txt")){ // on utilise toLowerCase pour ne pas différenicer ".txt" et ".TXT"
            basename = filename.substring(0,filename.length()-4);
        }else{
            basename = filename ;
            filename = filename + ".txt";
        }
        newFilename = basename + "_" + name + ".txt";

        // Traitement de la lettre
        String content = read(filename); // contenu du fichier
        content = content.replace("$NOM$",name);
        if (isFemale){
            content = content.replace("$MADAME_MONSIEUR$","Madame");
            content = content.replace("$X$","se");
            content = content.replace("$E$","e");
        }else
        {
            // Version en une ligne
            content = content.replace("$MADAME_MONSIEUR$","Monsieur").replace("$X$","x").replace("$E$","");
        }
        write(newFilename, content);


    }

    public static void readDouble(Double x){
        String xString = x.toString();
        String[] tabSplit = xString.split("[.]|E");
        System.out.print("Partie entière : ");
        System.out.println(tabSplit[0]);
        System.out.print("Partie décimale : .");
        System.out.println(tabSplit[1]);
        if (tabSplit.length ==3){
            System.out.print("Puissance de 10 : ");
            System.out.println(tabSplit[2]);
        }

    }

    public static void readDouble(Double x,int size){
        String xString = x.toString();
        String[] tabSplit = xString.split("[.]|E");
        System.out.print("Partie entière : ");
        System.out.println(tabSplit[0]);
        System.out.print("Partie décimale : .");
        String decPart = tabSplit[1];
        if (size>decPart.length()){
            // On ajoute des zéros
            decPart += "0".repeat(size - decPart.length());
        }else if(size >0){
            // size est plus petit que la longueur de decPart mais plus grand que 0. On coupe.
            // Éventuellement, on peut se retrouver avec la même longueur exactement.
            decPart = decPart.substring(0,size);
        }
        // Sinon, decPart ne sera pas modifié.

        System.out.println(decPart);
        if (tabSplit.length ==3){
            System.out.print("Puissance de 10 : ");
            System.out.println(tabSplit[2]);
        }

    }

    public static List<Integer> listDiv(int N){
        if (N<0){
            N = -N ; // On ne cherche que les diviseurs positifs
        }
        List<Integer> listDiv = new ArrayList<Integer>();
        if (N != 0){
            listDiv.add(N);
        }
        
        for (int i = N/2 ; i>=1 ; i--){
            if (N%i == 0){
                listDiv.add(i);
            }
        }
        return listDiv ;
    }

    public static Map<Integer,Integer> listDivMap(int N){
        if (N<0){
            N = -N ; // On ne cherche que les diviseurs positifs
        }
        Map<Integer,Integer> listDiv = new TreeMap<Integer,Integer>(); // TreeMap permet d'avoir des clés ordonnées
        //Map<Integer,Integer> listDiv = new TreeMap<Integer,Integer>(Collections.reverseOrder()); // Pour des clés ordonnées en sens inverse
        if (N != 0){
            listDiv.put(N,1);
            listDiv.put(1,1); 
        }
        
        for (int i = N/2 ; i>1 ; i--){
            if (N%i == 0){
                // Trouver l'ordre de multiplicité
                int j = i*i ;
                int m = 1 ;
                while(N%j == 0){
                    m = m+1 ;
                    j*=i;
                }
                listDiv.put(i,m);
            }
        }
        return listDiv ;
    }
    public static void isInside(Integer intToTest, Map<Integer,Integer> map){
        if(map.containsKey(intToTest)){
            System.out.print(intToTest);
            System.out.print(" est diviseur de multiplicité ");
            System.out.println(map.get(intToTest));
        }else{
            System.out.print(intToTest);
            System.out.println(" n'est pas diviseur");
        }
    }
    public static void printDiv(Map<Integer,Integer> map){
        System.out.print("Nombre de diviseurs : ");
        System.out.println(map.size());
        for (Integer i : map.keySet()){
            System.out.print("  Le diviseur ");
            System.out.print(i);
            System.out.print(" est de multiplicité ");
            System.out.println(map.get(i));

        }
    }


    public static void main(String[] args){
        //testInteger();
        //testDouble();
        completeLetter("Java",true);
        //completeLetter("Java",false);
        completeLetter("lettre.txt", "Java",true);
        completeLetter("lettre", "Poo", false);
        System.out.println("Tests ReadDouble");
        readDouble(3.14);
        System.out.println("\n"); // Pour avoir un saut de ligne après
        readDouble(1_234_567_890d);
        System.out.println("\n"); // Pour avoir un saut de ligne après

        // Test readDouble avec size
        System.out.println("Test readDouble avec paramètre size");
        readDouble(3.,-2);        
        System.out.println("\n"); // Pour avoir un saut de ligne après

        readDouble(3.,2);
        System.out.println("\n"); // Pour avoir un saut de ligne après

        readDouble(3.14159,4);
        System.out.println("\n"); // Pour avoir un saut de ligne après

        readDouble(1./3.,1);
        System.out.println("\n"); // Pour avoir un saut de ligne après

        readDouble(1.4564e15,10);
        System.out.println("\n"); // Pour avoir un saut de ligne après

        // Partie Liste
        System.out.println("Test Liste");
        List<Integer> div16 = listDiv(16);
        System.out.print("Nombre de diviseurs de 16 : ");
        System.out.println(div16.size());
        System.out.print("Liste des diviseurs de 16: ");
        System.out.println(div16);

        // Partie Map
        System.out.println("\nTest Map");
        Map<Integer,Integer> div8 = listDivMap(8);
        isInside(4,div8);
        isInside(2,div8);
        isInside(9,div8);
        printDiv(div8);
        System.out.println("Test Map avec 16 : ");
        printDiv(listDivMap(16));
        System.out.println("Test Map avec -42 : ");
        printDiv(listDivMap(-42));

   }
    
    
}
