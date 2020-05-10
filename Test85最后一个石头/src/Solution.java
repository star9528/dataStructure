import java.util.Arrays;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        //当数组中只有一个元素时,就直接返回这个元素
        if (stones.length == 1) {
            return stones[stones.length - 1];
        }
        Arrays.sort(stones);
        int index = stones.length - 1;//最重的石头
        //当第二重的石头为 0 时,执行结束
        while (stones[index - 1] != 0) {
            int x = stones[index - 1];
            int y = stones[index];
            if (x == y) {
                stones[index - 1] = stones[index] = 0;
            }
            if (x < y) {
                stones[index - 1] = 0;
                stones[index] = y - x;
            }
            Arrays.sort(stones);
        }
        return stones[index];
    }

    public static void main(String[] args) {
        int[] arr = {2,7,4,1,8,1};
        Solution s = new Solution();
        int t = s.lastStoneWeight(arr);
        System.out.println(t);
    }
}
