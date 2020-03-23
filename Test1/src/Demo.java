import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Demo {
    public static void main(String[] args) {
        //这个代进行了向上转型，new的对象是ArrayList，
        // 使用的是Collection类型的引用来保存
        //此处应用到“泛型”，“泛型”写一个类/方法，
        // 让这个方法和类可以支持多种不同类型的数据
        //<String>是泛型参数（必须是引用类型），
        // collection里包含着若干个String对象
        //1.创建Collection
        Collection<String> collection = new ArrayList<>();
        //2.使用size方法
        System.out.println(collection.size());
        //3.使用isEmpty方法(为空返回true，否则返回false)
        System.out.println(collection.isEmpty());
        //4.使用add方法  插入元素(add中的参数类型必须和泛型参数匹配)
        collection.add("我");
        collection.add("爱");
        collection.add("java");
        //5.再次使用size 和isEmpty
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
        //6.可以toArray把collection转换为数组。
        //得到一个Object[]数组
        Object[] array = collection.toArray();
        System.out.println(Arrays.toString(array));
        //7.可以直接使用for循环来遍历集合中的元素,
        // 若用的普通的for循环要用到迭代器
        for (String s:collection) {
          //s就会分别指向collection中的每一个元素
            System.out.println(s);
        }
        //8.使用contains方法判定元素是否存在(比较的是对象的值，不是身份)
        System.out.println(collection.contains("我"));
        System.out.println("==============删除之后=============");
        //9.使用remove来删除元素
        collection.remove("我");
        for (String s:collection) {
            System.out.println(s);
        }
        //10.使用clear法，清空所有元素
        collection.clear();
        System.out.println("==========清空所有元素之后=========");
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
    }
}
