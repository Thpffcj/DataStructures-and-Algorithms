package algorithms.advancedAlgorithm.quiz.quiz1;

/**
 * Created by thpffcj on 2019/9/26.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.*;
import java.util.Scanner;

/**
 * Given an array of integers, sort the array according to frequency of elements. For example,
 * if the input array is {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12}, then modify the array to
 * {3, 3, 3, 3, 2, 2, 2, 12, 12, 4, 5}. If frequencies of two elements are same, print them in increasing
 * order.
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SortByNumberOfValues {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t > 0) {
            int num1=s.nextInt();
            int[] A=new int[num1];
            for(int i=0;i<num1;i++){
                A[i]=s.nextInt();
            }
            Arrays.sort(A);
            num(A);
            for(int i=0;i<A.length-1;i++){
                System.out.print(A[i]+" ");
            }
            System.out.println(A[A.length-1]);
            t--;

        }

    }
    public static  void num(int arr[])
    {
        HashMap<Integer,Integer> map=new HashMap();
        for(int i=0;i<arr.length;i++) {
            if(map.get(arr[i])==null)
                map.put(arr[i],1 );
            else
                map.put(arr[i],map.get(arr[i])+1 );
        }
        int num[]=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            num[i]=map.get(arr[i]);
        }
        bubbleSort(num,arr);
    }
    public static void bubbleSort(int[] num,int []rank) {
        for (int e = num.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (num[i] <num[i + 1]) {
                    swap(num, i, i + 1);
                    swap(rank, i, i + 1);
                }
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
