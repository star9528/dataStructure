import java.util.Stack;

public class MinStackTest {
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();
    /** initialize your data structure here. */
    public void push(int x) {
        A.push(x);
        if(B.isEmpty()){
            B.push(x);
            return;
        }
        int min = B.peek();
        if(min > x){
            B.push(x);
        } else{
            B.push(min);
        }
    }

    public Integer pop() {
        if(A.isEmpty()){
            return null;
        }
        int ret1 = A.pop();
        B.pop();
        return ret1;
    }

    public Integer top() {
        if(A.isEmpty() ){
            return null;
        }
        int ret1 = A.peek();
        return ret1;
    }

    public Integer getMin() {
        if(B.isEmpty()){
            return null;
        }
        return B.peek();
    }

    public void test(){
        MinStackTest m = new MinStackTest();

    }

    public static void main(String[] args) {
        MinStackTest m = new MinStackTest();
        m.push(-2);
        m.push(0);
        m.push(-3);
        System.out.println(m.getMin());
        m.pop();
        m.top();
        System.out.println(m.getMin());
    }
}
