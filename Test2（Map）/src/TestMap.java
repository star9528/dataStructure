import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        //1.创建Map实例，泛型参数有两个，第一个是key，
        // 第二个是value的类型，
        // key value这种结构最主要的目的是根据key找到对应的的Value
        Map<String,String> map = new HashMap<>();
        //2.使用size获取元素的个数
        System.out.println(map.size());
        //3.使用isEmpty方法（若为空返回true，否则返回false）,
        // 如果key不存在，则返回null
        System.out.println(map.isEmpty());
        //4.使用put把键值对存放进去
        map.put("及时雨","宋江");
        map.put("玉麒麟","卢俊义");
        map.put("智多星","吴用");
        map.put("入云龙","公孙胜");
        //5.使用get方法，根据key来找到对应的value
        //getOrDefault   如果key不存在，返回默认值
        System.out.println(map.get("及时雨"));
        System.out.println(map.get("大刀"));
        System.out.println(map.getOrDefault("行者","武松"));
        //6.通过containsKey和containsValue来判定某个值是否存在
        //containsKey执行效率高，containsValue执行效率低
        System.out.println(map.containsKey("智多星"));
        System.out.println(map.containsValue("公孙胜"));
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        //7.foreach遍历 Map 中的所有键值对
        //Entry：表示一个“条目”，也就是一个键值对
        //map.entrySet 获取到所有的键值对
        //Map中的顺序和插入顺序无关，取决于具体的实现方式。
        for (Map.Entry<String,String> entry:map.entrySet()) {
            System.out.println(entry);
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        map.remove("入云龙");
        for (Map.Entry<String,String> entry:map.entrySet()) {
            System.out.println(entry);
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        map.clear();
    }
}
