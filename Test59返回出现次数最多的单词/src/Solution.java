
import java.util.*;
//给一非空的单词列表，返回前 k 个出现次数最多的单词。
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //1.先统计每个单词出现的次数
        Map<String,Integer> map = new HashMap<>();
        for (String s : words) {
            Integer count  = map.getOrDefault(s,0);
            map.put(s,count + 1);
        }
        //2.把刚才统计到的字符串内容放到 ArrayList 中
        //keySet 相当于得到一个 Set,Set 中存放的就是所有的key
        ArrayList<String> arrayList = new ArrayList<>(map.keySet());
        //3.按照刚才字符串出现的次数，针对 arrayList 进行排序
        //  sort 默认是按照元素的自身大小进行升序排列（String 的字典序）
        //  此处我们需要按照 字符串 出现的次数来降序排序。也就是通过比较器自定制比较规则
        //Collections.sort(arrayList,new MyComparator(map));
        // 下面的代码创建了一个匿名内部类
        // 不知道这个类的名字，但是知道知道这个类实现了 Comparator 接口
        // 啥时候需要用？这个类只需要用一次，用完之后就丢了。这时候就可以用匿名内部类。
//
        // lambda 表达式。本质上就是一个匿名方法。
        //o1,o2 的类型就是 String 类型
        Collections.sort(arrayList, (o1, o2) -> {
            int count1 = map.get(o1);
            int count2 = map.get(o2);
            if (count1 == count2) {
                return o1.compareTo(o2);
            }
            return count2 - count1;
        });
        return arrayList.subList(0,k);
    }
//    static class MyComparator implements Comparator<String> {
//        private Map<String,Integer> map;
//
//        public MyComparator(Map<String, Integer> map) {
//            this.map = map;
//        }
//
//        @Override
//        public int compare(String o1,String o2) {
//            int count1 = map.get(o1);
//            int count2 = map.get(o2);
//            if (count1 == count2) {
//                return o1.compareTo(o2);
//            }
//            return count2 - count1;
//        }
//    }
}
