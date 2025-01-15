package tasks;


import model.TreeNode;

public class LowestCommonAncestorBinaryTree {
    static public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: return root if it's null, p, or q
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recurse for left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both sides return non-null, root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // If only one side is non-null, propagate it upwards
        return left != null ? left : right;
    }

    //          -1
    //         /  \
    //        0    3
    //       / \
    //     -2   4
    //     /
    //    8

    //        3
    //       / \
    //      5   1
    //     / \ / \
    //    6  2 0  8
    //      / \
    //     7   4

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);

        // Intermediate nodes
        TreeNode node2 = new TreeNode(2);
        node2.left = node7;
        node2.right = node4;

        TreeNode node5 = new TreeNode(5);
        node5.left = node6;
        node5.right = node2;

        TreeNode node1 = new TreeNode(1);
        node1.left = node0;
        node1.right = node8;

        // Root node
        TreeNode root = new TreeNode(3);
        root.left = node5;
        root.right = node1;

        TreeNode result;
//        result = lowestCommonAncestor(root, node1, node2);
//        System.out.println("common ancestor: " + result.val);

        // Create the leaf node
        TreeNode anode8 = new TreeNode(8);
        // Create intermediate nodes
        TreeNode anodeMinus2 = new TreeNode(-2);
        anodeMinus2.left = anode8;

        TreeNode anode4 = new TreeNode(4);

        TreeNode anode0 = new TreeNode(0);
        node0.left = anodeMinus2;
        node0.right = anode4;

        TreeNode anode3 = new TreeNode(3);

        // Create the root node
        TreeNode aroot = new TreeNode(-1);
        aroot.left = anode0;
        aroot.right = anode3;

        result = lowestCommonAncestor(aroot, anode8, anode4);
        System.out.println("common ancestor: " + result.val);
    }
}


