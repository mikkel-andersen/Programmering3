package Tree;

public class App {
    public static void main(String[] args) {
        BST<Object> tree = new BST<>();
        tree.insert(45);
        tree.insert(22);
        tree.insert(11);
        tree.insert(15);
        tree.insert(30);
        tree.insert(25);
        tree.insert(77);
        tree.insert(90);
        tree.insert(88);

        System.out.println("Inorder: ");
        tree.inorder();
        System.out.println();

        System.out.println("Postorder: ");
        tree.postorder();
        System.out.println();

        System.out.println("Preorder: ");
        tree.preorder();
        System.out.println();

        System.out.println("Height: " + tree.height());
        System.out.println("isLeaf: " + tree.isLeaf(25));
        System.out.println("isInternal: " + tree.isInternal(22));
        System.out.println("findMax: " + tree.findMax());
        System.out.println("findMin: " + tree.findMin());

        System.out.println("------");
        System.out.println("Sum: " + tree.sum());

        System.out.println();
        System.out.println("-------");
        System.out.println(tree.removeMin());
        System.out.println("-------");
        System.out.println(tree.removeMax());
        System.out.println("-------");
        System.out.println(tree.greaterThan(30));







    }
}
