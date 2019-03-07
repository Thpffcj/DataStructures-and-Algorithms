package algorithms.networkMeasurement.postgraduateRetest;

/**
 * Created by thpffcj on 2019-03-06.
 */

import java.util.Scanner;

/**
 * 题目描述
 * 查找和排序
 * 题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
 * 都按先录入排列在前的规则处理。
 *
 * 示例：
 * jack      70
 * peter     96
 * Tom       70
 * smith     67
 *
 * 从高到低  成绩
 * peter     96
 * jack      70
 * Tom       70
 * smith     67
 *
 * 从低到高
 * smith     67
 * jack      70
 * Tom      70
 * peter     96
 *
 * 输入描述:
 * 输入多行，先输入要排序的人的个数，然后输入排序方法0（降序）或者1（升序）再分别输入他们的名字和成绩，以一个空格隔开
 *
 * 输出描述:
 * 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
 *
 * 示例1
 * 输入
 * 3
 * 0
 * fang 90
 * yang 50
 * ning 70
 *
 * 输出
 * fang 90
 * ning 70
 * yang 50
 */
public class RankingOfGrades {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            int order = Integer.parseInt(sc.nextLine());
            String[] names = new String[n];
            int[] grades = new int[n];
            if (order == 0) {
                for (int i = 0; i < n; i++) {
                    String line = sc.nextLine();
                    String name = line.split(" ")[0];
                    int grade = Integer.parseInt(line.split(" ")[1]);
                    if (i == 0) {
                        names[0] = name;
                        grades[0] = grade;
                    }
                    for (int j = i - 1; j >= 0; j--) {
                        if (grade > grades[j]) {
                            grades[j + 1] = grades[j];
                            names[j + 1] = names[j];
                        } else {
                            grades[j + 1] = grade;
                            names[j + 1] = name;
                            break;
                        }
                        if (j == 0) {
                            grades[0] = grade;
                            names[0] = name;
                        }
                    }
                }
            } else {
                for (int i = 0; i < n; i++) {
                    String line = sc.nextLine();
                    String name = line.split(" ")[0];
                    int grade = Integer.parseInt(line.split(" ")[1]);
                    if (i == 0) {
                        names[0] = name;
                        grades[0] = grade;
                    }
                    for (int j = i - 1; j >= 0; j--) {
                        if (grade < grades[j]) {
                            grades[j + 1] = grades[j];
                            names[j + 1] = names[j];
                        } else {
                            grades[j + 1] = grade;
                            names[j + 1] = name;
                            break;
                        }
                        if (j == 0) {
                            grades[0] = grade;
                            names[0] = name;
                        }
                    }

                }
            }
            for (int i = 0; i < n; i++) {
                System.out.println(names[i] + " " + grades[i]);
            }
        }
    }
}
