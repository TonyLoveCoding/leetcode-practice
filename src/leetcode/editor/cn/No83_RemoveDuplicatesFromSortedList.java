package leetcode.editor.cn;

import leetcode.editor.cn.entity.ListNode;

public class No83_RemoveDuplicatesFromSortedList{

//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 463 👎 0

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
        ListNode p = head, result = null, q = null;
        while(p != null){
            if(result == null){
                result = p;
                q = result;
                p = p.next;
                q.next = null;
            } else{
                if(q.val != p.val){
                    q.next = p;
                    q = p;
                    p = p.next;
                    q.next = null;
                } else{
                    ListNode temp = p.next;
                    p.next = null;
                    p = temp;
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new No83_RemoveDuplicatesFromSortedList().new Solution();
        System.out.println(ListNode.nodeValue(solution.deleteDuplicates(ListNode.of(new int[]{1,1}))));
//        System.out.println(ListNode.nodeValue(solution.deleteDuplicates(ListNode.of(new int[]{1,1,2,3,3,3,3,3,3,3}))));
    }
}