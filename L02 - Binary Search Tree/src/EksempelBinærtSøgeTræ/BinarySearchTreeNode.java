package EksempelBinærtSøgeTræ;

public class BinarySearchTreeNode {

    private int value;
    private BinarySearchTreeNode left;
    private BinarySearchTreeNode right;

    public BinarySearchTreeNode(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        BinarySearchTreeNode bst = new BinarySearchTreeNode(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        System.out.println("Min: " + bst.findMin());
        System.out.println("Max: " + bst.findMax());
        System.out.println("Height: " + bst.height());
        System.out.println("Contains 6: " + bst.contains(6));
        System.out.println("Depth of 6: " + bst.depth(6));
        System.out.println("-----------");
        System.out.println("InOrder");
        bst.printInOrder();
        System.out.println("-----------");
        System.out.println("PreOrder");
        bst.printPreOrder();
        System.out.println("-----------");
        System.out.println("PostOrder");
        bst.printPostOrder();
    }

    public void insert(int value) {
        if (value <= this.value) {
            if (left == null) {
                left = new BinarySearchTreeNode(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new BinarySearchTreeNode(value);
            } else {
                right.insert(value);
            }
        }
    }

    public void delete(int value) {
        if (value == this.value) {
            // TODO
        } else if (value < this.value) {
            if (left != null) {
                left.delete(value);
            }
        } else {
            if (right != null) {
                right.delete(value);
            }
        }
    }

    public boolean contains(int value) {
        if (value == this.value) {
            return true;
        } else if (value < this.value) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }

    // InOrder: Left, Root, Right
    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(value);
        if (right != null) {
            right.printInOrder();
        }
    }

    // PreOrder: Root, Left, Right
    public void printPreOrder() {
        System.out.println(value);
        if (left != null) {
            left.printPreOrder();
        }
        if (right != null) {
            right.printPreOrder();
        }
    }

    // PostOrder: Left, Right, Root
    public void printPostOrder() {
        if (left != null) {
            left.printPostOrder();
        }
        if (right != null) {
            right.printPostOrder();
        }
        System.out.println(value);
    }

    public int findMin() {
        if (left == null) {
            return value;
        } else {
            return left.findMin();
        }
    }

    public int findMax() {
        if (right == null) {
            return value;
        } else {
            return right.findMax();
        }
    }

    public int height() {
        if (left == null && right == null) {
            return 0;
        } else if (left == null) {
            return 1 + right.height();
        } else if (right == null) {
            return 1 + left.height();
        } else {
            return 1 + Math.max(left.height(), right.height());
        }
    }

    public int depth(int value) {
        if (value == this.value) {
            return 0;
        } else if (value < this.value) {
            if (left == null) {
                return -1;
            } else {
                int d = left.depth(value);
                if (d == -1) {
                    return -1;
                } else {
                    return 1 + d;
                }
            }
        } else {
            if (right == null) {
                return -1;
            } else {
                int d = right.depth(value);
                if (d == -1) {
                    return -1;
                } else {
                    return 1 + d;
                }
            }
        }
    }

}
