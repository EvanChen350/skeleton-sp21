package deque;

public class LinkedListDeque<T> {
    private class Node {
        T item;
        Node prev;
        Node next;
        Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node sentinel; // 哨兵节点
    private int size;
    public  LinkedListDeque(){
        this.sentinel = new Node(null,null,null);
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
        size=0;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }
    public void addFirst(T item){
        Node newNode = new Node(item,sentinel,sentinel.next);
        sentinel.next.prev=newNode;
        sentinel.next=newNode;
        this.size++;
    }

    public void addLast(T item){
        Node newNode = new Node(item,sentinel.next,sentinel);
        sentinel.prev.next=newNode;
        sentinel.prev=newNode;
        this.size++;
    }

    public String printDeque() {
        String result = "this Deque => ";
        Node p = sentinel.next;
        while (p != sentinel) {
            result += p.item + " => ";
            p = p.next;
        }
        return result;
    }

    public T removeFirst() {
        T removeItem = sentinel.prev.item;
        if (isEmpty()) {
            return null;
        } else {
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size--;
        }

        return removeItem;
    }

    public T removeLast(){
        T removeItem = sentinel.prev.item;
        if (isEmpty()) {
            return null;
        } else {

            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size--;
        }
        return removeItem;
    }

}



