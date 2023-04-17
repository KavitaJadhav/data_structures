//Max 2 nodes
//The left subtree of a node contains only nodes with keys lesser than the node’s key.
//The right subtree of a node contains only nodes with keys greater than the node’s key.
//The left and right subtree each must also be a binary search tree.

//Time complexity
//Search - O(log n)
//insert - O(log n)

//Space complexity
//O(n)

package tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private Node root;


    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private List bfs() {
        List elements = new ArrayList<>();
        List<Node> queue = new ArrayList<Node>();

        if (root == null) {
            return elements;
        }

        queue.add(root);
        Node node;
        while (!queue.isEmpty()) {
            node = queue.remove(0);
            elements.add(node.value);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return elements;
    }

    private List dfsInOrder() {
        List elements = new ArrayList<>();

        if (root != null)
            readDFSInOrder(root, elements);
        return elements;
    }

    private void readDFSInOrder(Node node, List elements) {
        if (node.left != null) readDFSInOrder(node.left, elements);
        elements.add(node.value);
        if (node.right != null) readDFSInOrder(node.right, elements);
    }

    private List dfsPreOrder() {
        List elements = new ArrayList<>();

        if (root != null)
            readDFSPreOrder(root, elements);
        return elements;
    }

    private void readDFSPreOrder(Node node, List elements) {
        elements.add(node.value);
        if (node.left != null) readDFSPreOrder(node.left, elements);
        if (node.right != null) readDFSPreOrder(node.right, elements);
    }

    private List dfsPostOrder() {
        List elements = new ArrayList<>();

        if (root != null)
            readDFSPostOrder(root, elements);
        return elements;
    }

    private void readDFSPostOrder(Node node, List elements) {
        if (node.left != null) readDFSPostOrder(node.left, elements);
        if (node.right != null) readDFSPostOrder(node.right, elements);
        elements.add(node.value);
    }

    private boolean present(int value) {
        if (root == null)
            return false;

        return presentInTree(value, root);
    }

    private boolean presentInTree(int value, Node node) {
        if (value == node.value)
            return true;
        if (value < node.value) {
            if (node.left == null) {
                return false;
            } else {
                return presentInTree(value, node.left);
            }
        } else {
            if (node.right == null) {
                return false;
            } else {
                return presentInTree(value, node.right);
            }
        }
    }


    private void add(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        addNode(node, root);
    }

    private void addNode(Node node, Node parent) {
        if (node.value < parent.value) {
            if (parent.left == null) {
                parent.left = node;
            } else {
                addNode(node, parent.left);
            }
        } else {
            if (parent.right == null) {
                parent.right = node;
            } else {
                addNode(node, parent.right);
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(50);
        tree.add(60);
        tree.add(45);
        tree.add(67);
        tree.add(23);
        tree.add(25);
        System.out.println("Search 25: " + tree.present(60));
        System.out.println("Search 26: " + tree.present(26));
        System.out.println("BFS : " + tree.bfs());
        System.out.println("DFS pre order : " + tree.dfsPreOrder());
        System.out.println("DFS in order : " + tree.dfsInOrder());
        System.out.println("DFS post order : " + tree.dfsPostOrder());

//        System.out.println(tree.root.value);
//        System.out.println(tree.root.left.value);
//        System.out.println(tree.root.right.value);
//        System.out.println(tree.root.right.right.value);
//        System.out.println(tree.root.left.left.value);
//        System.out.println(tree.root.left.left.right.value);
    }

}

//              50
//           45   60
//         23       67
//           25

//BFS - 50, 45, 60,23,67,25
//DFS - preorder - 50,45,23,25,60,67
//DFS - inorder - 23,25,45,50,60,67
//DFS - postorder - 25,23,45,67,60,50