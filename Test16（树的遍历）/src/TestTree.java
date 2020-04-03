
class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}

public class TestTree {
    //构造树
    public static Node build (){
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        g.right = h;
        c.right = f;

        return a;
    }
    //先序遍历
    public static void preOrderTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    //中序遍历
    public static void inOrderTraversal(Node root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }
    //后序遍历
    public static void postOrderTraversal(Node root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    //求二叉树节点个数
    public static  int size( Node root){
      if(root == null){
          return 0;
      }
      //访问根节点：此处的访问操作应该是计数器 + 1
      // 整个树的节点 = 根节点的个数（1） + 左子树节点的个数 + 右节点的节点个数
      return 1 + size(root.left) + size(root.right);
    }

    //求叶子节点的个数
    //root的叶子节点 = root.left的叶子结点 + root.right的叶子结点
    public static int leafSize(Node root){
        if(root == null){
            return 0;
        }
        //此时只有根节点，则根节点就是叶子结点
        if(root.left == null && root.right == null){
            return 1;
        }
        return leafSize(root.left) + leafSize(root.right);
    }

    //求二叉树第 K 层节点个数
    // 若K<1,则为空树，若k == 1，则为根节点的个数为1
    //第K层节点数 = 左子树的第K - 1层节点个数 + 右子数的第K - 1层节点个数
    public static int getKLevelSize(Node root,int k){
        if(k < 1 || root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return getKLevelSize(root.left,k - 1) + getKLevelSize(root.right,k - 1);
    }

    //在二叉树中查找指定元素
    public static Node find(Node root,char toFind){
        if(root == null){
            return null;
        }
        if(root.val == toFind){
            return root;
        }
        //分别递归的取查找左右树
        Node result = find(root.left,toFind);
        if(result != null){
            return result;
        }
        return find(root.right,toFind);
    }

    public static void main(String[] args) {
        Node node  = build();
        System.out.println("先序遍历：");
        preOrderTraversal(node);
        System.out.println();

        System.out.println("中序遍历：");
        inOrderTraversal(node);
        System.out.println();

        System.out.println("后序遍历：");
        postOrderTraversal(node);
        System.out.println();

        System.out.println(size(node));
        System.out.println(leafSize(node));
        System.out.println(getKLevelSize(node,3));
        System.out.println(find(node,'F'));
    }
}
