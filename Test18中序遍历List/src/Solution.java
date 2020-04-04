import java.util.ArrayList;
import java.util.List;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
//中序遍历，返回类型为List<Integer>
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
        return result;
        }
        //访问左子树
        result.addAll(inorderTraversal(root.left));
        //访问根节点
        result.add(root.val);
        //访问右子树
        result.addAll(inorderTraversal(root.right));
        return result;
    }
}
