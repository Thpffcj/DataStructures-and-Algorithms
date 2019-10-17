package algorithms.advancedAlgorithm.quiz.quiz2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/17.
 */

/**
 * 3
 * 3 2 4
 * 10 9 6
 * 450 768 517
 *
 * 1
 * 4
 * 34
 */
public class MathematicalFormula {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        for (int number = 0; number < numbers; number++) {
            String[] line = sc.nextLine().split(" ");

//            int a = Integer.parseInt(line[1]);
//            int b = Integer.parseInt(line[1]);
//            int c = Integer.parseInt(line[1]);

            BigInteger base = new BigInteger(line[0]);
            BigInteger exponent = new BigInteger(line[1]);
            BigInteger n = new BigInteger(line[2]);
            System.out.println(expMode(base, exponent, n));
        }
    }

    public static BigInteger expMode(BigInteger base, BigInteger exponent, BigInteger n){
        char[] binaryArray = new StringBuilder(exponent.toString(2)).reverse().toString().toCharArray() ;
        int r = binaryArray.length ;
        List<BigInteger> baseArray = new ArrayList<BigInteger>() ;

        BigInteger preBase = base ;
        baseArray.add(preBase);
        for(int i = 0 ; i < r - 1 ; i ++){
            BigInteger nextBase = preBase.multiply(preBase).mod(n) ;
            baseArray.add(nextBase) ;
            preBase = nextBase ;
        }
        BigInteger a_w_b = multi(baseArray.toArray(new BigInteger[baseArray.size()]), binaryArray) ;
        return a_w_b.mod(n) ;
    }


    private static BigInteger multi(BigInteger[] array, char[] bin_array){
        BigInteger result = BigInteger.ONE ;
        for(int index = 0 ; index < array.length ; index ++){
            BigInteger a = array[index] ;
            if(bin_array[index] == '0'){
                continue ;
            }
            result = result.multiply(a) ;
        }
        return result ;
    }
}
