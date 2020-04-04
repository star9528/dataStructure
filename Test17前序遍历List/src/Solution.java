import java.util.ArrayList;
import java.util.List;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
//给定一个二叉树，返回它的前序遍历,返回类型为List<Integer>
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            //空树返回一个空的List（元素个数为0，但不是null）
            return result;
        }
        //访问根节点，把元素add到List中
        result.add(root.val);
        //访问左子树，
        result.addAll(preorderTraversal(root.left));
        //访问右子树
        result.addAll(preorderTraversal(root.right));
        return result;
    }
}
