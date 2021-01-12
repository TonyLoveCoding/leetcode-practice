package leetcode.editor.cn;

public class No494_TargetSum{

//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
//择一个符号添加在前面。 
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。 
//
// 
//
// 示例： 
//
// 输入：nums: [1, 1, 1, 1, 1], S: 3
//输出：5
//解释：
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
// 
//
// 
//
// 提示： 
//
// 
// 数组非空，且长度不会超过 20 。 
// 初始的数组的和不会超过 1000 。 
// 保证返回的最终结果能被 32 位整数存下。 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 518 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * dp[i][j] = 前i个数目标和为j的方案数
     * dp[i][j] = dp[i-1][j-num[i]] + dp[i-1][j+num[i]]
     */
    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        int absoluteSum = 0;
        for (int i = 0; i < n; i++) {
            absoluteSum += nums[i] > 0 ? nums[i] : -nums[i];
        }
        int max = 1000 + absoluteSum;
        int[][] dp = new int[n+1][2 * max + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = max - absoluteSum; j <= absoluteSum + max; j++) {
                if(i == 1){
                    if(nums[i-1] == j - max){
                        dp[i][j] ++;
//                        if(dp[i][j] != 0){
//                            System.out.println("dp[" + i + "][" + (j - max) + "]:" + dp[i][j]);
//                        }
                    }
                    if(nums[i-1] == -(j - max)){
                        dp[i][j] ++;
//                        if(dp[i][j] != 0){
//                            System.out.println("dp[" + i + "][" + (j - max) + "]:" + dp[i][j]);
//                        }
                    }
                } else{
                    dp[i][j] = dp[i-1][j - nums[i-1]] + dp[i-1][j + nums[i-1]];
//                    if(dp[i][j] != 0){
//                        System.out.println("dp[" + i + "][" + (j - max) + "]:" + dp[i][j]);
//                    }
                }
            }
//            System.out.println();
        }
        return S > 1000 ? 0  : dp[n][max + S];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new No494_TargetSum().new Solution();
    }
}