package g_tree;

class Node {
    int value;
    Node left;
    Node right;
    int height;

    // Constructor to create a new node
    public Node(int item) {
        value = item;
        left = right = null;
        height = 0;
    }

    public String toString() {
        return "Node{" +
                "value=" + value ;
    }
}