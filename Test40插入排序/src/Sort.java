import java.util.Arrays;
//插入排序
public class Sort {
    public static void insertSort(int[] array){
        //通过bound分出两个区域
        //[0,bound)已排序区间
        //[bound,array.length)待排序区间
        for(int bound = 1;bound < array.length;bound++){
            int v = array[bound];
            int cur = bound - 1;//已排序区间的最后一个元素下标
            for(;cur >= 0;cur--){
                //如果把这里的 < 改成 <= ,这样的插入排序就不是稳定的
                if (v < array[cur]) {
                    array[cur + 1] = array[cur];
                } else {
                    //此时已经找到了合适的位置
                    break;
                }
            }
            array[cur + 1] = v;
        }
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        Sort.insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
