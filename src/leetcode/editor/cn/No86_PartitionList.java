package leetcode.editor.cn;

import leetcode.editor.cn.entity.ListNode;

public class No86_PartitionList{

//给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例： 
//
// 
//输入：head = 1->4->3->2->5->2, x = 3
//输出：1->2->2->4->3->5
// 
// Related Topics 链表 双指针 
// 👍 360 👎 0

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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode maxHead = null, p = head, q = null, pre = dummy;
        while(p != null){
            if(p.val >= x){
                ListNode tempNext = p.next;
                pre.next = tempNext;
                if(maxHead == null){
                    maxHead = p;
                    q = p;
                } else{
                    q.next = p;
                    q = q.next;
                }
                p.next = null;
                p = tempNext;
            } else{
                p = p.next;
                pre = pre.next;
            }
        }
        pre.next = maxHead;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new No86_PartitionList().new Solution();
        System.out.println(ListNode.nodeValue(solution.partition(ListNode.of(new int[]{2,1}), 2)));
        System.out.println(ListNode.nodeValue(solution.partition(ListNode.of(new int[]{1,4,3,2,5,2}), 3)));
    }
}