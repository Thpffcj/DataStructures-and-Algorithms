package algorithms.algorithmInterview.usingArray;

/**
 * Created by Thpffcj on 2018/3/12.
 */

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 * Given s = "hello", return "holle".
 *
 * Example 2
 * Given s = "leetcode", return "leotcede".
 *
 * Note:
 * The vowels does not include the letter "y".
 */
public class ReverseVowelsOfString {

    public String reverseVowels(String s) {

        String vowel = "aAeEiIoOuU";
        char[] word = s.toCharArray();
        int i = 0;
        int j = word.length - 1;
        while (i < j) {
            while (!vowel.contains("" + word[i]) && i < j) {
                i++;
            }
            while (!vowel.contains("" + word[j]) && j > i) {
                j--;
            }
            if (i < j) {
                char temp = word[i];
                word[i] = word[j];
                word[j] = temp;
                i++;
                j--;
            }
        }
        return new String(word);
    }

    public static void main(String[] args) {
        ReverseVowelsOfString reverseVowelsOfString = new ReverseVowelsOfString();
        String result = reverseVowelsOfString.reverseVowels("hello");
        System.out.println(result);
    }
}
