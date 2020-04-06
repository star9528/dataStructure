
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
//给定一个二叉树，判断它是否是高度平衡的二叉树。
//一个数是否平衡=>自己的左右子树高度差  小于等于1  && 左子树是平衡的 &&右子树是平衡的
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if(l - r > 1 || l - r < -1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

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
