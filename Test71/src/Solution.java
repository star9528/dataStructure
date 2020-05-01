import java.util.HashMap;
import java.util.List;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

public class Solution {
    public int getImportance(List<Employee> employees, int id) {
        //创建一个HashMap,键为 id, 值为读取到的List中的内容
        HashMap<Integer,Employee> map = new HashMap<>();
        //读取 List 中的内容
        for (Employee e : employees) {
            //把 list 中的数据取出来放在 map 中
            map.put(e.id,e);
        }
        //把 map 和员工1的id都传入
        return getImportance2(map,id);
    }

    private int getImportance2(HashMap<Integer,Employee> map, int id) {
        //根据 id 找到对应的键值,相当于根据 id 找到
        // [[1, 5, [2, 3]]      [2, 3, []]     [3, 3, []]]
        Employee employee = map.get(id);
        //再找到上面的每一组对应的 重要度
        int result = employee.importance;
        //每一个组都有下属的 id,下面是一个循环,
        // 用来处理下面本组员工相邻的下属员工,这两个下属同一级别
        for (int i = 0;i < employee.subordinates.size();i++) {
            //用来记录每一个下属的 id ,用于在下面递归中下属找自己的下属
            Integer subId = employee.subordinates.get(i);
            //对 重要程度进行累加
            result += getImportance2(map,subId);
        }
        return result;
    }

}
