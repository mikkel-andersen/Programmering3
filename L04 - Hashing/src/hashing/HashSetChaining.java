package hashing;

/**
 * This class implements a hash set using separate chaining.
 */
public class HashSetChaining {
	private Node[] buckets;
	private int currentSize;

	/**
	 * Constructs a hash table.
	 *
	 * @param bucketsLength the length of the buckets array
	 */
	public HashSetChaining(int bucketsLength) {
		buckets = new Node[bucketsLength];
		currentSize = 0;
	}

	/**
	 * Tests for set membership.
	 *
	 * @param x an object
	 * @return true if x is an element of this set
	 */
	public boolean contains(Object x) {
		int h = hashValue(x, buckets.length);
		Node current = buckets[h];
		boolean found = false;
		while (!found && current != null) {
			if (current.data.equals(x)) {
				found = true;
			} else {
				current = current.next;
			}
		}
		return found;
	}

	public double loadFactor() {
		return (double) currentSize / buckets.length;
	}

	/**
	 * Adds an element to this set.
	 *
	 * @param x an object
	 * @return true if x is a new object, false if x was already in the set
	 */
	public boolean add(Object x) {
		int h = hashValue(x, buckets.length);
		if (loadFactor() > 0.75) {
			rehash();
		}
		Node current = buckets[h];
		boolean found = false;
		while (!found && current != null) {
			if (current.data.equals(x)) {
				found = true;
				// Already in the set
			} else {
				current = current.next;
			}

		}
		if (!found) {
			Node newNode = new Node();
			newNode.data = x;
			newNode.next = buckets[h];
			buckets[h] = newNode;
			currentSize++;
		}
		return !found;
	}

	private void rehash() {
		System.out.println("rehasher");
    Node[] newBuckets = new Node[buckets.length * 2];
    for (Node oldBucket : buckets) {
        Node current = oldBucket;
        while (current != null) {
            int h = hashValue(current.data, newBuckets.length);
            Node newNode = new Node();
            newNode.data = current.data;
            newNode.next = newBuckets[h];
            newBuckets[h] = newNode;
            current = current.next;
        }
    }
    buckets = newBuckets;
}

	/**
	 * Removes an object from this set.
	 *
	 * @param x an object
	 * @return true if x was removed from this set, false if x was not an
	 * element of this set
	 */
	public boolean remove(Object x) {
		int h = hashValue(x, buckets.length);
		if (buckets[h] != null) {
			if (buckets[h].data.equals(x)) {
				buckets[h] = buckets[h].next;
				currentSize--;
				return true;
			} else {
				Node current = buckets[h];
				while (current.next != null && !current.next.data.equals(x)) {
					current = current.next;
				}
				if (current.next != null) {
					current.next = current.next.next;
					currentSize--;
					return true;
				}
			}
		}
		return false;
	}

	private int hashValue(Object x, int length) {
		int h = x.hashCode();
		if (h < 0) {
			h = -h;
		}
		h = h % length;
		return h;
	}

	/**
	 * Gets the number of elements in this set.
	 *
	 * @return the number of elements
	 */
	public int size() {
		return currentSize;
	}

	// method only for test purpose
	void writeOut() {
		for (int i = 0; i < buckets.length; i++) {
			Node temp = buckets[i];
			if (temp != null) {
				System.out.print(i + "\t");
				while (temp != null) {
					System.out.print(temp.data + "\t");
					temp = temp.next;
				}
				System.out.println();
			}
		}
	}

	class Node {
		public Object data;
		public Node next;
	}
}
