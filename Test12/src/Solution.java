import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
//括号匹配问题
public class Solution {
    public boolean isValid(String s) {
        //1.先创建一个栈，栈中保存字符类型即可
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> m = new HashMap<>();
        m.put('(',')');
        m.put('[',']');
        m.put('{','}');
        //2.循环遍历字符串中的每一个字符
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            //3.判定c是否为左括号，如果是左括号就入栈
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
                continue;//进入下一次循环，取出下一个字符
            }
            if(stack.empty()){
                //如果发现当前字符串为空，说明字符串非法
                return false;
            }
            //4.判定c是否是右括号，如果是就取出栈顶元素来对比一下
            Character top = stack.pop();
            //1)合法情况一
//            if(top == '(' && c == ')'){
//                continue;
//            }
//            //2)合法情况二
//            if(top == '[' && c == ']'){
//                continue;
//            }
//            //3)合法情况三
//            if(top == '{' && c == '}'){
//               continue;
//            }
            if(m.get(top) == c){
               continue;
            }
            return false;
        }
        if(!stack.empty()){
            return false;
        }
        return true;
    }
}
