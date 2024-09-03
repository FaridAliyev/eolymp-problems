package solutions.week3.tree;

import java.util.Scanner;

public class TreeProblems {
    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        Tree t = new Tree();
        int n = con.nextInt();
        for (int i = 0; i < n; i++) {
            int x = con.nextInt();
            t.Insert(x);
        }

        System.out.println(sumLeft(t.head));

        con.close();
    }

    public static TreeNode Minimum(TreeNode tree) {
        if (tree == null) return null;
        if (tree.left != null) return Minimum(tree.left);
        else return tree;
    }

    public static TreeNode Maximum(TreeNode tree) {
        if (tree == null) return null;
        if (tree.right != null) return Maximum(tree.right);
        else return tree;
    }

    public static TreeNode Find(TreeNode tree, int element) {
        if (tree == null) return null;
        if (element == tree.val) return tree;
        if (element < tree.val) return Find(tree.left, element);
        else return Find(tree.right, element);
    }

    public static int minDepth(TreeNode tree) {
        if (tree.left == null && tree.right == null) {
            return 1;
        } else if (tree.left == null) {
            return minDepth(tree.right) + 1;
        } else if (tree.right == null) {
            return minDepth(tree.left) + 1;
        } else return Math.min(minDepth(tree.left), minDepth(tree.right)) + 1;
    }

    public static int maxDepth(TreeNode tree) {
        if (tree.left == null && tree.right == null) {
            return 1;
        } else if (tree.left == null) {
            return maxDepth(tree.right) + 1;
        } else if (tree.right == null) {
            return maxDepth(tree.left) + 1;
        } else return Math.max(maxDepth(tree.left), maxDepth(tree.right)) + 1;
    }

    public static int sumLeft(TreeNode tree) {
        if (tree == null) return 0;
        int sum = 0;
        if (tree.left != null && tree.left.left == null && tree.left.right == null) sum += tree.left.val;
        if (tree.left != null) sum += sumLeft(tree.left);
        if (tree.right != null) sum += sumLeft(tree.right);
        return sum;
    }

    public static boolean isSymmetric(TreeNode tree) {
        return symmetric(tree.left, tree.right);
    }

    public static boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val == right.val) return symmetric(left.left, right.right) && symmetric(left.right, right.left);
        return false;
    }

    public static boolean isBalanced(TreeNode tree) {
        return Height(tree) != -1;
    }

    public static int Height(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        if (tree.left == null && tree.right == null) {
            return 1;
        } else {
            int left = Height(tree.left);
            int right = Height(tree.right);
            if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
                return -1;
            }

            return Math.max(left, right) + 1;
        }
    }

//    public static TreeNode Prev(TreeNode tree) {
//        if (tree.left != null) return Maximum(tree.left);
//        TreeNode prev = tree.parent;
//        while ((prev != null) && (tree == prev.left)) {
//            tree = prev;
//            prev = prev.parent;
//        }
//        return prev;
//    }
}
