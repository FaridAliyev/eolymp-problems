package solutions.week3.tree;

public class Tree {
    TreeNode head;
    Tree()
    {
        head = null;
    }

    void Insert(int val)
    {
        head = Insert(head, val);
    }

    // objects are passed by copy
    TreeNode Insert(TreeNode tree, int val)
    {
        if (tree == null)
        {
            return new TreeNode(val);
        }
        if (val < tree.val)
            tree.left = Insert(tree.left, val);
        else
            tree.right = Insert(tree.right, val);
        return tree;
    }
}
