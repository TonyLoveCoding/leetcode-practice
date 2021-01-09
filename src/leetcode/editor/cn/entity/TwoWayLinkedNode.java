package leetcode.editor.cn.entity;

public class TwoWayLinkedNode {
    /**
     * 值
     */
    public int value;

    /**
     * 键
     */
    public int key;

    public TwoWayLinkedNode prev;

    public TwoWayLinkedNode next;

    public TwoWayLinkedNode(int value, int key) {
        this(value, key, null, null);
    }

    public TwoWayLinkedNode(int value, int key, TwoWayLinkedNode prev, TwoWayLinkedNode next) {
        this.value = value;
        this.key = key;
        this.prev = prev;
        this.next = next;
    }

    public static void remove(TwoWayLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void addToHead(TwoWayLinkedNode fakeHead, TwoWayLinkedNode node){
        node.next = fakeHead.next;
        node.prev = fakeHead;

        fakeHead.next = node;
        node.next.prev = node;
    }

    public static void moveToHead(TwoWayLinkedNode fakeHead, TwoWayLinkedNode node){
        remove(node);
        addToHead(fakeHead, node);
    }

    public static TwoWayLinkedNode removeTail(TwoWayLinkedNode fakeTail){
        TwoWayLinkedNode node = fakeTail.prev;
        remove(node);
        return node;
    }
}
