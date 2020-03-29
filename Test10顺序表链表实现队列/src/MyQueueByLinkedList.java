public class MyQueueByLinkedList {
    //Node 这个类叫做内部类。定义某个类或者方法中的类
    //static 的效果就是：创建Node的实例不依赖MyQueueByLinkedList这个类的实例

    static class Node{
        public int val;
        Node next = null;

        public Node (int val){
            this.val = val;
        }
    }

    //创建一个链表，就得有头结点
    //基于链表来实现队列，可以从尾部入队，从头部出队，也可以从头部入队，从尾部出队
    //无论哪种方式，最好把头和尾都记下类
    private Node head = null;
    private Node tail = null;

    //入队(尾入队头出队)
    public void offer(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = tail.next;
    }
    //出队
    public Integer poll(){
        //如果当前队列就是空队列
        if(head == null){
            return null;
        }
        int ret = head.val;
        head = head.next;
        if(head == null){
            //删除当前元素后，队列成了空队列
            tail = null;
        }
        return ret;
    }
    //取队首元素
    public Integer peek(){
        if(head == null){
            return null;
        }
        return head.val;
    }
}
