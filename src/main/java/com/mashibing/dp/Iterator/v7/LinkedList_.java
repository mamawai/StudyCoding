package com.mashibing.dp.Iterator.v7;

/**
 * 相比数组，这个容器不用考虑边界问题，可以动态扩展
 */
class LinkedList_<E> implements Collection_<E> {
    Node head = null;
    Node tail = null;
    //目前容器中有多少个元素
    private int size = 0;

    public void add(E o) {
        Node n = new Node(o);
        n.next = null;

        if(head == null) {
            head = n;
            tail = n;
        }

        tail.next = n;
        tail = n;
        size++;
    }

    private class Node {
        private E o;
        Node next;

        public Node(E o) {
            this.o = o;
        }
        public Node(Node next){
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator_<E> iterator() {
        return new LinkedListIterator();
    }
    private class LinkedListIterator implements Iterator_<E>{

        Node currentNode = new Node(head);

        @Override
        public boolean hasNext() {
            return currentNode.next != null;
        }

        @Override
        public E next() {
            currentNode = currentNode.next;
            return currentNode.o;
        }
    }
}
