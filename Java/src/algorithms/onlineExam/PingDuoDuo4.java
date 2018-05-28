package algorithms.onlineExam;

import java.util.*;

/**
 * Created by Thpffcj on 2018/4/3.
 */

/**
 * 现在有一个整数数组A(长度为n)。有一个滑动窗口
 */
public class PingDuoDuo4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            String[] numbers = sc.nextLine().split(" ");

            ArrayList<Integer> max = new ArrayList<>();
            ArrayList<Integer> min = new ArrayList<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
            PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((o1, o2) -> o1 - o2);

            for (int i = 0; i < k; i++) {
                maxHeap.add(Integer.parseInt(numbers[i]));
            }
            max.add(maxHeap.peek());
            for (int i = 1; i + k - 1 < n; i++) {
                maxHeap.remove(Integer.parseInt(numbers[i - 1]));
                maxHeap.add(Integer.parseInt(numbers[i + k - 1]));
                max.add(maxHeap.peek());
            }

            for (int i = 0; i < k; i++) {
                minHeap.add(Integer.parseInt(numbers[i]));
            }
            min.add(minHeap.peek());
            for (int i = 1; i + k - 1 < n; i++) {
                minHeap.remove(Integer.parseInt(numbers[i - 1]));
                minHeap.add(Integer.parseInt(numbers[i + k - 1]));
                min.add(minHeap.peek());
            }

            for (int i = 0; i < n - k; i++) {
                System.out.print(max.get(i) - min.get(i) + " ");
            }
            System.out.println(max.get(n - k) - min.get(n - k));
        }
    }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String[] line = sc.nextLine().split(" ");
//            int n = Integer.parseInt(line[0]);
//            int k = Integer.parseInt(line[1]);
//            String[] numbers = sc.nextLine().split(" ");
//            for (int i = 0; i < n - k; i++) {
//                int max = Integer.MIN_VALUE;
//                int min = Integer.MAX_VALUE;
//                for (int j = 0; j < k; j++) {
//                    int num = Integer.parseInt(numbers[i + j]);
//                    if (num > max) {
//                        max = num;
//                    }
//                    if (num < min) {
//                        min = num;
//                    }
//                }
//                int res = max - min;
//                System.out.print(res + " ");
//            }
//
//            int max = Integer.MIN_VALUE;
//            int min = Integer.MAX_VALUE;
//            for (int i = n - k; i < n; i++) {
//                int num = Integer.parseInt(numbers[i]);
//                if (num > max) {
//                    max = num;
//                }
//                if (num < min) {
//                    min = num;
//                }
//            }
//            int res = max - min;
//            System.out.print(res);
//        }
//    }
}
