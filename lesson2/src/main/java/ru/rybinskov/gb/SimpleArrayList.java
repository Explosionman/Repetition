package ru.rybinskov.gb;

import java.util.Arrays;

public class SimpleArrayList<E> implements MyList<E> {

    private final int defaultCapacity = 10;
    private int size;
    private E[] array;
    private int currentIndex = 0;

    public SimpleArrayList(int capacity) {
        array = (E[]) new Object[capacity];
    }

    public SimpleArrayList() {
        array = (E[]) new Object[defaultCapacity];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E value) {
        if (array.length == size) {
            array = Arrays.copyOf(array, (size + 1) * 2);
        }
        array[size++] = value;
    }

    @Override
    public E remove(E value) {
        int index = indexOf(value);
        return delete(index);
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        return delete(index);
    }

    public E delete(int index) {
        E removedValue = array[index];
        array[index] = null;
        size--;
        return removedValue;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return array[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= array.length) {
            throw new IllegalArgumentException("Неверно указан индекс");
        }
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        this.array = (E[]) new Object[0];
    }

    @Override
    public void add(E value, int index) {
        checkIndex(index);
        array[index] = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            if (i != array.length -1) {
                sb.append(array[i]).append(", ");
            } else {
                sb.append(array[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
