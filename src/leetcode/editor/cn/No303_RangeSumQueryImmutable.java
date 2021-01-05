package leetcode.editor.cn;

public class No303_RangeSumQueryImmutable{

//给定一个整数数组 nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。 
//
// 
// 
// 实现 NumArray 类： 
//
// 
// NumArray(int[] nums) 使用数组 nums 初始化对象 
// int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 s
//um(nums[i], nums[i + 1], ... , nums[j])） 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["NumArray", "sumRange", "sumRange", "sumRange"]
//[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
//输出：
//[null, 1, -1, -3]
//
//解释：
//NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
//numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
//numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
//numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 0 <= i <= j < nums.length 
// 最多调用 104 次 sumRange 方法 
// 
// 
// 
// Related Topics 动态规划 
// 👍 219 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {
    int[] dp;
    int n;

    /**
     * dp[i] = 前i个元素的和
     * @param nums
     */
    public NumArray(int[] nums) {
        n = nums.length;
        if(n != 0){
            dp = new int[n];
            dp[0] = nums[0];
            for(int i = 1; i < n; i++){
                dp[i] = dp[i-1] + nums[i];
            }
        }
    }
    
    public int sumRange(int i, int j) {
        if(i == 0){
            return dp[j];
        }
        return dp[j] - dp[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        NumArray numArray = new No303_RangeSumQueryImmutable().new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));; // return 1
        System.out.println(numArray.sumRange(2, 5));; // return -1
        System.out.println(numArray.sumRange(0, 5));; // return -3
    }
}