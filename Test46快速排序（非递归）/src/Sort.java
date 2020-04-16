import java.util.Arrays;
import java.util.Stack;
//快速排祖（非递归）
public class Sort {
    public static void quickSortByLoop (int[] array){
        //借助栈，模拟实现递归过程
        //stack 用来存放数组下标。通过下标来表示接下来要处理的区间
        Stack<Integer> stack = new Stack<>();
        //初始情况下，先把右侧下标入栈，再把左侧下标入栈，左右边界仍然构成前闭后闭区间
        stack.push(array.length - 1);
        stack.push(0);
        while (!stack.isEmpty()){
            int left = stack.pop();
            int right = stack.pop();
            if(left >= right){
                //此时数组只有一个或者没有元素
                continue;
            }
            //针对[beg,end]区间进行整理
            int index = partition(array,left,right);
            stack.push(right);
            stack.push(index + 1);

            stack.push(index - 1);
            stack.push(left);
        }

    }

    private static int partition(int[] array, int left, int right) {
        int beg = left;
        int end = right;
        int base = array[right];
        while (beg < end){
          while (beg < end && array[beg] <= base){
              beg++;
          }
          while (beg < end && array[end] >= base){
              end--;
          }
          swap(array,beg,end);
        }
        swap(array,beg,right);
        return beg;
    }

    private static void swap(int[] array, int beg, int end) {
        int temp = array[beg];
        array[beg] = array[end];
        array[end] = temp;
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        quickSortByLoop(array);
        System.out.println(Arrays.toString(array));
    }
}
