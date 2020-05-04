public class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        //如果数组中没有元素,则不符合条件
        if (A.length == 0) {
            return false;
        }
        int sum = 0;
        for (int i = 0;i < A.length;i++) {
            sum += A[i];
        }
        //当数组中的元素和不为3的倍数时,则一定不符合条件
        if (sum % 3 != 0) {
            return false;
        }
        //当数组中的元素和是3的倍数时
        int left = 0;
        int right = A.length - 1;
        int sumLeft = A[left];
        int sumRight = A[right];
        //这里必须满足 left + 1 < right ,因为要把数组分为三部分,
        //如果是 left < right,就会出现 [3,3] 这种情况
        while (left + 1< right) {
            //情况一,左右都为 sum 的三分之一,中间剩余的也一定是 sum 的三分之一
            if (sumRight == sum / 3 && sumLeft == sum / 3) {
                return true;
            }
            //情况二,左侧不为 sum 的三分之一,进行求和
            if (sumLeft != sum / 3) {
                sumLeft += A[++left];
            }
            //情况二,右侧不为 sum 的三分之一,进行求和
            if (sumRight != sum / 3) {
                sumRight += A[--right];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {3,3,6,5,-2,2,5,1,-9,4};
        Solution s = new Solution();
        boolean temp = s.canThreePartsEqualSum(array);
        System.out.println(temp);
    }
}
