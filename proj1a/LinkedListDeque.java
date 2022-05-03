public class LinkedListDeque<T> {

    public class Node{
        Node pre;
        T val;
        Node next;

        public Node(T v, Node p, Node n){
            val = v;
            pre = p;
            next = n;
        }

        public Node(T v, Node n){
            val = v;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new Node(null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public LinkedListDeque(LinkedListDeque other){
        Node s2 = other.sentinel;
        sentinel = new Node(s2.val, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = other.size;

        Node pre = sentinel;
        Node s2_cur = s2.next;
        Node cur;
        while (s2_cur != s2){
            pre.next = new Node(s2_cur.val, null);
            cur = pre.next;
            cur.pre = pre;
            pre = pre.next;
            s2_cur = s2_cur.next;
        }
        pre.next = sentinel;
        sentinel.pre = pre;

    }



    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }


    public void addFirst(T item){
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.pre = newNode;
        sentinel.next = newNode;
        size++;
    }

    public void addLast(T item){
        Node newNode = new Node(item, sentinel.pre, sentinel);
        sentinel.pre.next = newNode;
        sentinel.pre = newNode;
        size++;
    }

    public T removeFirst(){
        if (size == 0 ){
            return null;
        }
        T ans = sentinel.next.val;
        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return ans;
    }

    public T removeLast(){
        if (size == 0 ){
            return null;
        }
        T ans = sentinel.pre.val;
        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;
        size--;
        return ans;
    }


    public void printDeque(){
        Node ptr = sentinel.next;
        while (ptr != sentinel) {
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
    }



    public T get(int index){
        if (index >= size) {
            return null;
        }
        Node p = sentinel;

        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        return p.val;
    }

}
