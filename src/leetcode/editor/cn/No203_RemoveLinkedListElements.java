package leetcode.editor.cn;

import leetcode.editor.cn.entity.ListNode;

public class No203_RemoveLinkedListElements{

//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 524 👎 0

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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0), pre = dummy, cur = head;
        dummy.next = head;
        while(cur != null){
            if(cur.val == val){
                ListNode temp = cur.next;
                pre.next = temp;
                cur.next = null;
                cur = temp;
            } else{
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new No203_RemoveLinkedListElements().new Solution();
        System.out.println(ListNode.nodeValue(solution.removeElements(ListNode.of(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6,3,4,5,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6}), 6)));
    }
}