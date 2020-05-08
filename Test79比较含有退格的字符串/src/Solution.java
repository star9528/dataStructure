import java.util.Stack;
//给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
//注意：如果对空文本输入退格字符，文本继续为空
public class Solution {
    public boolean backspaceCompare(String S, String T) {
        //先将字符串转换为字符数组
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        //创建两个栈,对两个数组分别处理
        Stack<Character> stackS = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            if (s[i] != '#') {
                stackS.push(s[i]);
            } else if (!stackS.isEmpty()) {
                stackS.pop();
            }
        }
        Stack<Character> stackT = new Stack<>();
        for (int i = 0; i < t.length; i++) {
            if (t[i] != '#') {
                stackT.push(t[i]);
            } else if (!stackT.isEmpty()) {
                stackT.pop();
            }
        }
//        while (!stackS.isEmpty() && !stackT.isEmpty()) {
//            if (stackS.pop() != stackT.pop()) {
//                return false;
//            }
//        }
//        if (stackS.isEmpty() && stackT.isEmpty()) {
//            return true;
//        } else {
//            return false;
//        }
        //valueof() 方法是把数组转换为字符串
        return String.valueOf(stackS).equals(String.valueOf(stackT));
    }

    public static void main(String[] args) {
        String S = "a##c";
        String T = "#a#c";
        Solution s = new Solution();
        System.out.println(s.backspaceCompare(S,T));
    }
}
