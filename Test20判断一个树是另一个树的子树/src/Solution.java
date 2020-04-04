
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
//另一个树的子树
//判断s是否包含t=>s和t是否相等 || s.left是否包含t || s.right是否包含t
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null){
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        //判断两个数的根节点是不是相同
        boolean ret = false;
        if(s.val == t.val){
            //相同则比较两个树是不是相同，如果两个树相同最终结果就返回true
            ret = isSameTree(s,t);
        }
        //当根节点不相同时，或者根节点相同，但是左右子树不相同时，先对左子树进行递归isSubtree(s.left,t)
        //如果结果为true，则最终结果返回true，否则再对右子树进行递归isSubtree(s.right,t)，
        // 如果结果为true，则最终结果返回true，否则就返回false
        return ret ||  isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(q == null && p == null){
            return true;
        }
        if(q == null || p == null){
            return false;
        }
        if(q.val != p.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(1);
        TreeNode h = new TreeNode(2);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        f.left = g;
        f.right = h;

        Solution s = new Solution();
        System.out.println(s.isSubtree(a,f));
    }
}
