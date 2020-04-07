import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
//完全二叉树
public class Solution {
    public boolean isCompleteTree(TreeNode root){
        if(root == null){
            return true;
        }
        boolean isSecondStep = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(!isSecondStep){
                //这是第一阶段
                if(cur.left != null && cur.right != null){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else
                    if(cur.left != null && cur.right == null){
                        //当前只有左子树没有右子树
                        //进入第二阶段
                        isSecondStep = true;
                        queue.offer(cur.left);
                    }else if(cur.left == null && cur.right != null){
                        //当前只有右子树没有左子树
                        return false;
                    }else{
                        //当前cur.left == null && cur.right == null
                        //即左右子树都为空
                        isSecondStep = true;
                    }
            }else{
                //第二阶段
                //要求二阶段中任何一个节点都必须没有子树
                //只要找到某个节点带子树，就说明找到了反例
                if(cur.left != null || cur.right != null){
                    return false;
                }
            }
        }
        //最后整个树都遍历完了，也没找到返利，
        // 最终就返回return true，认为是完全二叉树
        return true;
    }
}
