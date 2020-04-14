import java.util.Arrays;
//堆排序
public class Sort {
    public static void heapSort(int[] array){
        //先建堆
        createHeap(array);
        //循环把堆顶元素交换到最后，并进行调整堆
        //循环此时是 length - 1.当堆中只剩一个元素时，也就一定是有序的了。
        for (int i = 0;i < array.length - 1;i++){
            //交换堆顶元素和堆的最后一个元素
            //堆的元素个数相当于array.length - 1
            //堆的最后一个元素下标array.length - 1 - i
            Swap(array,0,array.length - 1 - i);
            //交换完成后，堆的长度又减小了，为array.length - 1 - i
            //把最后一个元素从堆中删掉
            //数组中 [0,array.length - 1 - i)待排序区间
            //[array.length - 1 - i,array.length)已排序区间
            //[注意！！！]此处的边界条件特别容易弄错，因此可以代入数值去检验，
            // 例如当i= 0时，看逻辑是否正确
            shiftDown(array,array.length - 1 - i,0);
        }
    }

    private static void shiftDown(int[] array, int heapLength, int index) {
        //这里是升序排序，要建立大堆，之后的操作发生后才能变成升序
        //建大堆就要找到左右子树中较大的值，再和根节点比较
        int parent = index;
        int child = index * 2 + 1;
        while (child < heapLength){
            if (child + 1 < heapLength && array[child] < array[child + 1]){
                child = child + 1;
            }
            //条件结束意味着，child 就已经是左右子树比较大的值的下标
            if (array[parent] < array[child]){
                Swap(array,child,parent);
            } else {
                break;
            }
            parent =child;
            child = parent * 2 + 1;
        }
    }

    private static void createHeap(int[] array) {
        //从最后一个非叶子节点出发向前循环，依次进行向下调整
        for (int i = (array.length - 1 - 1) / 2;i >= 0;i--){
            shiftDown(array,array.length,i);
        }
    }

    public static void Swap(int[] array,int i,int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
