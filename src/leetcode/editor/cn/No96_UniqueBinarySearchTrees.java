package leetcode.editor.cn;

public class No96_UniqueBinarySearchTrees{

//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划 
// 👍 940 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * dp[i] 代表i个节点的不同搜索树个数
     *
     * i >= 2时，从小到大以每个元素j(1<=j<=i)作为搜索树的根，存在两种情况：
     * j==1||j==i，即没有左或右子树，则剩下子树组合数即为少一个元素的排列情况dp[i-1]
     * 1<j<i，则左右子树都不为空，则结构为左右子树的排列组合，其中左子树个数为j-1，右子树为i-j
     * @param n
     * @return dp[n]
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            int res = 0;
            for (int j = 1; j <= i; j++) {
                if(j == 1 || j == i){
                    res += dp[i - 1];
                } else{
                    res += dp[j - 1] * dp [i - j];
                }
            }
            dp[i] = res;
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new No96_UniqueBinarySearchTrees().new Solution();
        System.out.println(solution.numTrees(2));//return 2
        System.out.println(solution.numTrees(3));//return 5
        System.out.println(solution.numTrees(4));//return 14
    }
}