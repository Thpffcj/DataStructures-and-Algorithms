package algorithms.leetcodecn.heap;

import java.util.PriorityQueue;

/**
 * Created by thpffcj on 2020/2/11.
 *
 * 一个已排序好的表 primes，其包含 1 和其他一些素数.  当列表中的每一个 p<q 时，我们可以构造一个分数 p/q 。
 * 那么第 k 个最小的分数是多少呢?  以整数数组的形式返回你的答案, 这里 answer[0] = p 且 answer[1] = q.
 *
 * 示例:
 * 输入: primes = [1, 2, 3, 5], K = 3
 * 输出: [2, 5]
 * 解释:
 * 已构造好的分数,排序后如下所示:
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
 * 很明显第三个最小的分数是 2/5.
 *
 * 输入: primes = [1, 7], K = 1
 * 输出: [1, 7]
 *
 * 注意:
 * primes 的取值范围在 2 — 2000.
 * 每个 primes[i] 的值在 1 — 30000.
 * K 取值范围为 1 — primes.length * (primes.length - 1) / 2
 */
public class KThSmallestPrimeFraction {

    // 使用二分查找找出一个 x，使得小于 x 的分数恰好有 K 个，并且记录其中最大的一个分数。
    public int[] kthSmallestPrimeFraction(int[] primes, int K) {
        double lo = 0, hi = 1;
        int[] ans = new int[]{0, 1};

        while (hi - lo > 1e-9) {
            double mi = lo + (hi - lo) / 2.0;
            int[] res = under(mi, primes);
            if (res[0] < K) {
                lo = mi;
            } else {
                ans[0] = res[1];
                ans[1] = res[2];
                hi = mi;
            }
        }
        return ans;
    }

    // under(x) 函数有两个目的：返回小于 x 的分数数量以及小于 x 的最大分数
    public int[] under(double x, int[] primes) {
        int numer = 0, denom = 1, count = 0, i = -1;
        for (int j = 1; j < primes.length; j++) {
            // 对于每个j，找到最大的i，使primes [i] / primes [j] < x
            while (primes[i + 1] < primes[j] * x) {
                i++;
            }

            // There are i+1 fractions: (primes[0], primes[j]), (primes[1], primes[j]), ..., (primes[i], primes[j])
            count += i + 1;
            if (i >= 0 && numer * primes[j] < denom * primes[i]) {
                numer = primes[i];
                denom = primes[j];
            }
        }
        return new int[]{count, numer, denom};
    }

    // 使用一个堆记录所有以 primes[j] 为分母且未被弹出的最小分数。依次从堆中弹出 K-1 个元素，此时堆顶的分数就是结果
    // 使用记录 {i, j} （i 和 j 是索引，不是 primes 中的元素）的 int[2] 表示分数
    public int[] kthSmallestPrimeFraction2(int[] primes, int K) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> primes[a[0]] * primes[b[1]] - primes[a[1]] * primes[b[0]]);

        for (int i = 1; i < primes.length; i++) {
            pq.add(new int[]{0, i});
        }

        while (K-- > 0) {
            int[] frac = pq.poll();
            if (frac[0]++ < frac[1]) {
                pq.offer(frac);
            }
        }

        int[] ans = pq.poll();
        return new int[]{primes[ans[0]], primes[ans[1]]};
    }

    public static void main(String[] args) {
        KThSmallestPrimeFraction k = new KThSmallestPrimeFraction();
        int[] primes = new int[]{1, 2, 3, 5};
        k.kthSmallestPrimeFraction2(primes, 3);
    }
}
