import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
//给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
//要求返回这个链表的 深拷贝。
public class Solution {
    public Node copyRandomList(Node head) {
        //1.遍历旧链表，把旧链表每个节点一次插入到 map 中。
        // key 是旧链表节点，value 是拷贝出来的新节点
        Map<Node,Node> map = new HashMap<>();
        for (Node cur = head;cur != null;cur = cur.next) {
            map.put(cur,new Node(cur.val));
        }
        //2.再次遍历链表，修改新链表节点中的 next 和 random
        for (Node cur = head;cur != null;cur = cur.next) {
            //先从 map 中 找到 cur 对应的新链表节点
            Node newCur = map.get(cur);
            newCur.next = map.get(cur.next);
            newCur.random = map.get(cur.random);
        }
        //需要返回新链表头结点
        return map.get(head);
    }

    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,10);
        map.put(2,20);
        map.put(3,30);
        map.put(4,40);

        //1.使用迭代器
        //Entry 表示一个键值对
        //entrySet 包含 Entry 的 set
        Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer,Integer> entry = iterator.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        //2.使用 for each
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
