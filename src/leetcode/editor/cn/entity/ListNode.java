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
}
