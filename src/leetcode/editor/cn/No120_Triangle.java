package leetcode.editor.cn;

import java.util.List;

public class No120_Triangle{

//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -104 <= triangle[i][j] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
// Related Topics 数组 动态规划 
// 👍 670 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int res = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        if(n == 1){
            return dp[0][0];
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                int cur = triangle.get(i).get(j);
                if(j == 0){
                    dp[i][j] = cur + dp[i-1][j];
                } else if(j == i){
                    dp[i][j] = cur + dp[i-1][j-1];
                } else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + cur;
                }
                if(i == n-1){
                    res = Math.min(res, dp[i][j]);
                }
            }
        }
//        print(dp);
//        System.out.println(res);
        return res;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int res = Integer.MAX_VALUE;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp2[0] = triangle.get(0).get(0);
        if(n == 1){
            return dp2[0];
        }
        int[] line, pre;
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                int cur = triangle.get(i).get(j);
                if(i % 2 == 0){
                    line = dp2;
                    pre = dp1;
                } else{
                    line = dp1;
                    pre = dp2;
                }
                if(j == 0){
                    line[j] = cur + pre[j];
                } else if(j == i){
                    line[j] = cur + pre[j-1];
                } else{
                    line[j] = Math.min(pre[j], pre[j-1]) + cur;
                }
                if(i == n-1){
                    res = Math.min(res, line[j]);
                }
            }
        }
//        print(dp1);
//        print(dp2);
//        System.out.println(res);
        return res;
    }

    public void print(int[][] dp){
        for(int i = 0; i < dp.length; i++){
            for (int j = 0; j < i; j++) {
                System.out.printf(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void print(int[] dp){
        for(int i = 0; i < dp.length; i++){
            System.out.printf(dp[i] + " ");
        }
        System.out.println();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new No120_Triangle().new Solution();
    }
}