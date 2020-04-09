
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
// 要求不能创建任何新的结点，只能调整树中结点指针的指向。
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        //基于递归的方式来完成双向链表构建，为了保证有序性，需要中序遍历
        //二叉搜索树的中序遍历结果是有序的
        if(pRootOfTree == null){
            return null;
        }
        if(pRootOfTree.left == null && pRootOfTree.right == null){
            return pRootOfTree;
        }
        //最终的链表 => 左子树的链表 + 根节点 + 右子树的链表
        //就需要用左子树的链表的的尾巴和根节点相连
        //再用右子树的头部和根节点相连
        //1.先递归处理左子树
        //left 就是左子树这个链表的根节点
        TreeNode left = Convert(pRootOfTree.left);
        //2.需要找到左子树链表的尾节点
        TreeNode leftTail = left;
        //right 相当于链表的next
        while(leftTail != null && leftTail.right != null){
            leftTail = leftTail.right;
        }
        //循环结束后，leftTail 就指向左侧链表的尾部
        //3.把左子树和当前节点连在一起
        if(left != null){
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        //4.递归转换右子树，把右子树也变成双向链表
        TreeNode right = Convert(pRootOfTree.right);
        //5.把当前节点于右子树连在一起
        if(right != null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        //6.最终返回  新的链表的头结点
        //如果left为空，链表的头结点就是 pRootOfTree
        //如果left非null，头结点就是left
        return left == null ? pRootOfTree : left;
    }
}
