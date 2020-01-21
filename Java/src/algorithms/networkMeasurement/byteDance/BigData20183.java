package algorithms.networkMeasurement.byteDance;

import java.util.*;

/**
 * Created by thpffcj on 2020/1/17.
 *
 * 产品经理(PM)有很多好的idea，而这些idea需要程序员实现。现在有N个PM，在某个时间会想出一个 idea，每个 idea 有提出时间、所需时间和
 * 优先等级。对于一个PM来说，最想实现的idea首先考虑优先等级高的，相同的情况下优先所需时间最小的，还相同的情况下选择最早想出的，没
 * 有 PM 会在同一时刻提出两个 idea。
 * 同时有M个程序员，每个程序员空闲的时候就会查看每个PM尚未执行并且最想完成的一个idea,然后从中挑选出所需时间最小的一个idea独立实现，如
 * 果所需时间相同则选择PM序号最小的。直到完成了idea才会重复上述操作。如果有多个同时处于空闲状态的程序员，那么他们会依次进行查看idea的操作。
 * 求每个idea实现的时间。
 *
 * 输入第一行三个数N、M、P，分别表示有N个PM，M个程序员，P个idea。随后有P行，每行有4个数字，分别是PM序号、提出时间、优先等级和所需时间。
 * 输出P行，分别表示每个idea实现的时间点。
 *
 * 输入描述:
 * 输入第一行三个数N、M、P，分别表示有N个PM，M个程序员，P个idea。随后有P行，每行有4个数字，分别是PM序号、提出时间、优先等级和所需时间。
 * 全部数据范围 [1, 3000]。
 *
 * 输出描述:
 * 输出P行，分别表示每个idea实现的时间点。
 *
 * 输入例子1:
 * 2 2 5
 * 1 1 1 2
 * 1 2 1 1
 * 1 3 2 2
 * 2 1 1 2
 * 2 3 5 5
 *
 * 输出例子1:
 * 3
 * 4
 * 5
 * 3
 * 9
 */
public class BigData20183 {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt(), m = sc.nextInt(), p = sc.nextInt();

        List<IdeaTask> tasks = getTasks(p);
        PM[] pms = initPM(n, tasks);

        PriorityQueue<Programmer> losersPq = new PriorityQueue<>(Comparator.comparingInt(x -> x.nextWorkTime));
        for (int i = 0; i < m; i++) losersPq.offer(new Programmer(0));
        while (true) {
            Programmer loser = losersPq.poll();
            IdeaTask task = selectTask(pms, loser.nextWorkTime);
            if (task == null) break;
            task.endTime = Integer.max(task.raiseTime, loser.nextWorkTime) + task.timeCost;
            loser.nextWorkTime = task.endTime;
            losersPq.offer(loser);
        }
        for (IdeaTask task : tasks) {
            System.out.println(task.endTime);
        }
    }

    static class IdeaTask {
        int pmSeq;
        int raiseTime;
        int prio;
        int timeCost;
        int endTime;

        public IdeaTask(int pmSeq, int raiseTime, int prio, int timeCost) {
            this.pmSeq = pmSeq;
            this.raiseTime = raiseTime;
            this.prio = prio;
            this.timeCost = timeCost;
        }
    }

    static class PM {
        PriorityQueue<IdeaTask> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.raiseTime));

        //给定程序员开始工作的时间，找到这个PM最想完成的任务
        IdeaTask mostDesiredTask(int startTime) {
            PriorityQueue<IdeaTask> pq2 = new PriorityQueue<>((x, y) -> {
                if (x.prio != y.prio) return y.prio - x.prio;
                else {
                    if (x.timeCost != y.timeCost) return x.timeCost - y.timeCost;
                    else return x.raiseTime - y.raiseTime;
                }
            });
            while (pq.peek() != null && pq.peek().raiseTime <= startTime) {
                pq2.offer(pq.poll());
            }
            IdeaTask mostDesiredTask = (pq2.isEmpty()) ? pq.poll() : pq2.poll();
            while (!pq2.isEmpty()) {
                pq.offer(pq2.poll());
            }
            return mostDesiredTask;
        }
    }

    static class Programmer {
        int nextWorkTime; // 下次可以工作的时间

        public Programmer(int nextWorkTime) {
            this.nextWorkTime = nextWorkTime;
        }
    }

    // 从多个PM 最想要完成的Idea中，选其中的一个PM想要完成的idea
    private static IdeaTask selectTask(PM[] pms, int workTime) {
        PriorityQueue<IdeaTask> pq = new PriorityQueue<>((x, y) -> {
            if (x.raiseTime == y.raiseTime || (x.raiseTime <= workTime && y.raiseTime <= workTime)) {
                if (x.timeCost != y.timeCost) return x.timeCost - y.timeCost;
                else return x.pmSeq - y.pmSeq;
            }
            if (x.raiseTime > workTime && y.raiseTime > workTime) return x.raiseTime - y.raiseTime;
            if (x.raiseTime > workTime) return 1;
            if (y.raiseTime > workTime) return -1;
            return 0;
        });
        for (int i = 1; i < pms.length; i++) {
            PM pm = pms[i];
            IdeaTask desiredTask = pm.mostDesiredTask(workTime);
            if (desiredTask != null)
                pq.offer(desiredTask);
        }
        IdeaTask task = pq.poll();
        while (!pq.isEmpty()) {
            IdeaTask tmp = pq.poll();
            pms[tmp.pmSeq].pq.offer(tmp);
        }
        return task;
    }


    private static List<IdeaTask> getTasks(int taskNum) {
        List<IdeaTask> tasks = new LinkedList<>();
        while (taskNum > 0) {
            tasks.add(new IdeaTask(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
            taskNum--;
        }
        return tasks;
    }

    private static PM[] initPM(int n, List<IdeaTask> tasks) {
        PM[] pms = new PM[n + 1];
        for (int i = 1; i <= n; i++) pms[i] = new PM();
        for (IdeaTask task : tasks) {
            pms[task.pmSeq].pq.offer(task);
        }
        return pms;
    }
}
