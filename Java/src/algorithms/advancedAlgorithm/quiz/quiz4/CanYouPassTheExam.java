package algorithms.advancedAlgorithm.quiz.quiz4;

/**
 * Created by thpffcj on 2019/11/21.
 */

import java.util.*;

/**
 * Description
 * 小张想要通过明天的考试。他知道考题的分值分布，也知道考试中要拿到每一个题目需要耗费的时间。假设考试时长为h，共n个题目，需要拿到p分才
 * 能通过考试。现在已知每个考题的得分与耗时，请你判断小张能否通过合理安排时间，而通过考试，并给出通过考试的最短时间。
 *
 * Input
 * 输入第一行为测试用例个数.每一个用例有若干行，第一行为任务数量n、考试时常h、通过分数p，下面的n行是每一个题目的耗时和得分。所有数值
 * 用空格分开。
 *
 * Output
 * 对每一个用例输出一行，如果能够通过考试，则输出“YES”和消耗最短时间，用空格隔开。 否则，输出“NO”。
 *
 * Sample Input 1
 * 1
 * 5 40 21
 * 12 10
 * 16 10
 * 20 10
 * 24 10
 * 8 3
 *
 * Sample Output 1
 * YES 36
 */
public class CanYouPassTheExam {

    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numbers = Integer.parseInt(sc.nextLine());

        while (numbers > 0) {
            list = new ArrayList<>();
            String[] infos = sc.nextLine().split(" ");
            int n = Integer.parseInt(infos[0]);
            int h = Integer.parseInt(infos[1]);
            int p = Integer.parseInt(infos[2]);

            int[] time = new int[n];
            int[] grade = new int[n];
            for (int i = 0; i < n; i++) {
                String[] line = sc.nextLine().split(" ");
                time[i] = Integer.parseInt(line[0]);
                grade[i] = Integer.parseInt(line[1]);
            }
            boolean[] visit = new boolean[n];
            getGrade(time, grade, visit, 0, 0, h, p);

            if (list.size() == 0) {
                System.out.println("NO");
            } else {
                Collections.sort(list);
                System.out.println("YES " + list.get(0));
            }

            numbers--;
        }
    }

    public static void getGrade(int[] time, int[] grade, boolean[] visit, int grades, int times, int timeLimit, int gradeLimit) {
        if (grades >= gradeLimit) {
            list.add(times);
        }

        for (int i = 0; i < time.length; i++) {
            if (!visit[i]) {
                if (time[i] + times <= timeLimit) {
                    visit[i] = true;
                    grades = grades + grade[i];
                    getGrade(time, grade, visit, grades, time[i] + times, timeLimit, gradeLimit);
                    visit[i] = false;
                    grades = grades - grade[i];
                }
            }
        }
    }
}
