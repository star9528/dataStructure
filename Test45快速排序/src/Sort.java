import java.util.Arrays;
//快速排序
public class Sort {
    public static void quickSort (int[] array){
        //辅助完成递归过程
        quickSortHelper (array,0,array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if(left >= right){
            //区间有0个元素或1个元素，此时不需要排序
            return;
        }
        //针对[left,right]区间进行整理
        int index = partition (array,left,right);
        quickSortHelper(array,left,index - 1);
        quickSortHelper(array,index + 1,right);

    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int base = array[right];
        while (i < j){
            //从左往右找到比此基准值大的元素
            while (i < j && array[i] <= base){
                i++;
            }
            //当上面得循环结束时，i要么和j重合，要么i指向一个大于base值

            //从右往左找到比此基准值大的元素
            while (i < j && array[j] >= base){
                j--;
            }
            //当上面得循环结束时，i要么和j重合，要么j指向一个小于base值

            //交换i和j对应的值
            swap(array,i,j);
        }
        swap(array,i,right);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
