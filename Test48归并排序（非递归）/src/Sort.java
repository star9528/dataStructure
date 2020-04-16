import java.util.Arrays;

public class Sort {
    public static void mergeSortByLoop(int[] array) {
        //当gap为1时[0]和[1]，[2]和[3]，[4]和[5]，[6]和[7]分别进行合并
        //当gap为2时[0,1]和[2,3]，[4,5]和[6,7]分别进行合并
        //当gap为4时[0,1,2,3]h和[4,5,6,7,]进行合并
        for (int gap = 1;gap < array.length;gap *= 2) {
            //下面是gap分别为1,2,4时对相邻两组进行合并
            for (int i = 0;i < array.length;i += 2 * gap) {
                int beg = i;
                int mid = i + gap;
                int end = i + 2 * gap;
                //防止下标越界
                if (mid > array.length) {
                    mid = array.length;
                }
                if (end > array.length) {
                    end = array.length;
                }
                merge(array,beg,mid,end);
            }
        }
    }
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

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        mergeSortByLoop(array);
        System.out.println(Arrays.toString(array));
    }
}
