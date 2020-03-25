import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("及时雨","宋江");
        map.put("玉麒麟","卢俊义");
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        //如果插的键值对Key已经存在，就会覆盖原有的value
        map.put("及时雨","晁盖");
        System.out.println(map);
    }
}
