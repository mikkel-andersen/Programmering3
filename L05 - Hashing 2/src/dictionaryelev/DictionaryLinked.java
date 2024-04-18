package dictionaryelev;

public class DictionaryLinked<K, V> implements Dictionary<K, V> {

    private Node start;
    private int size;

    /**
     * HashingMap constructor comment.
     */

    public DictionaryLinked() {
        // Sentinel (tomt listehoved - der ikke indeholder data)
        start = new Node();
        size = 0;
    }

    @Override
    public V get(K key) {
        // TODO
        Node temp = start.next;
        while (temp.next != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V put(K key, V value) {
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;

        if (start.next == null) {
            start.next = newNode;
        } else {
            Node temp = start.next;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        size++;
        return newNode.value; // You might want to return something else here, depending on your requirements
    }

    @Override
    public V remove(K key) {
        // TODO
        Node temp = start.next;

        while (temp.next != null) {
            
        }

        return null;
    }

    @Override
    public int size() {

        return size;
    }

    private class Node {
        Node next;
        K key;
        V value;
    }

}
