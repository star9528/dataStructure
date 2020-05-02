import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int[] popA) {
        if (pushA.length != popA.length) {
            return false;
        }
        if (pushA.length == 0 && popA.length == 0) {
            return true;
        }
        if (pushA.length == 1 && popA.length == 1) {
            return true;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        for (int i = 0;i < pushA.length;i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && (stack.peek() == popA[index])) {
                stack.pop();
                index++;
            }
        }
        if (stack.isEmpty() && (index - 1 == popA.length - 1)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        Solution s = new Solution();
        boolean temp = s.IsPopOrder(pushA,popA);
        System.out.println(temp);
    }
}
