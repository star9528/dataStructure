import java.util.Stack;
//根据逆波兰表示法，求表达式的值。
public class Solution {
    public int evalRPN(String[] tokens) {
        //创建一个栈
        Stack<Integer> stack = new Stack<>();
        //定义两个变量,方便下面计算
        Integer t1 = 0,t2 = 0;
        //循环遍历每一个数组元素
        for (String e : tokens) {
            switch(e) {
                case"+":
                    //如果 e 是 "+",则要出栈两个元素,先出栈的放在 "+" 后面
                    t2 = stack.pop();
                    t1 = stack.pop();
                    //运算结果继续入栈
                    stack.push(t1 + t2);
                    break;
                case"-":
                    //如果 e 是 "+",则要出栈两个元素,先出栈的放在 "-" 后面
                    t2 = stack.pop();
                    t1 = stack.pop();
                    stack.push(t1 - t2);
                    break;
                case"*":
                    //如果 e 是 "+",则要出栈两个元素,先出栈的放在 "*" 后面
                    t2 = stack.pop();
                    t1 = stack.pop();
                    stack.push(t1 * t2);
                    break;
                case"/":
                    //如果 e 是 "+",则要出栈两个元素,先出栈的放在 "/" 后面
                    t2 = stack.pop();
                    t1 = stack.pop();
                    stack.push(t1 / t2);
                    break;
                default:
                    //1.如果不是运算符,就用 Integer.valueOf(e)
                    // 把字符串数组转换为整形数组,放在栈中
                    stack.push(Integer.valueOf(e));
                    break;
            }
        }
        return stack.pop();
    }
}
