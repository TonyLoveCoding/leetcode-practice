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
}
