
import java.util.Scanner;

class TreeNode{
    public char val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //这里的循环原因是OJ一般有多组输入
        while(scanner.hasNext()){
            //line 这个字符串就对应一组形如“abc##de#g##f###”的输入数据
           String line = scanner.next();
           TreeNode root = build(line);
           inOrder(root);
           //一定要注意输出数据格式，格式多个空格少个换行都是不行的
           System.out.println();

        }
    }

    private static void inOrder(TreeNode root) {
        System.out.println(root + " ");
        inOrder(root.left);
        inOrder(root.right);
    }
    private static  int index = 0;
    private static TreeNode build(String line) {
        //为了能在后面的递归创建过程中能时刻知道当前访问到line中的那个元素
        //使用一个专门的变量；来记录一下
        //通过下面的方法辅助完成递归
        index = 0;
        return createTreePreOrder(line);
    }
    private static TreeNode createTreePreOrder(String line) {
      //获取到当前处理到那个节点
      char cur = line.charAt(index);
      if (cur == '#'){
          return null;
      }

      TreeNode root = new TreeNode(cur);
      index++;
      root.left = createTreePreOrder(line);
      index++;
      root.right = createTreePreOrder(line);
      return root;
    }
}
