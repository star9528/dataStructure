import java.security.PrivateKey;
import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> A = new LinkedList<>();
    private Queue<Integer> B = new LinkedList<>();

    //入栈
    public void push(int x){
        A.offer(x);
    }

    //出栈
    public Integer pop(){
        if(empty()){
            return null;
        }
        while (A.size() > 1){
            Integer front = A.poll();
            B.offer(front);
        }
        int ret = A.poll();
        swapAB();
        return ret;
    }
    //交换两个队列的身份
    public void swapAB(){
        Queue<Integer> tep = A;
        A = B;
        B = tep;
    }

    //取栈顶元素
    public Integer top(){
        if(empty()){
            return null;
        }
        while (A.size() > 1){
            Integer front = A.poll();
            B.offer(front);
        }
        int ret = A.poll();
        B.offer(ret);
        swapAB();
        return ret;
    }
    //判断栈是否为空
    public boolean empty(){
        return A.isEmpty() && B.isEmpty();
    }
}
