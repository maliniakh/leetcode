package tasks;

import java.util.HashMap;
import java.util.Map;

class ListCacheNode {
    int key;
    int val;
    ListCacheNode next;
    ListCacheNode prev;

    public ListCacheNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCacheOrig {
    int capacity;
    Map<Integer, ListCacheNode> dic;
    ListCacheNode head;
    ListCacheNode tail;

    public LRUCacheOrig(int capacity) {
        this.capacity = capacity;
        dic = new HashMap<>();
        head = new ListCacheNode(-1, -1);
        tail = new ListCacheNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!dic.containsKey(key)) {
            return -1;
        }

        ListCacheNode node = dic.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (dic.containsKey(key)) {
            ListCacheNode oldNode = dic.get(key);
            remove(oldNode);
        }

        ListCacheNode node = new ListCacheNode(key, value);
        dic.put(key, node);
        add(node);

        if (dic.size() > capacity) {
            ListCacheNode nodeToDelete = head.next;
            remove(nodeToDelete);
            dic.remove(nodeToDelete.key);
        }
    }

    public void add(ListCacheNode node) {
        ListCacheNode previousEnd = tail.prev;
        previousEnd.next = node;
        node.prev = previousEnd;
        node.next = tail;
        tail.prev = node;
    }

    public void remove(ListCacheNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */