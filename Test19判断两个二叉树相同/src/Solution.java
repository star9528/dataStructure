
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
//给定两个二叉树，编写一个函数来检验它们是否相同。
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //三种种情况：
        //1.q和p都为空
        if(q == null && p == null){
            return true;
        }
        //2.p为空q不为空，或者q为空p不为空
        if(q != null || p != null){
            return false;
        }
        //3.p和q都不为空
        //此时先判断p和q两个节点的值是否相等
        //如果不相等就返回false
        if(q.val != p.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
