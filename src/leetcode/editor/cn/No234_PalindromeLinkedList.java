package leetcode.editor.cn;

import leetcode.editor.cn.entity.ListNode;

public class No234_PalindromeLinkedList{

//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 819 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        if(head.next == null) return true;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
//        System.out.println(slow.val);
//        System.out.println(fast == null ? "null" : fast.val);
        if(slow.next == fast){
            return slow.val == fast.val;
        }
        ListNode mid = slow;
        ListNode left = fast == null ? this.last(head, mid) : mid;
        ListNode right = slow.next;
        while(right != null){
            if(left.val != right.val){
                return false;
            }
            left = this.last(head, left);
            right = right.next;
        }
        return true;
    }

    public ListNode last(ListNode head, ListNode current){
        if(current == null) return null;
        ListNode temp = head;
        while(temp != null && temp.next != current) temp = temp.next;
        return temp;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new No234_PalindromeLinkedList().new Solution();
//        solution.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        int[] input = new int[]{1,2,3,4,3,2,1};
        ListNode head = null, current = null;
        for (int i = 0; i < input.length; i ++) {
            ListNode temp = new ListNode(input[i]);
            if (current == null){
                current = temp;
                head = current;
            } else{
                current.next = temp;
                current = current.next;
            }
        }
        System.out.println(solution.isPalindrome(head));;
    }
}