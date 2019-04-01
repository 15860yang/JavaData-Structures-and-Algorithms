import java.util.HashMap;

public class LRU<K,V> {

    public static void main(String[] args) {
        LRU<Integer,String> lru = new LRU<>(5);
        lru.put(1,"111");
        lru.put(2,"222");
        lru.put(3,"333");
        lru.get(3);
        lru.put(4,"444");
        lru.put(5,"555");
        lru.get(2);
        lru.put(6,"666");
        lru.put(7,"777");
        lru.printAllNode();
    }

    private final int maxSize;
    private int size;

    private Node head = null;
    private Node tail = null;
    private HashMap<K,Node> cache;

    public LRU(int size){
        maxSize = size;
        cache = new HashMap<>();
    }

    public boolean put(K k,V v){
        if (v == null || k == null){
            throw new IllegalArgumentException();
        }
        if(cache.containsKey(k)){
            return false;
        }
        //先检查缓存的数目
        if(size >= maxSize){
            removeTailNode();
        }
        //先将数据加入到hashMap
        Node node = new Node();
        node.object = v;
        node.key = k;
        cache.put(k,node);
        size++;
        //然后加入到链表
        if(head == null){
            head = node;
            head.last = null;
            head.next = null;
            tail = head;
        }else {
            tail.next = node;
            node.last = tail;
            node.next = null;
            tail = node;
        }
        return true;
    }

    public V get(K k){
        if(!cache.containsKey(k)){
            return null;
        }
        Node node = cache.get(k);
        moveToHead(node);
        return (V) node.key;
    }

    public Node remove(K k){
        if(cache.containsKey(k)){
            Node node = cache.get(k);
            if(node.equals(head)){
                head = node.next;
                head.last = null;
            }else if(node.equals(tail)){
                tail = node.last;
                tail.next = null;
            }else {
                node.last = node.next;
            }
            node.last = null;
            node.next = null;
            size--;
            return cache.remove(k);
        }
        return null;
    }

    public void clear(){
        size = 0;
        cache.clear();
        while (tail.equals(head)){
            tail = tail.last;
            tail.next.next = null;
            tail.next = null;
        }
        head = null;
        tail = null;
    }
    public void printAllNode(){
        Node node = head;
        while (node != null){
            System.out.println(node.object);
            node = node.next;
        }
    }
    private void moveToHead(Node node) {
        if(node.equals(head)){
            return;
        }
        node.last.next = node.next;
        if(node.equals(tail)){
            tail = node.last;
        }
        node.next = head;
        node.last = null;
        head = node;
    }

    private void removeTailNode() {
        K k = (K) tail.key;
        tail = tail.last;
        tail.next = null;
        cache.get(k).last = null;
        cache.remove(k);
        size--;
    }

    public static class Node{
        public Object object;
        public Object key;
        public Node last;
        public Node next;
    }

}
