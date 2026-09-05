

class LRUCache {

    // Node for doubly linked list
    class Node {
        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;

    HashMap<Integer, Node> map;

    Node head;
    Node tail;


    public LRUCache(int capacity) {

        this.capacity = capacity;

        map = new HashMap<>();

        // Dummy head and tail nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }


    public int get(int key) {

        // If key does not exist
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Since we accessed it,
        // it becomes most recently used
        remove(node);
        addToFront(node);

        return node.value;
    }


    public void put(int key, int value) {

        // If key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            // Update value
            node.value = value;

            // Move to most recently used position
            remove(node);
            addToFront(node);

            return;
        }

        // Create a new node
        Node newNode = new Node(key, value);

        // Add to HashMap
        map.put(key, newNode);

        // Add to front of linked list
        addToFront(newNode);


        // If capacity exceeded
        if (map.size() > capacity) {

            // Least recently used node
            Node lru = tail.prev;

            // Remove from linked list
            remove(lru);

            // Remove from HashMap
            map.remove(lru.key);
        }
    }


    // Add node right after head
    private void addToFront(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }


    // Remove node from linked list
    private void remove(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}