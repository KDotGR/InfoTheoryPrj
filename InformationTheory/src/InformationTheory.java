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
    protected static int nameCountGB;
    protected static int GBnamesSize;
    protected static int[] GBcharAppearance ;
    protected static int errors;
    protected static char[] LatinAlphabet;
    
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        GBcharAppearance = new int[26];
        initArray(GBcharAppearance.length);
        LatinAlphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //αρχικοποιεί τον πίνακα με τα γράμματα του αγγλικού αλφάβητου
        nameCountGB =0;
        GBnamesSize = 0;
        errors = 0;
        try{
            try (Scanner scanner = new Scanner(new File("files_for_info_theory_prj/GB_2.csv"))) {
                while(scanner.hasNext()){
                    names.add(scanner.nextLine());
                    nameCountGB++;
                }
            }
        }
        catch (FileNotFoundException e){
                e.printStackTrace();
                System.out.println("File was not found");
            }
        
        List<String> asciiNames = convertToASCII(names);
        //--------------------------- Bήμα 1------------------------------------
        System.out.println("---------------- QUESTION 1 -------------------");
        System.out.println();
        System.out.println("||------- file: GB -------||");
        System.out.println();
        System.out.println("---------- 1.1 ----------");
        System.out.println(GBnamesSize + " Byte");
        System.out.println("or " + (double)(GBnamesSize/1024)/1024 + " MB");
        System.out.println("in " + GBnamesSize + " characters");
        System.out.println();
        
        System.out.println("---------- 1.2 ----------");
        calcProbDistr();
        System.out.println();
        
        System.out.println("---------- 1.3 ----------");
        calcEntropy();
        System.out.println();
        
        System.out.println("||------- file: FR -------||");
        System.out.println();
        System.out.println("---------- 1.4 ----------");
        
        //Εμφάνιση λαθών
        System.out.println(errors + " errors occured");
        
        
    }
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

    private static List<String> convertToASCII(List<String> names) {
    List<String> asciiNames = new ArrayList<>();
    for (String name : names) {
        StringBuilder asciiName = new StringBuilder();
        for (char c : name.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                asciiName.append((int) c);
                updateArray(c);
            }
            else {
                char symbol = convertToEnglishSymbol(c);
                asciiName.append((int) symbol);
                updateArray(symbol);
            }
            
            GBnamesSize++; //σε byte
        }
        asciiNames.add(asciiName.toString());
    }
    return asciiNames;
}

    private static char convertToEnglishSymbol(char c) {
        // Replace non-English letters with their English equivalents
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
    
    //Αρχικοποιεί τον πίνακα με 0 σε όλα τα κελιά
    private static void initArray(int size){
        for(int i=0; i<size; i++){
            GBcharAppearance[i] = 0;
        }
    }
    
    //Για κάθε εμφάνιση κάθε γράμματος του Λατινικού αλφάβητου ενημερώνεται
    //η αντίστοιχη θέση του πίνακα
    private static void updateArray(char c){
        
        int errors=0;
        switch (c) {
            
            case 'a':
                GBcharAppearance[0]++;
                break;
            case 'b':
                GBcharAppearance[1]++;
                break;
            case 'c':
                GBcharAppearance[2]++;
                break;
            case 'd':
                GBcharAppearance[3]++;
                break;
            case 'e':
                GBcharAppearance[4]++;
                break;
            case 'f':
                GBcharAppearance[5]++;
                break;
            case 'g':
                GBcharAppearance[6]++;
                break;
            case 'h':
                GBcharAppearance[7]++;
                break;
            case 'i':
                GBcharAppearance[8]++;
                break;
            case 'j':
                GBcharAppearance[9]++;
                break;
            case 'k':
                GBcharAppearance[10]++;
                break;
            case 'l':
                GBcharAppearance[11]++;
                break;
            case 'm':
                GBcharAppearance[12]++;
                break;
            case 'n':
                GBcharAppearance[13]++;
                break;
            case 'o':
                GBcharAppearance[14]++;
                break;
            case 'p':
                GBcharAppearance[15]++;
                break;
            case 'q':
                GBcharAppearance[16]++;
                break;
            case 'r':
                GBcharAppearance[17]++;
                break;
            case 's':
                GBcharAppearance[18]++;
                break;
            case 't':
                GBcharAppearance[19]++;
                break;
            case 'u':
                GBcharAppearance[20]++;
                break;
            case 'v':
                GBcharAppearance[21]++;
                break;
            case 'w':
                GBcharAppearance[22]++;
                break;
            case 'x':
                GBcharAppearance[23]++;
                break;
            case 'y':
                GBcharAppearance[24]++;
                break;
            case 'z':
                GBcharAppearance[25]++;
                break;
            default:
                errors++;
                break;
        }
    }
    
    //Υπολογίζει την πιθανότητα κάθε γράμματος διαιρώντας τις εμφανίσεις του
    //με τον συνολικό αριθμό χαρακτήρων
    private static void calcProbDistr(){
        double probability;
       for(int i=0; i<LatinAlphabet.length; i++){
           probability = GBcharAppearance[i]/(double)GBnamesSize;
           System.out.println(LatinAlphabet[i] + " = " +probability*100 + "%");
       }
    }
    
    //Υπολογίζει την εντροπία της πηγής 
    private static void calcEntropy() {
    double entropy = 0.0;
    for (int i = 0; i < 26; i++) {
        double probability = (double) GBcharAppearance[i] / GBnamesSize;
        entropy -= probability * (Math.log(probability) / Math.log(2)); 
    }
    System.out.println("H(x) = " + entropy);
    }
}
