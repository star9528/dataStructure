import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
public class Solution {
    public int singleNumber(int[] nums) {

//        int ret = 0;
//        for (int x : nums){
//            ret ^= x;
//        }
//        return ret;
   //上面这个是简单解法

        //1. 创建一个 Map 统计每个数字出现的次数，key 表示是当前的数字，value 表示这个数字出现的次数
        Map<Integer,Integer> map = new HashMap<>();
        //2.遍历数组，完成统计
        for (int x : nums) {
            Integer value = map.get(x);
            if (value == null){
                //当前这个数字在 map 中不存在。就新增一个键值对
                map.put(x,1);
            } else {
                //当前这个数字已经存在过了，把 value 加一即可
                map.put(x,value + 1);
            }
        }
        //3.遍历 map ，找到出现次数为 1 的数字
        for(Map .Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
//        Iterator<HashMap.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            HashMap.Entry<Integer,Integer> entry = iterator.next();
//            if (entry.getValue().equals(1)) {
//                return entry.getValue();
//            }
//        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = {1,2,3,2,1};
        System.out.println(s.singleNumber(array));
    }
}
