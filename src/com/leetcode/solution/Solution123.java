package com.leetcode.solution;

/**
 * @Author : fanc
 * @Date : 2020/4/26 11:01 下午
 */
public class Solution123 {

//    一个方法团灭 6 道股票问题
//    dp[i][k][0 or 1] 在i天最多k次交易次数，1持有 0不持有
//    dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]) 不动，昨天持有，今天卖了, + prices[i]
//    dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]) 不动，昨天没有，今天买入, - prices[i]
//    初始条件即base case需要注意

    public int maxProfit(int[] prices) {
        int transNum = 2;
        int days = prices.length;
        if (days == 0) {
            return 0;
        }
        int[][][] dp = new int[days][transNum + 1][2];
        for (int i = 0; i < days; i++) {

            // j最好从大到小遍历，因为后面涉及到j - 1
            for (int j = transNum; j >= 1; j--) {
                if (i == 0) {
                    // 第一次不持有，需要研究一下状态方程
                    // dp[0][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
                    dp[i][j][0] = 0;

                    // 第一次持有
                    dp[i][j][1] = -prices[i];

                    continue;
                }
                // 不持有，之前不持有利润不变，之前持有卖掉，交易次数不变
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                // 持有，之前持有利润不变，之前不持有买入，之前必须不持有
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[days - 1][transNum][0];
    }
}
