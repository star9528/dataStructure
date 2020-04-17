import java.util.Arrays;
//给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
// 找出只出现一次的那两个元素。
public class Solution {
    public int[] singleNumber(int[] nums) {
        //1.把所有数字异或到一起
        int ret = 0;
        for (int x : nums) {
            ret ^= x;
        }
        //2.找到某位为一的 比特位
        int bit = 1;
        int i = 0;
        for (;i < 32;i++) {
            if ((ret & (bit << i)) != 0) {
                break;
            }
        }
        //循环结束后，bit 中的值，就是刚找到的某一位为 1 的值
        //进行分组
        int a = 0;
        int b = 0;
        for (int x : nums) {
            if ((x & (bit << i)) != 0) {
                //第一组，指定为 1
                a ^= x;
            } else {
                //第二组，指定为 0
                b ^= x;
            }
        }
        int[] array = {a,b};
        return array;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = {1,2,3,2,1,6};
        int[] result = s.singleNumber(array);
        System.out.println(Arrays.toString(result));
    }
}
