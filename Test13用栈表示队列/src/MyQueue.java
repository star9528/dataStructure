import java.util.Stack;

public class MyQueue {
    private Stack<Integer> A = new Stack<>();//用来入队列
    private Stack<Integer> B = new Stack<>();//用来出队列

    public void push(int x) {
        //当B不为空时，就直接将B中的元素放到A中，然后入栈，相当于入队列
        while(!B.empty()){
            int ret = B.pop();
            A.push(ret);
        }
        //当B为空时，直接对A进行入栈，相当于入队列
        A.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public Integer pop() {
        if(empty()){
            return null;
        }
        //当A不为空时，把A中的元素转移到B中，再在B中进行出栈操作，即为出队列操作
        while(!A.isEmpty()){
            int ret = A.pop();
            B.push(ret);
        }
        //当A为空时，直接对B进行出栈操作，即为移除队首元素
        int ret = B.pop();
        return ret;
    }

    public Integer peek() {
        if(empty()){
            return null;
        }
        while(!A.isEmpty()){
            int ret = A.pop();
            B.push(ret);
        }
        int ret = B.peek();
        return ret;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}
