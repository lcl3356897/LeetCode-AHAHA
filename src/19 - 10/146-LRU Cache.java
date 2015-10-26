public class LRUCache {
    HashMap<Integer, Integer> cache;
    List<Integer> list;
    int capacity;
    public LRUCache(int capacity) {
        this.cache = new HashMap<Integer, Integer>();
        this.list = new ArrayList<Integer>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            list.remove(list.indexOf(key));
            list.add(key);
            return cache.get(key);
        }
        else{
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(cache.containsKey(key)){
            list.remove(list.indexOf(key));
            list.add(key);
            cache.put(key, value);
        }
        else{
            if(cache.size() == capacity){
                cache.remove(list.get(0));
                list.remove(0);
            }
            cache.put(key, value);
            list.add(key);
        }
    }
}


//


public class LRUCache {
    private class Node {
        protected int key;
        protected int value;
        protected Node prev;
        protected Node next;
    
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = next = null;
        }
    }

    private HashMap<Integer,Node> cache;
    private Node head = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
    private Node tail;
    private int capacity;
    private int size = 0;

    public LRUCache(int capacity) {
        cache = new HashMap<Integer, Node>(2*capacity);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node == null) {
            return -1;
        } else {
            removeNode(node);
            cache.remove(node);
    
            addNodeToFront(node);
            cache.put(key, node);
    
            return node.value;
        }
    }
    
    public void set(int key, int value) {
        Node node = cache.get(key);
        if(node == null) {
            if(size >= capacity){
                Node LUNode = removeFromTail();
                cache.remove(LUNode.key);
            }
    
            Node newNode = new Node(key, value);
            addNodeToFront(newNode);
            cache.put(key, newNode);
        } else {
            node.value = value;
    
            removeNode(node);
            cache.remove(node);
    
            addNodeToFront(node);
            cache.put(key, node);
        }
    }
    
    private void removeNode(Node node) {
        if(node.next == null) {
            tail = node.prev;
            node.prev.next = null;
            node.prev = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
    }
    
    private void addNodeToFront(Node node) {
        if(head.next == null) {
            head.next = node;
            node.prev = head;
            tail = node;
        } else {
            head.next.prev = node;
            node.next = head.next;
            head.next = node;
            node.prev = head;
        }
        size++;
    }
    
    private Node removeFromTail() {
        Node temp = tail;
        tail = tail.prev;
        removeNode(temp);
        return temp;
    }
}