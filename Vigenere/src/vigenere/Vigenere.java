/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenere;
/**
 * 
 * @author nicolaanghileri
 * @version 20.04.2021
 */
public class Vigenere {

    /**
     * 
     */
    private String text;

    /**
     * 
     */
    private String key;

    /**
     * 
     * @param text
     * @param key
     */
    public Vigenere(String text, String key) {
        this.text = text;
        this.key = key;
    }

    /**
     * 
     * @param text
     */
    public void setText(String text) {
        this.text = text.toUpperCase();
    }

    /**
     * 
     * @param key
     */
    public void setkey(String key) {
        this.key = key.toUpperCase();
    }

    /**
     * 
     * @return
     */
    public String getText() {
        return this.text;
    }

    /**
     * 
     * @return
     */
    public String getKey() {
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
    public String getFullKey() {
        char[] chars = this.key.toCharArray();
        char[] newChars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            newChars[i] = chars[0];
            chars = shiftChar(chars);
        }
        return new String(newChars);
    }

     /**
      * 
      * @param key
      * @return 
      */
    public String getFullKey(String key) {
        char[] chars = key.toCharArray();
        char[] newChars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            newChars[i] = chars[0];
            chars = shiftChar(chars);
        }
        return new String(newChars);
    }

    /**
     * s
     * @return 
     */
    public String getCypherChars() {//encript
        char[] k = getFullKey().toCharArray();
        char[] t = this.text.toCharArray();
        char[] output = new char[this.text.length()];
        char[][] table = setTable();
        for (int i = 0; i < this.text.length(); i++) {
            output[i] = table[getIndex(t[i])][getIndex(k[i])];
        }
        return new String(output);
    }

    /**
     * 
     * @param cypher
     * @param key
     * @return 
     */
    public String getClearChars(String cypher, String key) {//decript
        char[] clear = new char[cypher.length()];
        char[] ky = getFullKey(key).toCharArray();
        char[] txt = cypher.toCharArray();
    
        for (int i = 0; i < ky.length; i++) {
            int calc = getIndex(txt[i]) - getIndex(ky[i]);
            if(calc >= 0){
                clear[i] = ALPHABET[calc];
            }else{
                clear[i] = ALPHABET[calc+=26];
            }
        }
        return new String(clear);
    }
    
    public static void main(String[] args) {
        Vigenere vg = new Vigenere("RAPPORTOIMMEDIATO", "VERME");
        System.out.println("OUT" + vg.getClearChars("MEGBSMXFUQHIUUEOS","VERME"));
    }
}
