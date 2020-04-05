
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
//给定一个二叉树，找出其最大深度。
//二叉树的深度=>max(左子树的深度，右子树的深度) + 1
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int m1 = maxDepth(root.left);
        int m2 = maxDepth(root.right);
        return (m1 > m2 ? m1 : m2) + 1;
    }
}
