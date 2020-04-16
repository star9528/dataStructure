import java.util.Arrays;
//归并排序
public class Sort {
    public static void mergeSort(int[] array) {
        mergeSortHelper(array,0,array.length);
    }
    //[low,mid)  有序区间
    //[mid,high) 有序区间
    //把这两个有序区间合并成   一个有序区间
    public static void merge(int[] array, int low,int mid,int high){
        int[] output = new int[high - low];
        int outputIndex = 0;//记录当前 output 数组中被放入多少个元素了
        int cur1 = low;
        int cur2 = mid;
        while (cur1 < mid && cur2 < high){
             if (array[cur1] <= array[cur2]){
                 output[outputIndex] = array[cur1];
                 outputIndex++;
                 cur1++;
             } else {
                 output[outputIndex] = array[cur2];
                 outputIndex++;
                 cur2++;
             }
        }
        while (cur1 < mid){
            output[outputIndex] = array[cur1];
            outputIndex++;
            cur1++;
        }

        while (cur2 < high){
            output[outputIndex] = array[cur2];
            outputIndex++;
            cur2++;
        }
        for (int i = 0;i < high - low;i++){
            array[low + i] = output[i];
        }
    }
    //辅助递归的方法
    private static void mergeSortHelper(int[] array, int low, int high) {
        if (high - low <= 1){
            return;
        }
        int mid = (high + low) / 2;
        //这个方法执行完毕，说明low到mid排序完毕
        mergeSortHelper(array,low,mid);
        //这个方法执行完毕，说明mid到high排序完毕
        mergeSortHelper(array,mid,high);

        //把左右区间归并排序完了，说明左右区间已经是有序区间了。
        //接下来就可以针对两个有序区间进行合并了
        merge(array,low,mid,high);
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
