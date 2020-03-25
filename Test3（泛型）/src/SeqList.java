public class SeqList {
    private Object[] data = new Object[10];
    private int size;

    public void add(Object elem){
        data[size] = elem;
        size++;
    }

    public Object get(int index){
        return data[index];
    }

    public static void main(String[] args) {
        SeqList s = new SeqList();
        //String 也是继承自Object
        // 调用add的时候相当于向上转型
        s.add("aaa");
        s.add("bbb");
        //调用get的时候返回的是Object，这里需要向下转型
        String str = (String)s.get(0);
    }
}
