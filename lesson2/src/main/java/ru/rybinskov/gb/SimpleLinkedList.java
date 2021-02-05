package ru.rybinskov.gb;

public class SimpleLinkedList<E> implements MyLinkedList<E> {
    private int size;
    Node<E> first;
    Node<E> last;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value, first, null);
        if (size == 1) {
            last = first;
        }
        first = newNode;
        size++;
    }

    @Override
    public void addLast(E value) {
        Node<E> newNode = new Node<>(value, null, last);
        last.next = newNode;
        last = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = first;
        E item = removedNode.item;
        first = removedNode.next;
        removedNode.item = null;
        removedNode.next = null;
        size--;
        return item;
    }

    @Override
    public E removeLast() {
        Node<E> removedNode = last;
        E item = removedNode.item;
        last = last.previous;
        last. next = null;
        removedNode.next = null;
        removedNode.previous = null;
        removedNode.item = null;
        return item;
    }

    @Override
    public E getFirst() {
        return first.item;
    }

    @Override
    public E getLast() {
        return last.item;
    }


    @Override
    public boolean contains(E value) {
        Node<E> current = first;
        while (current != null) {
            current = current.next;
            if (current.item.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Node<E> current = first;
        while (current != null) {
            sb.append(current.item).append(", ");
            current = current.next;
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append("}");
        return sb.toString();
    }

    class Node<E> {
        E item;
        Node<E> next;
        Node<E> previous;

        public Node(E item, Node<E> next, Node<E> previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }
}
