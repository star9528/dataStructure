import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
public class Solution {
    //result 相当于一个二维数组
    //针对当前的ArrayList（包含了所有层）来说，每个元素又是一个List（每一层里面的所有节点内容）
    //result 0 号元素对应着第0层节点
    //result 1 号元素对应着第1层节点
    static List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        //此处由于要把每一层的节点放到一个单独的List中，所以之前的层序遍历方试就不太行了
        //此处还是基于递归的方式来解决这个问题
        if(root == null){
            return result;
        }
        //helper 方法辅助递归，第二个参数表示当前的层数(层数从0开始算，和List下标对得上)
        helper(root,0);
        return result;
    }
    private void helper(TreeNode root,int level){
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        //把当前节点添加到result中的合适位置
        //result.get(level).add(root.val);
        List<Integer> row = result.get(level);
        row.add(root.val);
        if(root.left != null){
            helper(root.left,level + 1);
        }
        if(root.right != null){
            helper(root.right,level + 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        a.left = b;
        System.out.println(s.levelOrder(a));
    }
}
