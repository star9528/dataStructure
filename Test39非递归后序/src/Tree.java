import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Tree {
    public static void postOrderByLoop(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        //prev 记录了当前访问过的上几个节点（即将被访问的元素的前一个节点）
        TreeNode prev = null;
        while(true){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            if(stack.isEmpty()){
                break;
            }
            //拿出栈顶元素的值，看看能不能访问
            TreeNode top = stack.peek();
            if(top.right == null || prev == top.right){
                //此时这个栈顶元素可以访问
                System.out.print(top.val + " ");
                stack.pop();
                //时刻维护好 prev 指向已经遍历完元素的最后一个
                prev = top;
            } else {
                cur = top.right;
            }
        }
    }
    public static TreeNode build(){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        c.right = f;
        return a;
    }

    public static void main(String[] args) {
        TreeNode root = build();
        postOrderByLoop(root);
    }
}
