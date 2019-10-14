package algorithms.advancedAlgorithm.homework.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by thpffcj on 2019/10/13.
 */
public class FirstRiseAndThenFall2 {

    private static ArrayList<Integer> tmpArr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = Integer.parseInt(sc.nextLine().trim());
        while (nums > 0){
            String[] input = sc.nextLine().trim().split(" ");
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < input.length ; i++) {
                arrayList.add(Integer.parseInt(input[i]));
            }
            int max = 0;
            int index = 0;//记录划分两侧的位置
            int left = 0,right = 0;//两侧数列长度

            for(int i = 0; i < arrayList.size(); i++){
                ArrayList<Integer> arrayList1 = new ArrayList<>();
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for(int j = 0; j <=i; j++){
                    arrayList1.add(arrayList.get(j));
                }
                for(int j = arrayList.size()-1; j >= i;j--){
                    arrayList2.add(arrayList.get(j));
                }
                int left1 = LIS(arrayList1,arrayList1.size());
                int right1 = LIS(arrayList2, arrayList2.size());
                int len = left1+ right1  -1 ;
                if( len > max){
                    max  = len;
                    index = i;
                }
            }
            ArrayList<ArrayList<Integer>> real = new ArrayList<>();
            for(int h = index; h < arrayList.size();h++ ){
                ArrayList<Integer> leftArray = new ArrayList<>();
                ArrayList<Integer> rightArray = new ArrayList<>();
                ArrayList<Integer> arrayList1 = new ArrayList<>();
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for(int j = 0; j <=h; j++){
                    arrayList1.add(arrayList.get(j));
                }
                for(int j = arrayList.size()-1; j >= h;j--){
                    arrayList2.add(arrayList.get(j));
                }
                int left1 = LIS(arrayList1,arrayList1.size());
                int right1 = LIS(arrayList2, arrayList2.size());
                int len = left1+ right1  -1 ;
                if(len == max){
                    left = left1;
                    right =right1;
                    leftArray = arrayList1;
                    rightArray = arrayList2;
                    ArrayList<ArrayList<Integer>> arrayListsLeft = new ArrayList<>();
                    ArrayList<ArrayList<Integer>> arrayListsRight = new ArrayList<>();
                    combine(0,left,leftArray, arrayListsLeft);
                    combine(0,right,rightArray, arrayListsRight);

                    for(int i = 0; i< arrayListsLeft.size();i++){
                        for(int j = 0; j < arrayListsRight.size(); j++){
                            ArrayList<Integer> temp = new ArrayList<>();
                            for(int k = 0; k< left; k++){
                                temp.add(arrayListsLeft.get(i).get(k));
                            }
                            if(i == 0){
                                arrayListsRight.get(j).remove(right-1);}
                            for(int k = right-2; k >= 0;k--){
                                temp.add(arrayListsRight.get(j).get(k));
                            }
                            real.add(temp);
                        }
                    }
                }
            }
            Collections.sort(real, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    String a = ArrayToString(o1);
                    String b = ArrayToString(o2);
                    return a.compareTo(b);
                }
            });
            for(int i =0; i< real.size();i++){
                for (int j = 0; j < real.get(0).size() ; j++) {
                    if(j < real.get(0).size()-1){
                        System.out.print(real.get(i).get(j) + " ");}
                    else System.out.println(real.get(i).get(j));
                }
            }
            nums--;
        }
    }

    private static String ArrayToString(ArrayList<Integer> list){
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            buffer.append(list.get(i));
        }
        return buffer.toString();
    }

    private static int LIS(ArrayList<Integer> arrayList, int i){
        int[] record = new int[i];
        for(int j = 0; j < i; j++){
            record[j] = 1;
            for(int k = 0; k < j; k++ ){
                if(arrayList.get(k) < arrayList.get(j) && record[k] + 1 > record[j]){
                    record[j] = record[k] + 1;
                }
            }
        }
        return  MAX(record);
    }
    private static int MAX(int[] array){
        int max = array[0];
        for(int i = 0; i < array.length; i++){
            if(array[i] > max)
                max = array[i];
        }
        return max;
    }
    private static void combine(int index,int k,ArrayList<Integer> arr,ArrayList<ArrayList<Integer>> lists) {
        if(k == 1){
            for (int i = index; i < arr.size(); i++) {
                tmpArr.add(arr.get(i));
                ArrayList<Integer> arrayList = new ArrayList<>(tmpArr);
                if(isUp(arrayList)){
                    lists.add(arrayList);
                }
                tmpArr.remove((Object)arr.get(i));
            }
        }else if(k > 1){
            for (int i = index; i <= arr.size() - k; i++) {
                tmpArr.add(arr.get(i)); //tmpArr都是临时性存储一下
                combine(i + 1,k - 1, arr,lists); //索引右移，内部循环，自然排除已经选择的元素
                tmpArr.remove((Object)arr.get(i)); //tmpArr因为是临时存储的，上一个组合找出后就该释放空间，存储下一个元素继续拼接组合了
            }
        }else{
            return ;
        }
    }

    private static boolean isUp(ArrayList<Integer> arrayList){
        boolean flag = true;
        for (int i = 0; i < arrayList.size()-1 ; i++) {
            if(arrayList.get(i) > arrayList.get(i+1))
                return false;
        }
        return true;
    }
}

