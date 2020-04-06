
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
//给定一个二叉树，检查它是否是镜像对称的。
//=> 根节点的左右子树是否是镜像关系
//=> 左右子树根节点是否相同&& 左子树的左子树与右子树的右子树是否是镜像关系
// && 左子树的右子树与右子树的左子树是否是镜像关系
//这个程序可以分为两部分写
//把要递归的部分单独写出来
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirror(root.left,root.right);
    }
    //在下面这个程序中进行递归
    private boolean isMirror(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }
        if(t1.val != t2.val){
            return false;
        }
        return isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }
}
