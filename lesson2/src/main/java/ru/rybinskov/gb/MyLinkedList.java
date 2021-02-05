package ru.rybinskov.gb;

public interface MyLinkedList<E> {
    boolean isEmpty();
    int size();

    void addFirst(E value);
    void addLast(E value);

    E removeFirst();
    E removeLast();

    E getFirst();
    E getLast();

    boolean contains(E value);
}
