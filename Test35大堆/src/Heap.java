import javafx.scene.Parent;

import java.util.Arrays;
//大堆
public class Heap {
    //size 表示数组中有多少有效元素
    //index 表示从哪个位置的下标开始调整
    public static void shifDown(int[] array,int size,int index){
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
    public static void createHeap(int[] array,int size){
        for (int i = (size - 1 - 1) / 2; i >= 0; i--) {
            shifDown(array,size,i);
        }
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        createHeap(array,array.length);
        System.out.println(Arrays.toString(array));
    }
}
