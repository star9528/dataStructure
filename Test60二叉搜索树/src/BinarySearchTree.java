//二叉搜索树
public class BinarySearchTree {
    public static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }
    private  Node root = null;
    //查找
    public Node find(int key) {
        Node cur = root;
        Node parent = null;//始终指向父节点
        while (cur != null) {
            if (cur.key  < key) {
                //去右侧查找
                parent = cur;
                cur = cur.right;
            } else if (cur.key > key) {
                //去左侧查找
                parent = cur;
                cur = cur.left;
            } else {
                //相等就是找到了
                return cur;
            }
        }  // end while
        return null;
    }
    //插入
    public boolean insert(int key) {
        if (root == null) {
            //如果为空树，让 root 指向 key 指向对应的新节点
            root = new Node(key);
            return true;
        }
        Node cur = root;
        Node parent = null;//始终指向父节点
        while (cur != null) {
            if (cur.key < key) {
                //向右插
                parent = cur;
                cur = cur.right;
            } else if (cur.key > key) {
                //向左插
                parent = cur;
                cur = cur.left;
            } else {
                //找到一个值与插入元素相等，说明元素重复，插入失败
                return false;
            }
        }
        //循环结束后，cur 指向 null,当前元素就要插入到 parent 的子树位置上
        //到底是插入到 parent 的左子树还是右子树，还要用 key 与 parent 比较
        if (parent.key < key) {
            //插入到 parent 的右子树
            parent.right = new Node(key);
        } else if (parent.key > key) {
            //插入到 parent 的左子树
            parent.left = new Node(key);
        } else {
            //找到一个值与插入元素相等，说明元素重复，插入失败
            //如果当前树存的是键值对，发现相同的 key 就修改值
            return false;
        }
        return true;
    }

    public boolean remove(int key) {
        //先查找要删除的元素在哪里
        Node parent = null;
        Node cur = root;

        while (cur != null) {
            if (key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else if (key > cur.key) {
                parent = cur;
                cur = cur.right;
            } else {
                removeNode(parent,cur);
                return true;
            }
        }
        return false;
    }
        //删除
    private void removeNode(Node parent,Node cur) {
        //1.待删除节点没有左子树
        if (cur.left == null) {
            //1.1待删除节点为头结点
            if (cur == root) {
                root = cur.right;
            } else if (cur == parent.left) {
                //1.2 cur 为 parent 的左子树
               parent.left = cur.right;
            } else if (cur == parent.right) {
                //1.3 cur 为 parent 的右子树
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            //2.待删除节点没有右子树
            if (cur == root) {
                //2.1 cur 为 root
                root = cur.left;
            } else if (parent.right == cur) {
                //2.2 cur 为 parent 的右子树
                parent.right = cur.left;
            } else if (parent.left == cur) {
                //2.3 cur 为 parent 的左子树
                parent.left = cur.left;
            }
        } else {
            //3.待删除节点左右子树都有
            Node goatParent = cur;//替罪羊节点的父节点
            Node scapeGoat = cur.right;//替罪羊节点
            while (scapeGoat.left != null) {
                //1)找到待删除节点的左子树的最小值（替罪羊节点）
                goatParent = scapeGoat;
                scapeGoat = scapeGoat.left;
            }
            //2)把最小值赋给待删除节点
            cur.key = scapeGoat.key;
            //3)删除替罪羊节点
            //  替罪羊节点一定没有左子树
            if (goatParent.left == scapeGoat) {
                goatParent.left = scapeGoat.right;
            } else {
                goatParent.right = scapeGoat.right;
            }
        }
    }

    public void proOrder (Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key);
        proOrder(root.left);
        proOrder(root.right);
    }

    public void inOrder (Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.key);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9);
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(3);
        tree.insert(6);
        tree.insert(8);

        tree.proOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);

        System.out.println();
        Node cur = tree.find(2);
        System.out.println(cur.key);

        Node cur2 = tree.find(100);
        System.out.println(cur2);

        System.out.println("===========删除之后==========");

        tree.remove(5);
        tree.proOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
    }
}
