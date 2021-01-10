package leetcode.editor.cn;

import leetcode.editor.cn.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class No95_UniqueBinarySearchTreesIi{

//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。 
//
// 
//
// 示例： 
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 树 动态规划 
// 👍 745 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return this.generateTreesFromLeftToRight(1, n);
    }

    /**
     * 以left为最小值，right为最大值的搜索树集合
     * @param left
     * @param right
     * @return
     */
    public List<TreeNode> generateTreesFromLeftToRight(int left, int right){
        List<TreeNode> result = new ArrayList<>();
        if(left > right){
            return result;
        } else if(left == right){
            result.add(new TreeNode(left));
        } else{
            for (int i = left; i <= right; i++) {
                if(i == left){
                    result.addAll(this.generateTreeWithRoot(i, i + 1 , right));
                } else if(i == right){
                    result.addAll(this.generateTreeWithRoot(i, left, i - 1));
                } else{
                    result.addAll(this.generateTreeWithRoot(i, left, right));
                }
            }
        }
        return result;
    }

    /**
     * 以root为根植，left为最小值，right为最大的值的数集合
     * @param root
     * @param left
     * @param right
     * @return
     */
    public List<TreeNode> generateTreeWithRoot(int root, int left, int right){
        List<TreeNode> result = new ArrayList<>();
        if(root < left){
            List<TreeNode> rightChild = this.generateTreesFromLeftToRight(left, right);
            for(TreeNode treeNode : rightChild){
                result.add(new TreeNode(root, null, treeNode));
            }
        } else if(root > right){
            List<TreeNode> leftChild = this.generateTreesFromLeftToRight(left, right);
            for(TreeNode treeNode : leftChild){
                result.add(new TreeNode(root, treeNode, null));
            }
        } else{
            List<TreeNode> leftChild = this.generateTreesFromLeftToRight(left, root - 1);
            List<TreeNode> rightChild = this.generateTreesFromLeftToRight(root + 1, right);
            for(int i = 0; i < leftChild.size(); i++){
                for (int j = 0; j < rightChild.size(); j++) {
                    result.add(new TreeNode(root, leftChild.get(i), rightChild.get(j)));
                }
            }
        }
        return result;
    }

    public void printTree(List<TreeNode> treeList){
        for(TreeNode tree : treeList){
            List<Integer> treeNodeList = treeToArray(tree);
            System.out.println(treeNodeList.stream().map(treeNode -> treeNode == null ? "null" : String.valueOf(treeNode)).collect(Collectors.joining(",")));
        }
    }

    private List<Integer> treeToArray(TreeNode rootNode) {
        List<Integer> treeNodeList = new ArrayList<>();
        treeNodeList.add(rootNode.val);
        f(treeNodeList, rootNode);
        return treeNodeList;
    }

    private void f(List<Integer> result, TreeNode rootNode){
        if (rootNode == null){
            return ;
        }
        TreeNode left = rootNode.left;
        TreeNode right = rootNode.right;
        if(left != null || right != null){
            result.add(left == null ? null : left.val);
            result.add(right == null ? null : right.val);
        }
        f(result, rootNode.left);
        f(result, rootNode.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new No95_UniqueBinarySearchTreesIi().new Solution();
        solution.printTree(solution.generateTrees(3));
    }
}