/*
        ΟΝΟΜΑΤΕΠΩΝΥΜΟ           ΑΜ
    ΔΗΜΗΤΡΗΣ ΚΑΡΑΓΕΩΡΓΟΣ      17071
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class InformationTheory {
    protected static File selectedFile;
    
    
    
    protected static List<String> FRnames;
    protected static int nameCountFR;
    protected static int FRnamesSize;
    protected static int[] FRcharAppearance ;
    
    protected static int errors;
    
    
    
    public static void main(String[] args) {
        
        FRnames = new ArrayList<String>();
        
        
        
        nameCountFR =0;
        FRnamesSize = 0;
        errors = 0;
        
        GB gb = new GB();
        FR fr = new FR();
        //--------------------------- Bήμα 1------------------------------------
        System.out.println("---------------- QUESTION 1 -------------------");
        System.out.println();
      
        System.out.println("||------- file: GB -------||");
        gb.readFile(); //διαβάζει το αρχείο GB
        System.out.println();
        
        System.out.println("---------- 1.1 ----------");
        gb.quest1p1();
        
        
        System.out.println("---------- 1.2 ----------");
        //Υπολογίζει και εκτυπώνει την κατανομή πιθανότητας
        gb.calcProbDistr();
        
        System.out.println();
        
        System.out.println("---------- 1.3 ----------");
        //Υπολογίζει και εκτυπώνει την εντροπία
        gb.calcEntropy();
        System.out.println();
        
        System.out.println("||------- file: FR -------||");
        fr.readFile(); //διαβάζει το αρχείο GB
        System.out.println();
        System.out.println("---------- 1.4 ----------");
        fr.quest1p1();
        System.out.println();
        
        System.out.println("---------- 1.5 ----------");
        //Υπολογίζει και εκτυπώνει την κατανομή πιθανότητας
        fr.calcProbDistr();
        System.out.println();
        
        System.out.println("---------- 1.6 ----------");
        //Υπολογίζει και εκτυπώνει την εντροπία
        fr.calcEntropy();
        System.out.println();
       
        
        //Εμφάνιση λαθών
        System.out.println(errors + " errors occured");
        
        
    }
    /*
     private static List<String> readCVCFile(String fileName) {
        List<String> names = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                names.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return names;
    }
*/
    

    //Αντικαθιστά τους μη αγγλικούς χαρακτήρες σε αγγλικούς
    public static char convertToEnglishSymbol(char c) {
        switch (c) {
            
            //Περιπτώσεις Γαλλικών
            case 'à':
                return 'a';
            case 'â':
                return 'a';
            case 'ä':
                return 'a';
            case 'æ':
                return 'a';
            case 'ç':
                return 'c';
            case 'è':
                return 'e';
            case 'é':
                return 'e';
            case 'ê':
                return 'e';
            case 'ë':
                return 'e';
            case 'î':
                return 'i';
            case 'ï':
                return 'i';
            case 'ô':
                return 'o';
            case 'œ':
                return 'o';
            case 'ù':
                return 'u';
            case 'û':
                return 'u';
            case 'ü':
                return 'u';
            
            //Περιπτώσεις Ισπανικών
            case 'á':
                return 'a';
            case 'í':
                return 'i';
            case 'ñ':
                return 'n';
            case 'ó':
                return 'o';
            case 'ú':
                return 'u';
                
            default:
                return c;
        }
    }
}
