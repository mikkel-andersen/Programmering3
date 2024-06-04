import java.util.Comparator;

public class BinarySearchTree<E> {

    private Comparator<E> comparator;
    private TreeNode<E> root;
    private int size = 0;

    public BinarySearchTree() {
        this.comparator = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
    }

    public TreeNode<E> getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    public boolean insert(E e) {
        boolean insert = true;
        if (root == null) {
            root = createNewNode(e);
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null && insert) {
                if (comparator.compare(e, current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (comparator.compare(e, current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    insert = false;
                }
            }
            if (insert) {
                if (comparator.compare(e, parent.element) < 0) {
                    parent.left = createNewNode(e);
                } else {
                    parent.right = createNewNode(e);
                }
                size++;
            }
        }
        return insert;
    }

    public String preorder() {
        return preorder(getRoot()).trim();
    }

    private String preorder(TreeNode<E> node) {
        String print = "";
        if (node != null) {
            print += " " + node.element;
            print += preorder(node.left);
            print += preorder(node.right);
        }
        return print;
    }

    public boolean balanced() {
        if (getRoot() == null) {
            return true;
        } else {
            int leftHeight = height(getRoot().left);
            int rightHeight = height(getRoot().right);
            if ((leftHeight - rightHeight) > 1) {
                return false;
            } else {
                if (Math.abs(leftHeight - rightHeight) <= 1 || leftHeight - rightHeight == 0) {
                    return true;
                }
            }
        }

        throw new UnsupportedOperationException();
    }


    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    private class TreeNode<E> {
        E element;
        TreeNode<E> left;
        TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }

    private int height(TreeNode<E> node) {
        if (node == null) {
            return -1;
        } else {
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }
}
