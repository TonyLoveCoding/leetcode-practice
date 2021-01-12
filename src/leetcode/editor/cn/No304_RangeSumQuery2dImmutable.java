package leetcode.editor.cn;

public class No304_RangeSumQuery2dImmutable{

//给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。 
//
// 
//上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。 
//
// 示例: 
//
// 给定 matrix = [
//  [3, 0, 1, 4, 2],
//  [5, 6, 3, 2, 1],
//  [1, 2, 0, 1, 5],
//  [4, 1, 0, 1, 7],
//  [1, 0, 3, 0, 5]
//]
//
//sumRegion(2, 1, 4, 3) -> 8
//sumRegion(1, 1, 2, 2) -> 11
//sumRegion(1, 2, 2, 4) -> 12
// 
//
// 说明: 
//
// 
// 你可以假设矩阵不可变。 
// 会多次调用 sumRegion 方法。 
// 你可以假设 row1 ≤ row2 且 col1 ≤ col2。 
// 
// Related Topics 动态规划 
// 👍 134 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {
    int[][] dp;
    int n;
    int m;
    public NumMatrix(int[][] matrix) {
        n=matrix.length;
        if(n != 0 && matrix[0] != null){
            m=matrix[0].length;
            dp=new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(i == 0 && j == 0){
                        dp[i][j] = matrix[i][j];
                    } else if (i == 0){
                        dp[i][j] = dp[i][j-1] + matrix[i][j];
                    } else if (j == 0){
                        dp[i][j] = dp[i-1][j] + matrix[i][j];
                    } else{
                        dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i][j];
                    }
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(n == 0||m == 0){
            return 0;
        }
        if(row1 == 0 && col1 == 0){
            return dp[row2][col2];
        }
        if(row1 == 0){
            return dp[row2][col2] - dp[row2][col1 - 1];
        }
        if(col1 == 0){
            return dp[row2][col2] - dp[row1 - 1][col2];
        }

        return dp[row2][col2] - dp[row1 - 1][col2] - dp[row2][col1 - 1] + dp[row1 - 1][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        NumMatrix solution = new No304_RangeSumQuery2dImmutable().new NumMatrix(null);
    }
}