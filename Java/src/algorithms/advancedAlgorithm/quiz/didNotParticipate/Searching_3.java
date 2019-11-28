package algorithms.advancedAlgorithm.quiz.didNotParticipate;

/**
 * Created by thpffcj on 2019/11/6.
 */

import java.util.Scanner;

/**
 * Description
 * They declared Sonam as bewafa. Although she is not, believe me! She asked a number of queries to people
 * regrading their position in a test. Now its your duty to remove her bewafa tag by answering simple
 * queries. All the students who give test can score from 1 to 10^18. Lower the marks, better the rank.
 * Now instead of directly telling the marks of student they have been assigned groups where marks are
 * distributed in continuous intervals, you have been given l(i) lowest mark of interval i and r(i) highest
 * marks in interval i. So marks distribution in that interval is given as l(i), l(i)+1, l(i)+2 . . . r(i)
 *
 * Now Sonam ask queries in which she gives rank of the student (x) and you have to tell marks obtained
 * by that student
 *
 * Note: rank1 is better than rank2 and rank2 is better than rank3 and so on and the first interval starts
 * from 1.
 * Constraints:1<=T<=50,1<=N<=10^5,1<=Q<=10^5,1<= l(i) < r(i) <=10^18,1<=x<=10^18
 *
 * Input
 * The first line of input contains an integer T, denoting the no of test cases. Then T test cases follow.
 * Each test case contains two space separated values N and Q denoting the no of groups and number of
 * queries asked respectively. The next line contains N group of two integers separated by space which
 * shows lowest marks in group i ie l(i) and highest marks in group i ie r(i) such that if i < j
 * then r(i) < l(j). The next lines contain Q space separated integers x, denoting rank of student.
 *
 * Output
 * For each query output marks obtain by student whose rank is x(1<=x<=10^18).
 *
 * Sample Input 1
 * 1
 * 3 3
 * 1 10 12 20 22 30
 * 5 15 25
 *
 * Sample Output 1
 * 5 16 27
 */
public class Searching_3 {

    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0){
            int n = s.nextInt();
            int q = s.nextInt();

            long[][] num = new long[n][2];
            long grp[] = new long[n];
            for(int i=0;i<n;i++){
                num[i][0] = s.nextLong();
                num[i][1] = s.nextLong();
                grp[i] = num[i][1]-num[i][0]+1;
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0;i<q;i++){
                long rank = s.nextLong();
                long marks = 0;
                int k = 0;
                while(true){
                    if(k<n && rank>grp[k]){
                        rank -= grp[k];
                        k++;
                    } else if(rank<=grp[k]){
                        marks = num[k][0]+rank-1;
                        sb.append(marks + " ");
                        break;
                    }
                    if(k==n){
                        marks = num[n-1][1] + rank;
                        sb.append(marks + " ");
                        break;
                    }
                }
            }
            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }
}
