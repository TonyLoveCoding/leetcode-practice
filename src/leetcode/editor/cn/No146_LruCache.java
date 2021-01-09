package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class No146_LruCache{

//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1091 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    int count;
    int size;
    Map<Integer, TwoWayLinkedNode> nodeMap;
    TwoWayLinkedNode fakeHead;
    TwoWayLinkedNode fakeTail;

    /**
     * Map=索引字典表，key:key, value:node
     * Node=固定长度双向链表，只往头部添加元素，超长了就移除尾部；读取时移至头部
     * @param capacity
     */
    public LRUCache(int capacity) {
        count = 0;
        size = capacity;
        nodeMap = new HashMap<>();
        fakeHead = new TwoWayLinkedNode(0, 0);
        fakeTail = new TwoWayLinkedNode(0, 0);
        fakeHead.next = fakeTail;
        fakeTail.prev = fakeHead;
    }
    
    public int get(int key) {
        TwoWayLinkedNode node = nodeMap.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(fakeHead, node);
        return node.value;
    }
    
    public void put(int key, int value) {
        TwoWayLinkedNode exist = nodeMap.get(key);
        if(exist == null){
            TwoWayLinkedNode newNode = new TwoWayLinkedNode(key, value);
            nodeMap.put(key, newNode);
            count++;
            addToHead(fakeHead, newNode);
            if(count > size){
                nodeMap.remove(removeTail(fakeTail).key);
                count--;
            }
        } else{
            exist.value = value;
            moveToHead(fakeHead, exist);
        }
    }

    void remove(TwoWayLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void addToHead(TwoWayLinkedNode fakeHead, TwoWayLinkedNode node){
        node.next = fakeHead.next;
        node.prev = fakeHead;

        fakeHead.next = node;
        node.next.prev = node;
    }

    void moveToHead(TwoWayLinkedNode fakeHead, TwoWayLinkedNode node){
        remove(node);
        addToHead(fakeHead, node);
    }

    TwoWayLinkedNode removeTail(TwoWayLinkedNode fakeTail){
        TwoWayLinkedNode node = fakeTail.prev;
        remove(node);
        return node;
    }


    class TwoWayLinkedNode {
        /**
         * 键
         */
        public int key;

        /**
         * 值
         */
        public int value;

        public TwoWayLinkedNode prev;

        public TwoWayLinkedNode next;

        public TwoWayLinkedNode(int key, int value) {
            this(key, value, null, null);
        }

        public TwoWayLinkedNode(int key, int value, TwoWayLinkedNode prev, TwoWayLinkedNode next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        LRUCache lRUCache = new No146_LruCache().new LRUCache(2);
        lRUCache.put(2, 1);
        lRUCache.put(1, 1);
        lRUCache.put(2, 3);
        lRUCache.put(4, 1);
        System.out.println(lRUCache.get(1));//返回 -1 (未找到)
        System.out.println(lRUCache.get(2));//返回 3
    }
}