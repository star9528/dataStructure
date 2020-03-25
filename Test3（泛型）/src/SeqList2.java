//为了能够写一个类/方法就能同时支持多种不同类型的对象，于是就引入泛型
//泛型其实就是从语法层面上对Object进行一个简单的包装，
// 编译过程帮我们自动加上一些编译器的检查类型，
// 自动帮我们完成一系列类型转换工作
//对SeqList进行升级
//<E>中E是泛型参数（相当于是一个形参，
// 需要在真正对该类型进行实例化的时候确定实参）
//泛型参数一般常见的名字：E T KEY VALUE ......
public class SeqList2<E> {
    //当前这个data的类型是啥，可以就当成一个Object[].
    // Object 具体代表的是那种类型，
    // 需要最终在实例SeqList的时候才能确定下来
    //E 这样的泛型参数是不能被直接实例化的。
    // 当前还不知道E到底是啥类型
    private E[] data = (E[])new Object[10];
    private int size;

    public void add(E elem){
        data[size] = elem;
        size++;
    }

    public E get(int index){
        return data[index];
    }

    public static void main(String[] args) {
//        SeqList2<String> s = new SeqList2<>();
//        //String 也是继承自Object
//        // 调用add的时候相当于向上转型
//        s.add("aaa");
//        s.add("bbb");
//        //调用get的时候返回的是Object，这里需要向下转型
//        String str = s.get(0);
//
//        SeqList2<Animal> animals = new SeqList2<>();
//        animals.add(new Animal());
//        animals.add(new Animal());
//        Animal animal = animals.get(0);

        //int的包装类是Integer
        SeqList2<Integer> IntegerSeqList = new SeqList2<>();
        //这个操作相当于把int => Integer:装箱
//        Integer num = new Integer(10);
//        Integer num = Integer.valueOf(10);//valueOf是一个静态方法
        Integer num = 10;//现在常用
        IntegerSeqList.add(num);

        //把Integer => int :拆箱(nuboxing)
        num = IntegerSeqList.get(0);
        //int value = num.intValue();//手动拆箱
        int value = num;//自动拆箱
    }
}
//如果是int，double这些基础类型，
//创建一个类来表示（标准库中已经创建好了）叫做包装类
