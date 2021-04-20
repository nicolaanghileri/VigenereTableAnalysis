/**
 * @author nicolaanghileri
 * @version 20.04.2021
 */
public class Vigenere{
    /**
     * 
     */
    public static final char[] ALPHABET = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    /**
     * 
     * @param chars
     * @return
     */
    public static char[] shiftChar(char[] chars){
        char[] output = new char[chars.length];
        for(int i = 0;i < chars.length - 1;i++){
            output[i] = chars[i + 1];
        }
        output[chars.length - 1] = chars[0];
        return output;
    }
    
    /**
     * 
     * @return
     */
    public static char[][] setTable(){
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

    public static int getIndex(char[] chars, char value){
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == value){
                return i + 1;
            }
        }
        return -1;
    }
    
    public static String getFullKey(String key, int leng){
        char[] chars = key.toCharArray();
        char[] newChars = new char[leng];
        for(int i = 0;i < leng;i++){
            newChars[i] = chars[0];
            chars = shiftChar(chars);
        }

        for (int i = 0; i < newChars.length - 1; i++) {
            System.out.print(chars[i]);
        }

        return newChars.toString();
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
        String text = "CIAOMICHIAMONICOLA";
        String chiave = "Verme";

        getFullKey(chiave,text.length());
        //System.out.println(getFullKey(chiave,text.length()));
        
    }
}