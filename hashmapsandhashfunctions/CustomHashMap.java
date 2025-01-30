package Week_03.Day_02.hashmapsandhashfunctions;
import java.util.*;

class CustomHashMap<K, V> {
    // Node class to represent key-value pairs in the hashmap
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private static final int INITIAL_CAPACITY = 16; // Default capacity
    private List<Node<K, V>> buckets;

    public CustomHashMap() {
        buckets = new ArrayList<>(Collections.nCopies(INITIAL_CAPACITY, null));
    }

    // Hash function to determine bucket index
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % INITIAL_CAPACITY;
    }

    // Insert or update key-value pair
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets.get(index);

        // Check if key already exists, update value if found
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert new key-value pair at the head of the linked list
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets.get(index);
        buckets.set(index, newNode);
    }

    // Retrieve value by key
    public V get(K key) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets.get(index);

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null; // Key not found
    }

    // Remove key-value pair
    public void remove(K key) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets.get(index);
        Node<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    buckets.set(index, head.next);
                } else {
                    prev.next = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        System.out.println("Value for 'one': " + map.get("one")); // Output: 1
        map.remove("one");
        System.out.println("Value for 'one' after removal: " + map.get("one")); // Output: null
    }
}
