import java.util.*;
//查找和最小的 K 对数字
public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //k 表示优先队列的长度,
        //后面的一长串表示入队的元素,这个入队的元素要比较大小,比较方式是先求和再比较大小,
        //下面的方法的重写就是为了重新规定比较的方式
        PriorityQueue<int[]> queue = new PriorityQueue<>(k,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1,int[] o2) {

                return sum(o2) - sum(o1);
            }
        });
        for (int i = 0;i < nums1.length;i++) {
            for (int j = 0;j < nums2.length;j++) {
                int[] temp = new int[] {nums1[i],nums2[j]};
                //当队列里面的元素小于 k 时,第一个元素就直接加入,从第二个元素开始要比较大小,进行排序,建大堆
                if (queue.size() < k) {
                    queue.add(temp);
                } else
                    //如果 小于队头元素,就把队头出队列,再把这个歌元素入队列
                if (sum(temp) < sum(queue.peek())) {
                    queue.poll();
                    queue.add(temp);
                }
            }
        }
        //把类型转换为 List<List<Integer>> 进行返回
        List<List<Integer>> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            List<Integer> t = new ArrayList<>();
            int[] arr = queue.poll();
            t.add(arr[0]);
            t.add(arr[1]);
            res.add(t);
        }
        return res;
    }
    public int sum (int[] o) {
        return o[0] + o[1];
    }

    public static void main(String[] args) {
        int[] arr1 = {1,1,2};
        int[] arr2 = {1,2,3};
        Solution s = new Solution();
        List<List<Integer>> temp = s.kSmallestPairs(arr1,arr2,2);
        System.out.println(Arrays.toString(new List[]{temp}));
    }
}
