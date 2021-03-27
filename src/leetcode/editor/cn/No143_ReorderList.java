package leetcode.editor.cn;

import leetcode.editor.cn.entity.ListNode;

public class No143_ReorderList{

//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 512 👎 0

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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode p = head, mid = getMidNode(head), revertTail = mid.next, q = null;
        mid.next = null;
        ListNode revertHead = revert(revertTail);
        q = revertHead;
        boolean isFirst = false;
        while(p != null){
            if(isFirst || q == null){
                p = p.next;
            } else{
                ListNode firstNext = p.next;
                ListNode next = getHeadNode(q);
                q.next = firstNext;
                p.next = q;
                q = next;
                p = p.next;
            }
            isFirst = !isFirst;
        }
    }

    public ListNode getMidNode(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode revert(ListNode revertTail){
        if(revertTail == null || revertTail.next == null) return revertTail;
        ListNode p = revertTail, pre = null;
        while(p.next != null){
            ListNode temp = p.next;
            p.next = pre;
            pre = p;
            p = temp;
        }
        p.next = pre;
        return p;
    }

    public ListNode getHeadNode(ListNode head){
        ListNode temp = head.next;
        head.next = null;
        return temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new No143_ReorderList().new Solution();
        ListNode case1 = ListNode.of(new int[]{1,2,3,4,5});
        ListNode case2 = ListNode.of(new int[]{1,2,3,4});
        solution.reorderList(case1);
        solution.reorderList(case2);
        System.out.println(ListNode.nodeValue(case1));
        System.out.println(ListNode.nodeValue(case2));
    }
}