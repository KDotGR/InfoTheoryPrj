import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FR extends Latin{
    protected List<String> names;
    protected int nameCount;
    protected int namesSize;
    protected int[] charAppearance ;
    //List<String> asciiNames;
    
    FR(){
        names = new ArrayList<String>();
        //asciiNames = new ArrayList<>();
        charAppearance = new int[26];
        nameCount =0;
        namesSize = 0;
        
        for(int i=0; i<26; i++){
            charAppearance[i] = 0;
        }
    }
    
    //Διαβάζει το εκάστωτε αρχείο και αποθηκεύει τα ονόματα στην σωστή λίστα
    public void readFile(){
        try{        
            try (Scanner scanner = new Scanner(new File("files_for_info_theory_prj/FR_2.csv"))) {
                while(scanner.hasNext()){
                    names.add(scanner.nextLine());
                    nameCount++;
                }
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File was not found");
        }
    }
    
    //Για κάθε εμφάνιση κάθε γράμματος του Λατινικού αλφάβητου ενημερώνεται
    //η αντίστοιχη θέση του πίνακα
    private void updateArray(char c){
        
        int errors=0;
        switch (c) {
            
            case 'a':
                charAppearance[0]++;
                break;
            case 'b':
                charAppearance[1]++;
                break;
            case 'c':
                charAppearance[2]++;
                break;
            case 'd':
                charAppearance[3]++;
                break;
            case 'e':
                charAppearance[4]++;
                break;
            case 'f':
                charAppearance[5]++;
                break;
            case 'g':
                charAppearance[6]++;
                break;
            case 'h':
                charAppearance[7]++;
                break;
            case 'i':
                charAppearance[8]++;
                break;
            case 'j':
                charAppearance[9]++;
                break;
            case 'k':
                charAppearance[10]++;
                break;
            case 'l':
                charAppearance[11]++;
                break;
            case 'm':
                charAppearance[12]++;
                break;
            case 'n':
                charAppearance[13]++;
                break;
            case 'o':
                charAppearance[14]++;
                break;
            case 'p':
                charAppearance[15]++;
                break;
            case 'q':
                charAppearance[16]++;
                break;
            case 'r':
                charAppearance[17]++;
                break;
            case 's':
                charAppearance[18]++;
                break;
            case 't':
                charAppearance[19]++;
                break;
            case 'u':
                charAppearance[20]++;
                break;
            case 'v':
                charAppearance[21]++;
                break;
            case 'w':
                charAppearance[22]++;
                break;
            case 'x':
                charAppearance[23]++;
                break;
            case 'y':
                charAppearance[24]++;
                break;
            case 'z':
                charAppearance[25]++;
                break;
            default:
                errors++;
                break;
        }
    }
    
    private void convertToASCII() {
        
        for (String name : names) {
            StringBuilder asciiName = new StringBuilder();
            for (char c : name.toLowerCase().toCharArray()) {
                if (Character.isLetter(c)) {
                    asciiName.append((int) c);
                    updateArray(c);
                }
                else {
                    char symbol = InformationTheory.convertToEnglishSymbol(c);
                    asciiName.append((int) symbol);
                    updateArray(symbol);
                }
                namesSize++; //σε byte
            }
            //asciiNames.add(asciiName.toString());
        }
    }
    
    //Υπολογίζει την πιθανότητα κάθε γράμματος διαιρώντας τις εμφανίσεις του
    //με τον συνολικό αριθμό χαρακτήρων
    public void calcProbDistr(){
        double probability;
       for(int i=0; i<LatinAlphabet.length; i++){
           probability = charAppearance[i]/(double)namesSize;
           System.out.println(LatinAlphabet[i] + " = " +probability*100 + "%");
       }
    }
    
    //Υπολογίζει την εντροπία της πηγής 
    public void calcEntropy(){
    double entropy = 0.0;
    for (int i = 0; i < 26; i++) {
        double probability = (double) charAppearance[i] / namesSize;
        entropy -= probability * (Math.log(probability) / Math.log(2)); 
    }
    System.out.println("H(x) = " + entropy);
    }
    
    public void quest1p1(){
        convertToASCII(); //Αποθήκευση των δεδομένων σε Λίστα
        //Εκτύπωση αποτελεσμάτων
        System.out.println(namesSize + " Byte");
        System.out.println("or " + (double)(namesSize/1024)/1024 + " MB");
        System.out.println("in " + namesSize + " characters");
        System.out.println();
    }
}
