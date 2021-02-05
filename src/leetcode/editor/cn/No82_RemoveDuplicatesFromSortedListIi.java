package leetcode.editor.cn;

import leetcode.editor.cn.entity.ListNode;

public class No82_RemoveDuplicatesFromSortedListIi{

//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 444 👎 0

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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = head, dummy = new ListNode(0), result = null, q = null, pre = dummy;
        int currentSame = Integer.MIN_VALUE;
        while(p != null){
            if(result == null){
                //初始化
                result = p;
                q = result;
                p = p.next;
                dummy.next = result;
                q.next = null;
                currentSame = q.val;
            } else{
                if(q.val != p.val && p.val != currentSame){
                    //不同的情况
                    pre = q;
                    q.next = p;
                    q = p;
                    p = p.next;
                    q.next = null;
                    currentSame = q.val;
                } else{
                    //相同的情况，则消除
                    if(q.val == p.val){
                        pre.next = null;
                        q = pre;
                        p = p.next;
                    } else{
                        ListNode temp = p.next;
                        p.next = null;
                        p = temp;
                    }
                }
            }
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new No82_RemoveDuplicatesFromSortedListIi().new Solution();
        System.out.println(ListNode.nodeValue(solution.deleteDuplicates(ListNode.of(new int[]{1,2,3,3,4,4,5}))));
        System.out.println(ListNode.nodeValue(solution.deleteDuplicates(ListNode.of(new int[]{1,1,1,2,3}))));
        System.out.println(ListNode.nodeValue(solution.deleteDuplicates(ListNode.of(new int[]{1,1}))));
        System.out.println(ListNode.nodeValue(solution.deleteDuplicates(ListNode.of(new int[]{0,0,0,0,0}))));
    }
}