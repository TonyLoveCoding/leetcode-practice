package leetcode.editor.cn;

public class No5_LongestPalindromicSubstring{

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3088 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * dp[i,j] = true/false i~j位的字串是/不是回文串
     * dp[i,j] = dp[i+1][j-1] && s[i] == s[j]
     *
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";
        for (int len = 0 ; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                if(len == 0){
                    dp[i][j] = true;
                } else if(len == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
                if(dp[i][j] && len + 1 > res.length()){
                    res = s.substring(i, i + len + 1);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new No5_LongestPalindromicSubstring().new Solution();
    }
}