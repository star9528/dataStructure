
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
//根据二叉树创建字符串
public class Solution {
    //使用sb表示最终得到的字符串结果
    //递归过程中得到的局部结构都往sb中追加即可
    private StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode t) {
        if(t == null){
            //需要返回一个空字符串，而不是一个null
            return "";
        }
        //借助helper方法递归进行先序遍历
        helper(t);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void helper(TreeNode t) {
        if(t == null){
            return;
        }
        //访问根节点，此处的访问操作追加字符串到sb中即可
        sb.append("(");
        sb.append(t.val);
        helper(t.left);
        if(t.left == null && t.right != null){
            //左子树为空，右子树非空
            //一定要加上一组（）来占位
            sb.append("()");
        }
        helper(t.right);
        sb.append(")");
    }
}
