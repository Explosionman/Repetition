package ru.rybinskov.gb;

public interface MyList<E> {

    boolean isEmpty();
    int size();
    void add(E value);
    E remove(E value);
    E remove(int index);
    E get(int index);
    int indexOf(E value);

    default boolean contains(E value) {
        return indexOf(value) != -1;
    }

    void clear();
    void add(E value, int index);
}
