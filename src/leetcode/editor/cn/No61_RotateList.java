package leetcode.editor.cn;

import leetcode.editor.cn.entity.ListNode;

public class No61_RotateList{

//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针 
// 👍 410 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode p = head;
        int n = 1;
        while(p.next != null){
            n++;
            p = p.next;
        }
        int t = k % n;
        if(t == 0) return head;
        ListNode end = p;
        p = head;
        for (int i = 0; i < t; i++) {
            p = p.next;
        }
        ListNode pre = head;
        while(p != end){
            pre = pre.next;
            p = p.next;
        }
        ListNode result = pre.next;
        p.next = head;
        pre.next = null;

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new No61_RotateList().new Solution();
        System.out.printf(ListNode.nodeValue(solution.rotateRight(ListNode.of(new int[]{1,2,3,4,5}), 0)));
    }
}