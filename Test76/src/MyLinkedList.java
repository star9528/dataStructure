
class Node {
    public int val;
    public Node next = null;

    public Node (int val) {
        this.val = val;
    }
}

public class MyLinkedList {
    private Node head = null;
    private int size2 = getSize();

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (size2 >=  index || index < 0) {
            return -1;
        }
        Node cur = head;
        for (int i = 0;i < index + 1;i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node node = new Node(val);
        if (size2 < index || index < 0) {
            return;
        }
        if (size2 == index) {
            addAtTail(val);
            return;
        }
        if (size2 == 0) {
            node.next = head;
            head = node;
            return;
        }
        Node pre = null;
        Node cur = head;
        for (int i = 0;i < index;i++) {
            head = cur;
            cur = cur.next;
        }
        node.next = cur;
        pre.next = node;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index > size2 || index < 0) {
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        Node pre = null;
        Node cur = head;
        for (int i = 0;i < index;i++) {
            pre = cur;
            cur = cur.next;
        }
        if (index == size2) {
            pre.next = null;
            return;
        }
        pre.next = cur.next;
    }

    public int getSize() {
        int size = 0;
        for (Node cur = head;cur != null;cur = cur.next) {
            size++;
        }
        return size;
    }
}
