import javax.swing.JFrame;

/**
 * @author nicolaanghileri
 * @version 20.04.2021
 */
public class Vigenere extends JFrame {

    public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    public static char[] shiftChar(char[] chars) {
        char[] output = new char[chars.length];
        for (int i = 0; i < chars.length - 1; i++) {
            output[i] = chars[i + 1];
        }
        output[chars.length - 1] = chars[0];
        return output;
    }

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

    public static int getIndex(char value) {
        for (int i = 0; i < ALPHABET.length; i++) {
            if (ALPHABET[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static String getFullKey(String key, int leng) {
        char[] chars = key.toCharArray();
        char[] newChars = new char[leng];
        for (int i = 0; i < leng; i++) {
            newChars[i] = chars[0];
            chars = shiftChar(chars);
        }
        return new String(newChars);
    }

    public static String getCypherChars(String text, String key) {
        char[] k = getFullKey(key, text.length()).toCharArray();
        char[] t = text.toCharArray();
        char[] output = new char[text.length()];
        char[][] table = setTable();
        for (int i = 0; i < text.length(); i++) {
            output[i] = table[getIndex(t[i])][getIndex(k[i])];
        }
        return new String(output);
    }

    public static void main(String[] args) {
        char[][] prova = setTable();
        for (int i = 0; i < prova.length; i++) {
            for (int j = 0; j < prova.length; j++) {
                System.out.print(prova[i][j]);
            }
            System.out.println();
        }
        String text = "RAPPORTOIMMEDIATO";
        String chiave = "VERME";
        System.out.println(getFullKey(chiave, text.length()));
        System.out.println(getCypherChars(text, chiave));
    }
}
