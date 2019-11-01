package algorithms.advancedAlgorithm.quiz.quiz3;

import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/31.
 */
public class SumTheLargestContinuousDescendingCharacter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());

        while (T>0){
            char[] s = scanner.nextLine().toCharArray();
            boolean[] ch = new boolean[26];
            for(int i = 0; i<s.length; i++)
                ch[s[i]-'A'] = true;
            String res = "";
            for(int i = 1; i<26; i++) {
                for(int j = 25; j>=0; j--) {
                    if(ch[j]) {
                        String temp = "";
                        temp+=(char)('A'+j);
                        for(int k = j-i; k>=0; k-=i) {
                            if(ch[k])
                                temp+=(char)('A'+k);
                            else
                                break;
                        }
                        if(temp.length()>res.length())
                            res = temp;
                    }
                }
            }
            System.out.println(res);
            T--;
        }
    }
}
