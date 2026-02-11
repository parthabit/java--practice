import java.util.*;

class LRUCache {
    private final int capacity;
    private Map<Integer, Node> map;
    private DoublyLinkedList dll;

    // Node for doubly linked list
    private static class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    // Doubly linked list to track usage order
    private static class DoublyLinkedList {
        Node head, tail;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        Node removeLast() {
            if (tail.prev == head) return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dll = new DoublyLinkedList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        dll.remove(node);
        dll.addFirst(node); // move to front (most recently used)
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            dll.remove(node);
            dll.addFirst(node);
        } else {
            if (map.size() == capacity) {
                Node last = dll.removeLast();
                map.remove(last.key);
            }
            Node newNode = new Node(key, value);
            dll.addFirst(newNode);
            map.put(key, newNode);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        System.out.println(cache.get(1)); // 10
        cache.put(4, 40); // evicts key 2
        System.out.println(cache.get(2)); // -1 (not found)
        System.out.println(cache.get(3)); // 30
        System.out.println(cache.get(4)); // 40
    }
}
