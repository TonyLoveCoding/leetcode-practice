package leetcode.editor.cn.entity;

/**
 * 
 * @author yaotainan
 * @date 2021/1/15 11:23
 * @version 1.0
 **/
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public ListNode(int x, ListNode node) {val = x; next = node;}

    public static ListNode of(int[] num){
        if(num.length == 0) return null;
        ListNode head = new ListNode(num[0]), p = head;
        for(int i = 1; i < num.length; i++){
            ListNode temp = new ListNode(num[i]);
            p.next = temp;
            p = p.next;
        }
        return head;
    }

    public static String nodeValue(ListNode head){
        StringBuilder sb = new StringBuilder();
        while(head != null){
            sb.append(head.val).append(",");
            head = head.next;
        }
        return sb.toString();
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

    @Override
    public String toString() {
        return "val=" + val + ", next=" + next;
    }
}
