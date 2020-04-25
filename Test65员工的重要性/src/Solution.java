import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

public class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map=new HashMap<>();
        for(Employee e:employees) map.put(e.id,e);
        return getImportance(map,id);
    }

    public int getImportance(Map<Integer,Employee> employees, int id) {
        Employee employee = employees.get(id);
        int result=employee.importance;
        for(int i=0;i<employee.subordinates.size();i++){
            Integer subId = employee.subordinates.get(i);
            result+=getImportance(employees, subId);
        }
        return result;
    }
}
