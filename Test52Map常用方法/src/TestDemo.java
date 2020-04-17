import java.util.HashMap;
import java.util.Map;
//Map常用方法
public class TestDemo {
    public static void main(String[] arg) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"ha");
        //key 重复，原来的key对应的value会被覆盖
        map.put(1,"hello");
        map.put(3,"java");
        map.put(2,"world");
        //遍历打印 set
        System.out.println(map);
        //根据 key 获取 value 的值
        System.out.println(map.get(1));
        //如果找不到返回null
        System.out.println(map.get(9));

        //打印所有的key
        for (Integer key : map.keySet()){
            System.out.println(key);
        }
        //打印所有的 value
        for (String value : map.values()) {
            System.out.println(value);
        }
        //按照 key - value 映射关系打印
        for (Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
