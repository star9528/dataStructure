class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
public class Solution {
    //lca 表示最近公共祖先
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        //findNode 递归找的过程中，一旦找到了就把结果放到lca这个变量中
        findNode(root,p,q);
        return lca;
    }
    //看从root出发能不能找到p或q，只要找到一个，只要找到一个就返回true，否则返回false
    private boolean findNode(TreeNode root,TreeNode p,TreeNode q){
        if(root == null){
            return  false;
        }
        //递归按照后序遍历的方式来查找
        int left = findNode(root.left,p,q) ? 1 : 0;
        int right = findNode(root.right,p,q) ? 1 : 0;
        int mid = (root ==p || root == q) ? 1 : 0;
        if(left + right + mid == 2){
            lca = root;
        }
        //如果三个位置之和为0，表示没找到，返回false
        //只要能找到一个以上，就返回true
        return left + right + mid > 0;
    }
}
