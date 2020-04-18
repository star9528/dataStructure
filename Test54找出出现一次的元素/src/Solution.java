public class Solution {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int x : nums) {
            ret ^= x;
        }
        return ret;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = {1,2,3,2,1};
        System.out.println(s.singleNumber(array));
    }
}
