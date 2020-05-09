import java.util.Stack;
//栈的弹出压入序列
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        //创建一个栈,用于下面的比较的过程
        Stack<Integer> stack = new Stack<>();
        //如果两个数组的长度不同,则一定不符合题意
        if (pushA.length != popA.length) {
            return false;
        }
        int j = 0;
        //第一层循环是遍历压栈数组,每遍历一个元素都要入栈,然后与出栈数组比较
        //如果相同 就再把元素出栈,继续比较
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            //这里为了避免二层循环每次都从第一个元素开始,则把 j = 0 放在上面
            for (; j < popA.length ; j++) {
                //这里需要加一个stack.isEmpty(),避免两个数组的第一个元素相等的情况
               if (stack.isEmpty() || stack.peek() != popA[j]) {
                   break;
               }
               stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {4,5,3,2,1};
        Solution s = new Solution();
        boolean temp = s.IsPopOrder(a,b);
        System.out.println(temp);
    }
}
