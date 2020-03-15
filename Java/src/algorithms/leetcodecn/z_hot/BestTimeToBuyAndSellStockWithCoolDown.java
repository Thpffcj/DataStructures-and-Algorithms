package algorithms.leetcodecn.z_hot;

/**
 * Created by thpffcj on 2020/2/29.
 *
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * 示例:
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class BestTimeToBuyAndSellStockWithCoolDown {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 0) {
            return 0;
        }
        int sell = 0;
        int buy = -prices[0];
        int lastSell = 0;
        for (int i = 0; i < prices.length; i++) {
            int temp = sell;
            sell = Math.max(buy + prices[i], sell);
            buy = Math.max(lastSell - prices[i], buy);
            lastSell = temp;
        }
        return sell;
    }

    public int maxProfit2(int[] prices) {

        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(prices[1] - prices[0], 0);
        dp[1][1] = Math.max(-prices[0], -prices[1]);
        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 2][0] - prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }
}
