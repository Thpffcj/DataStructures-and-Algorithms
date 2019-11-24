package algorithms.advancedAlgorithm.quiz.didNotParticipate;

/**
 * Created by thpffcj on 2019/11/6.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description
 * Given n Magnets which are placed linearly, with each magnet to be considered as of point object. Each
 * magnet suffers force from its left sided magnets such that they repel it to the right and vice versa.
 * All forces are repulsive. The force being equal to the distance (1/d , d being the distance). Now
 * given the positions of the magnets, the task to find all the points along the linear line where net
 * force is ZERO.
 *
 * Note: Distance have to be calculated with precision of 0.0000000000001.
 * Constraints:1<=T<=100,1<=N<=100,1<=M[]<=1000
 *
 * Input
 * The first line of input contains an integer T denoting the no of test cases. Then T test cases follow.
 * The second line of each test case contains an integer N. Then in the next line are N space separated
 * values of the array M[], denoting the positions of the magnet.
 *
 * Output
 * For each test case in a new line print the space separated points having net force zero till precised
 * two decimal places.
 *
 * Sample Input 1
 * 2
 * 2
 * 1 2
 * 4
 * 0 10 20 30
 *
 * Sample Output 1
 * 1.50
 * 3.82 15.00 26.18
 */
public class Searching_4 {

    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numbers = Integer.parseInt(sc.nextLine());
        while (numbers > 0){
            list = new ArrayList<>();
            int n = Integer.parseInt(sc.nextLine());
            double[] digit = new double[n];
            String[] line = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                digit[i] = Double.parseDouble(line[i]);
            }

            for (int i = 0; i < n - 1; i++) {
                String s = findPosition(digit, digit[i], digit[i + 1]);
                list.add(s);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i)).append(" ");
            }

            System.out.println(sb.substring(0, sb.length() - 1));

            numbers--;
        }
    }

    public static String findPosition(double[] digit, double left, double right) {

        double mid = 0.0;
        while (left < right) {
            mid = (left + right) / 2.0;
            double temp = force(digit, mid);
            if (temp == 0) {
                return String.format("%.2f", mid);
            } else if (temp < 0) {
                left = mid + 0.0000000001;
            } else {
                right = mid - 0.0000000001;
            }
        }
        return String.format("%.2f", mid);
    }

    public static double force(double[] digit, double p) {

        double result = 0.0;
        for (int i = 0; i < digit.length; i++) {
            result += (1.0 / (digit[i] - p));
        }
        return result;
    }

//    public static double force(double arr[], double p) {
//        double ans = 0.0;
//        for (int i = 0; i < arr.length; i++) {
//            ans += (1 / (arr[i] - p));
//        }
//        return ans;
//    }
}
