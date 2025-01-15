package tasks;

import model.TreeNode;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if(root.left == null && root.right == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode current = null, previous = null;
        while(!stack.isEmpty()) {
            current = stack.pop();

            if(previous != null) {
                previous.left = null;
                previous.right = current;
            }

            if(current.right != null) {
                stack.push(current.right);
            }

            if(current.left != null) {
                stack.push(current.left);
            }

            previous = current;
        }
    }

    public static void main(String[] args) {
        // Create the binary tree:
        //     1
        //    / \
        //   2   5
        //  / \   \
        // 3   4   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        // Flatten the binary tree
        FlattenBinaryTreeToLinkedList solution = new FlattenBinaryTreeToLinkedList();
        solution.flatten(root);

        // Print the flattened tree as a linked list
        printFlattenedTree(root);
    }

    // Helper method to print the flattened tree
    private static void printFlattenedTree(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.right;
        }
        System.out.println("null");
    }
}
