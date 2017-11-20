package algorithms.algorithmInterview.usingHashTable;

/**
 * Created by Thpffcj on 2017/11/18.
 */

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 *
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 */

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
       if (s.length() != t.length()) {
           return false;
       }
       int[] numbers = new int[26];
       for (int i = 0; i < s.length(); i++) {
           numbers[s.charAt(i) - 'a'] ++;
       }
       for (int i = 0; i < t.length(); i++) {
           numbers[t.charAt(i) - 'a'] --;
           if (numbers[t.charAt(i) - 'a'] < 0) {
               return false;
           }
       }
       return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        boolean result = validAnagram.isAnagram(s, t);
        System.out.println(result);
    }
}
