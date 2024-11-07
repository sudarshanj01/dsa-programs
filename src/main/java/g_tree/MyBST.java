package g_tree;

import java.util.ArrayList;
import java.util.List;

public class MyBST {
    Node root;

    // Constructor to initialize an empty BST
    private MyBST() {
        root = null;
    }

    // Insert a new node into the binary search tree
    public void insert(int item) {
        root = insert(root, item);
    }

    // Helper method to insert a new node into the BST
    private Node insert(Node node, int item) {
        if (node == null) {
            return new Node(item); // New node if the position is empty
        }

        // Traverse left if item is smaller, right if it's larger
        if (item < node.value) {
            node.left = insert(node.left, item);
        } else if (item > node.value) {
            node.right = insert(node.right, item);
        }

        return node;
    }

    // Inorder Traversal (Left -> Root -> Right)
    public void inorder() {
        inorderTraversal(root);
        System.out.println();
    }

    private void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left); // Traverse left
            System.out.print(node.value + " "); // Visit root
            inorderTraversal(node.right); // Traverse right
        }
    }

    // Preorder Traversal (Root -> Left -> Right)
    public void preorder() {
        preorderTraversal(root);
        System.out.println();
    }

    private void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.value + " "); // Visit root
            preorderTraversal(node.left); // Traverse left
            preorderTraversal(node.right); // Traverse right
        }
    }

    // Postorder Traversal (Left -> Right -> Root)
    public void postorder() {
        postorderTraversal(root);
        System.out.println();
    }

    private void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.left); // Traverse left
            postorderTraversal(node.right); // Traverse right
            System.out.print(node.value + " "); // Visit root
        }
    }

    // Get the height of the tree (maximum depth from root to a leaf)
    public int getHeight() {
        return calculateHeight(root);
    }

    private int calculateHeight(Node node) {
        if (node == null) {
            return -1; // Empty tree has height -1
        }

        int leftHeight = calculateHeight(node.left); // Height of left subtree
        int rightHeight = calculateHeight(node.right); // Height of right subtree

        return Math.max(leftHeight, rightHeight) + 1; // Add 1 for the current node
    }

    // Get the depth of a node (distance from root)
    public int getDepth(int value) {
        return calculateDepth(root, value, 0);
    }

    private int calculateDepth(Node node, int value, int depth) {
        if (node == null) {
            return -1; // Node not found
        }

        if (node.value == value) {
            return depth; // Found the node, return the current depth
        } else if (value < node.value) {
            return calculateDepth(node.left, value, depth + 1); // Search in the left subtree
        } else {
            return calculateDepth(node.right, value, depth + 1); // Search in the right subtree
        }
    }

    // Get the minimum value in the BST
    public int getMinValue() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        return findMin(root).value;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left; // Move left until the leftmost node
        }
        return node; // Return the minimum node
    }

    public static void main(String[] args) {
        MyBST tree = new MyBST();

        List<Integer> sublist = new ArrayList<>(10);

        sublist.add(10);
        sublist.add(0,12);
        System.out.println(sublist);


        // Insert elements into the tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Display traversals
        System.out.println("Inorder traversal:");
        tree.inorder(); // Expected: 20 30 40 50 60 70 80

        System.out.println("Preorder traversal:");
        tree.preorder(); // Expected: 50 30 20 40 70 60 80

        System.out.println("Postorder traversal:");
        tree.postorder(); // Expected: 20 40 30 60 80 70 50

        // Display height of the tree
        System.out.println("Height of the tree: " + tree.getHeight()); // Expected: 2

        // Display depth of a specific node
        System.out.println("Depth of node with value 40: " + tree.getDepth(40)); // Expected: 2

        // Display minimum value in the tree
        System.out.println("Minimum value in the tree: " + tree.getMinValue()); // Expected: 20
    }
}
