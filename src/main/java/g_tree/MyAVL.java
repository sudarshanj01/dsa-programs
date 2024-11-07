package g_tree;

public class MyAVL {
    Node root;

    // Constructor to initialize an empty AVL tree
    private MyAVL() {
        root = null;
    }

    // Insert a new node into the AVL tree
    public void insert(int item) {
        root = insert(root, item);
    }

    // Helper method to insert a new node into the AVL tree
    private Node insert(Node node, int item) {
        if (node == null) {
            return new Node(item); // New node if the position is empty
        }

        if (node.value == item) {
            return node;
        }

        // Traverse left if item is smaller, right if it's larger
        if (item < node.value) {
            node.left = insert(node.left, item);
        } else if (item > node.value) {
            node.right = insert(node.right, item);
        }

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        // Check if the tree is balanced
        if (!isBalanced(node)) {
            if (isLeftHeavy(node)) {
                if (getBalanceFactor(node.left) < 0) {
                    node.left = rotateLeft(node.left);
                }
                node = rotateRight(node);

            } else if (isRightHeavy(node)) {
                if (getBalanceFactor(node.right) > 0) {
                    node.right = rotateRight(node.right);
                }
                root = rotateLeft(root);
            }
        }

        return node;

    }

    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    private Boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        return balanceFactor >= -1 && balanceFactor <= 1;
    }

    private Boolean isLeftHeavy(Node node) {
        if (node == null) {
            return false;
        }
        return getBalanceFactor(node) > 1;
    }

    private Boolean isRightHeavy(Node node) {
        if (node == null) {
            return false;
        }
        return getBalanceFactor(node) < -1;
    }

    private Node rotateLeft(Node root) {
        if (root == null) return null;

        Node newRoot = root.right;
        root.left = newRoot.left;
        newRoot.left = root;

        return newRoot;
    }

    private Node rotateRight(Node root) {
        if (root == null) return null;

        Node newRoot = root.left;
        root.right = newRoot.right;
        newRoot.right = root;

        return newRoot;
    }


    public static void main(String[] args) {
        MyAVL tree = new MyAVL();

        // Insert elements into the tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);

        System.out.println(tree);
    }


}