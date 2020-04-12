//优先队列
public class MyPriorityQueue {
    //array看起来是一个数组，其实表示的是一个堆结构
    private int[] array = new int[100];
    private int size = 0;

    //入队列
    public void offer(int x) {
        array[size] = x;
        size++;
        //把新加入的元素向上调整
        shiftUp(array,size - 1);
    }
    //向上调整，建大堆
    public static void shiftUp(int[] array,int index){
        int child = index;
        int parent = (child - 1) / 2;
        while (child > 0){
            if(array[parent] < array[child]){
                //当前不符合大堆要求
                int tem = array[parent];
                array[parent] = array[child];
                array[child] = tem;
            } else {
                //当前父节点比子节点大，这时候说明整个数组已经符合堆得结构了
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    //出队列
    public int poll(){
       //下标为0的元素为队首元素，删掉的同时，我们也希望剩下的结构仍然是个堆。
        int oldValue = array[0];
        array[0] = array[size - 1];
        size--;
        shiftDown(array,size,0);
        return oldValue;
    }

    public static void shiftDown(int[] array,int size,int index){
        int parent = index;
        int child  = parent * 2 + 1;
        while(child < size){
            if(child + 1 < size && array[child + 1] > array[child]){
                child = child + 1;
            }
            if(array[parent] < array[child]){
                int temp = array[child];
                array[child] = array[parent];
                array[parent] = temp;
            }else{
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }

    //取队顶元素
    public int peek(){
        return array[0];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        MyPriorityQueue queue = new MyPriorityQueue();
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(6);
        queue.offer(8);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            System.out.println(cur);
        }
    }
}
