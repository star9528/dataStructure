
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
//根据一棵树的前序遍历与中序遍历构造二叉树。
public class Solution {
    //index用来表示访问到树的第几个元素，即就是遍历到数组的第index + 1个，因为树就在数组中保存着
    private int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        return buildTreeHelper(preorder,inorder,0,inorder.length);
    }
    //left,right代表左右边界在[left,right)范围之内的元素就是树前序遍历每一个元素在数组中位置对应的下标
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int left, int right) {
        if(left >= right){
            //如果left>=right代表这是一个空树
            return null;
        }
        if(index >= preorder.length){
            //如果index>=preorder.length,表示数组也就是树已经被遍历完了
            return null;
        }
        //根据根节点的值，创建一个节点
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        //找出这个节点的值在中序遍历结果中的位置，这个值把inorder分成两部分
        //左边的为左子树，右边的为右子树
         int pos = find(inorder,left,right,root.val);
         //对左子树进行递归处理
         root.left = buildTreeHelper(preorder, inorder, left, pos);
         //对右子树进行递归处理
         root.right = buildTreeHelper(preorder, inorder, pos + 1, right);
         return root;
    }

    private int find(int[] inorder,int left,int right,int toFind) {
        for (int i = left; i < right; i++) {
            if(inorder[i] == toFind){
                return i;
            }
        }
        return -1;
    }
}
