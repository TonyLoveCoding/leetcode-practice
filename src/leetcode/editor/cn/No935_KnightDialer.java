package leetcode.editor.cn;

public class No935_KnightDialer{

//国际象棋中的骑士可以按下图所示进行移动： 
//
// . 
//
// 
//这一次，我们将 “骑士” 放在电话拨号盘的任意数字键（如上图所示）上，接下来，骑士将会跳 N-1 步。每一步必须是从一个数字键跳到另一个数字键。 
//
// 每当它落在一个键上（包括骑士的初始位置），都会拨出键所对应的数字，总共按下 N 位数字。 
//
// 你能用这种方式拨出多少个不同的号码？ 
//
// 因为答案可能很大，所以输出答案模 10^9 + 7。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：1
//输出：10
// 
//
// 示例 2： 
//
// 输入：2
//输出：20
// 
//
// 示例 3： 
//
// 输入：3
//输出：46
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 5000 
// 
// Related Topics 动态规划 
// 👍 58 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * dp(start, n) = dp(x1, n-1) + ... dp(x2, n-1),  x = table[start]
     */
    int[][] table;
    int MOD = 1_000_000_007;

    public int knightDialer(int n) {
        table = new int[10][];
        table[0] = new int[]{4,6};
        table[1] = new int[]{6,8};
        table[2] = new int[]{7,9};
        table[3] = new int[]{4,8};
        table[4] = new int[]{3,9,0};
        table[5] = null;
        table[6] = new int[]{1,7,0};
        table[7] = new int[]{2,6};
        table[8] = new int[]{1,3};
        table[9] = new int[]{2,4};
        int[] dp1 = new int[10];
        int[] dp2 = new int[10];
        int[] cur = dp2;
        int[] pre = dp1;
        for (int i = 0; i < 10; i++) {
            dp2[i] = 1;
        }
        for(int i = 1; i < n; i++){
            if(i % 2 == 1){
                cur = dp1;
                pre = dp2;
            } else{
                cur = dp2;
                pre = dp1;
            }
            for (int j = 0; j < 10; j++) {
                cur[j] = deal(pre, j);
            }
        }
        long res = 0;
        for (int j = 0; j < 10; j++) {
            res += cur[j];
        }
        return (int)(res % MOD);
    }

    private int deal(int[] dp, int index){
        if(index == 5) return 0;
        int[] t = table[index];
        long res = 0;
        for(int i : t){
            res += dp[i];
        }
        return (int)(res % MOD);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new No935_KnightDialer().new Solution();
    }
}