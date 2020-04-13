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
    public static void inOrderByLoop(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(true){
            //1.循环往左找，把路径上遇到的节点都入栈
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //2.如果当前栈为空，遍历就结束了
            if(stack.isEmpty()){
                break;
            }
            //3.取栈顶元素并访问
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");

            //4.从当前节点的右子树再出发继续刚才的过程
            cur = top.right;
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
        inOrderByLoop(root);
    }
}
