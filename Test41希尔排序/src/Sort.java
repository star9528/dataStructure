import java.util.Arrays;

public class Sort {
    public static void shellSort(int[] array){
        int gap = array.length / 2;
        while(gap > 1){
            //需要循环进行分组插排
            insertSortGap(array,gap);
            gap = gap / 2;
        }
        insertSortGap(array,1);
    }

    public  static void insertSortGap(int[] array,int gap){
        for(int bound = gap;bound < array.length;bound++){
            int v = array[bound];
            int cur = bound - gap;
            for(;cur >= 0;cur -= gap){
                if(array[cur] > v){
                    array[cur + gap] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + gap] = v;
        }
    }
    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8,7,6,12,11,10};
        Sort.shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}
