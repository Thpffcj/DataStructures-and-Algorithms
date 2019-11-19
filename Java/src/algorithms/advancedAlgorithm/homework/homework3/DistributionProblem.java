package algorithms.advancedAlgorithm.homework.homework3;

/**
 * Created by thpffcj on 2019/11/18.
 */

import java.util.*;

/**
 * Description
 * 对给定的n个任务与n个人之间的成本矩阵完成成本最低的任务分配策略。
 *
 * Input
 * 输入：第一行为用例个数，之后为每一个用例；用例的第一行为任务个数，即n；用例的第二行为使用逗号隔开的人员完成任务的成本；
 * 每一个成本描述包括人员序号、任务序号和成本，使用空格隔开。人员序号和任务序号都是从1到n的整数，序号出现的次序没有固定规则。
 *
 * Output
 * 输出：每一个用例输出一行，从序号为1的人员开始，给出其分配的任务序号，使用空格隔开；使用逗号将多个解隔开。结果按照人员分配
 * 的任务序号大小排，第一个人员的任务序号大的放在前面，如果相同则看第二个人员的任务，以此类推。
 *
 * Sample Input 1
 * 1
 * 4
 * 2 1 6,1 2 2,1 3 7,1 4 8,1 1 9,2 2 4,2 3 3,2 4 7,3 1 5,3 2 8,3 3 1,3 4 8,4 1 7,4 2 6,4 3 9,4 4 4
 *
 * Sample Output 1
 * 2 1 3 4
 */
public class DistributionProblem {

    public static List<String> sequence = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());
        while (numbers > 0) {
            sequence = new ArrayList<>();
            int n = Integer.parseInt(sc.nextLine());
            String[] line = sc.nextLine().split(",");

            int[][] work = new int[n][n];
            for (int i = 0; i < line.length; i++) {
                String[] temp = line[i].split(" ");
                work[Integer.parseInt(temp[0]) - 1][Integer.parseInt(temp[1]) - 1] = Integer.parseInt(temp[2]);
            }
            boolean[] visit = new boolean[n];

            findSequence("", n, visit);

            int minCost = Integer.MAX_VALUE;
            List<String> result = new ArrayList<>();
            // TODO 矩阵是否可能有位置为0？不考虑也能通过测试用例，看来测试用例是每个人对每个任务都有成本
            for (int i = 0; i < sequence.size(); i++) {
                String s = sequence.get(i);
                String[] task = s.split(" ");
                int cost = 0;
                for (int j = 0; j < n; j++) {
                    cost += work[j][Integer.parseInt(task[j]) - 1];
                }
                if (cost < minCost) {
                    minCost = cost;
                    result = new ArrayList<>();
                    result.add(s);
                } else if (cost == minCost) {
                    result.add(s);
                }
            }

            Collections.sort(result);
            StringBuilder sb = new StringBuilder();
            for (int i = result.size() - 1; i >= 0; i--) {
                sb.append(result.get(i)).append(",");
            }

            System.out.println(sb.substring(0, sb.length() - 1));

            numbers--;
        }
    }

    public static void findSequence(String s, int n, boolean[] visit) {

        if (s.length() == 2 * n) {
            sequence.add(s.substring(0, s.length() - 1));
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i - 1]) {
                s = s + i + " ";
                visit[i - 1] = true;
                findSequence(s, n, visit);
                visit[i - 1] = false;
                s = s.substring(0, s.length() - 2);
            }
        }
    }
}
