package leetcode.editor.cn;

public class No221_MaximalSquare{

//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 动态规划 
// 👍 642 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        if(n == 1 || m == 1){
            for(int i = 0; i < n; i++ ) {
                for (int j = 0; j < m; j++) {
                    if(matrix[i][j] == '1'){
                        return 1;
                    }
                }
            }
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int result = 0;
        for(int i = 0; i < n; i++ ){
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == '0' ? 0 : 1;
                    result = Math.max(result, dp[i][j]);
                    continue;
                }
            }
        }
        for(int i = 1; i < n; i++ ){
            for (int j = 1; j < m; j++){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                result = Math.max(result, dp[i][j]);
            }
        }
        return result * result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new No221_MaximalSquare().new Solution();
    }
}