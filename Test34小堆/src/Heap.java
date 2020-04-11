import java.util.Arrays;

//借助向下调整，可以把数组构建成堆（小堆）
public class Heap {
    //size 表示数组中有多少有效元素
    //index 表示从哪个位置的下标开始调整
    public static void shifDown(int[] array,int size,int index){
        int parent = index;
        int child = 2 * parent + 1;//根据parent下标找到左子树的下标
        while(child < size){
            //比较左右子树，找到较小值
            //array[child]) 右子树   array[child + 1] 左子树
            if(child + 1 < size && array[child + 1] < array[child]){
                child = child + 1;
            }
            //经过上面的比较，已经不知道child是左子树还是右子树
            //知道的是child下标对应一定是左右子树最小值的下标

            //拿 child 位置的元素 和 parent位置的元素进行比较
            if(array[child] < array[parent]){
                //不符合小堆规则的，就交换父子节点
                int tem = array[child];
                array[child] = array[parent];
                array[parent] = tem;
            } else {
                //调整完毕，不需要继续了
                break;
            }
            //更新parent和child
            parent = child;
            child = parent * 2 + 1;
        }
    }
    //构建堆
    public static void createHeap(int[] array,int size){
        for(int i = (size - 1 - 1) / 2;i >= 0;i--){
            shifDown(array,size,i);
        }
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        createHeap(array,array.length);
        System.out.println(Arrays.toString(array));
    }
}
