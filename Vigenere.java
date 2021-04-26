
/**
 * 
 * @author nicolaanghileri
 * @version 20.04.2021
 */
public class Vigenere{

    /**
     * 
     */
    private String text;

    /**
     * 
     */
    private String key;

    public Vigenere(String text, String key){
        this.text = text;
        this.key = key;
    }

    public void setText(String text){
        this.text = text.toUpperCase();
    }

    public void setkey(String key){
        this.key = key.toUpperCase();
    }

    public String getText(){
        return  this.text;
    }

    public String getKey(){
        return this.key;
    }

    /**
     * 
     */
    public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };


    /**
     * 
     * @param chars
     * @return
     */
    public static char[] shiftChar(char[] chars) {
        char[] output = new char[chars.length];
        for (int i = 0; i < chars.length - 1; i++) {
            output[i] = chars[i + 1];
        }
        output[chars.length - 1] = chars[0];
        return output;
    }

    /**
     * 
     * @return
     */
    public static char[][] setTable() {
        char[][] table = new char[26][26];
        char[] cop = ALPHABET;
        for (int i = 0; i < ALPHABET.length; i++) {
            for (int j = 0; j < ALPHABET.length; j++) {
                table[i][j] = cop[j];
            }
            cop = shiftChar(cop);
        }
        return table;
    }

    /**
     * 
     * @param value
     * @return
     */
    public static int getIndex(char value) {
        for (int i = 0; i < ALPHABET.length; i++) {
            if (ALPHABET[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 
     */
    public static String getFullKey(String key, int leng) {
        char[] chars = key.toCharArray();
        char[] newChars = new char[leng];
        for (int i = 0; i < leng; i++) {
            newChars[i] = chars[0];
            chars = shiftChar(chars);
        }
        return new String(newChars);
    }

    /**
     * 
     */
    public String getCypherChars() {
        char[] k = getFullKey(this.key, this.text.length()).toCharArray();
        char[] t = this.text.toCharArray();
        char[] output = new char[this.text.length()];
        char[][] table = setTable();
        for (int i = 0; i < this.text.length(); i++) {
            output[i] = table[getIndex(t[i])][getIndex(k[i])];
        }
        return new String(output);
    }

    public static String getClearChars(String text, String key){
        
        
        
        
        return "Ciao";
    }

    public static void main(String[] args) {
        /*
        char[][] prova = setTable();
        for (int i = 0; i < prova.length; i++) {
            for (int j = 0; j < prova.length; j++) {
                System.out.print(prova[i][j]);
            }
            System.out.println();
        }
        */
        Vigenere v = new Vigenere("RAPPORTOIMMEDIATO", "VERME");

        System.out.println(v.getCypherChars());
    }
}
