import java.util.Arrays;

public class Sort {
    public static void select(int[] array){
        for (int bound = 0;bound < array.length;bound++){
            //以bound位置的元素作为擂主。循环从待排序区间取出元素和擂主进行比较
            //如果打擂成功，就和擂主交换
            for(int cur = bound + 1;cur < array.length;cur++){
                if(array[bound] > array[cur]){
                    int temp = array[bound];
                    array[bound] = array[cur];
                    array[cur] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8,7,6,12,11,10};
        select(array);
        System.out.println(Arrays.toString(array));
    }
}
