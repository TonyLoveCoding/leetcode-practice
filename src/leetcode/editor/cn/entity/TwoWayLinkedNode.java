package leetcode.editor.cn.entity;

import java.util.*;
import java.util.stream.Collector;

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

    public TwoWayLinkedNode() {
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

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        int m = queries.length;
        int[] preSum = new int[n];
        preSum[0] = candiesCount[0];
        for(int i = 1; i < n ; i++){
            preSum[i] = preSum[i-1] + candiesCount[i];
        }
        boolean[] result = new boolean[m];
        for(int i = 0; i < m; i++){
            int[] query = queries[i];
            int min = query[1] + 1;
            int max = query[0] == 0 ? Integer.MAX_VALUE : query[2] * (min);
            int sum = preSum[query[0]];
            if(sum < min){
                result[i] = false;
            } else if(sum > max){
                result[i] = false;
            } else{
                result[i] = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] data = new int[]{16,38,8,41,30,31,14,45,3,2,24,23,38,30,31,17,35,4,9,42,28,18,37,18,14,46,11,13,19,3,5,39,24,48,20,29,4,19,36,11,28,49,38,16,23,24,4,22,29,35,45,38,37,40,2,37,8,41,33,8,40,27,13,4,33,5,8,14,19,35,31,8,8};
        int[][] queries = new int[][]{
                {43,1053,49}
        };

        TwoWayLinkedNode twoWayLinkedNode = new TwoWayLinkedNode();
        for(Boolean i : twoWayLinkedNode.canEat(data, queries)){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
