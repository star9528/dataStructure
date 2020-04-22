
//通过开散列的方式来处理 hash 冲突
public class MyHashMap {
    static class Node {
        public int key;
        public int value;

        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //array 就是 hash 表的本体。数组的每个元素又是链表的头结点。
    private Node[] array = new Node[101];
    private int size = 0;//表示 hash 表中的元素个数
    private static final double LOAD_FACTOR = 0.75;

    private int hashFunc(int key) {
        //实际的 hashFunc 可能会比较复杂
        return key % array.length;
    }

    //如果 key 已经存在，就修改当前的 value 值
    //如果 key 不存在，就插入新的键值对
    public void put(int key,int value) {
        //1.需要把 key 映射成为数组下标\
        int index = hashFunc(key);
        //2.根据下标找到对应的链表
        Node list = array[index];
        //3.当前 key 在链表中是否存在
        for (Node cur = list;cur != null;cur = cur.next) {
            if (cur.key == key) {
                //key 已经存在，直接修改value
                cur.value = value;
                return;
            }
        }
        //如果循环结束，也没有找到相同 key 的节点，直接插入到指定链表的头部。
        Node newNode = new Node(key,value);
        newNode.next = list;
        array[index] = newNode;
        size++;

        if (size / array.length > LOAD_FACTOR) {
            resize();
        }
    }

    private void resize() {
        Node[] newArray = new Node[2 * array.length];
        //把 hash 表中的所有元素搬运到新的数组上
        for (int i = 0;i < array.length;i++) {
            for (Node cur = array[i]; cur != null;cur = cur.next) {
                int index = cur.key % newArray.length;
                Node newNode = new Node(cur.key,cur.value);
                newNode.next = newArray[index];
                newArray[index] = newNode;
            }
        }
        //让新的数组代替哦原来的数组
        array = newArray;
    }

    //根据 key 查找指定元素。入果查找到返回 value，如果没找到返回错 null。
    public Integer get(int key) {
        //1.先计算 key 对应的 下标
        int index = hashFunc(key);
        //2.根据下表找到对应的链表
        Node list = array[index];
        //3.在链表中查找指定元素
        for (Node cur = list;cur != null;cur = cur.next) {
            if (cur.key == key) {
                return cur.value;
            }
        }
        return null;
    }
}

