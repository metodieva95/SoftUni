package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    private static final int INITIAL_CAPACITY = 4;
    private Object[] elements;
    private int size;
    private int capacity = INITIAL_CAPACITY;

    public ArrayList() {
        this.elements = new Object[capacity];
        this.size = 0;
    }

    @Override
    public boolean add(E element) {

        if (this.size == this.elements.length) {
            grow();
        }

        this.elements[this.size] = element;
        this.size++;

        return true;
    }

    @Override
    public boolean add(int index, E element) {
        validateIndex(index);

        if (this.size == this.elements.length) {
            grow();
        }

        shiftRight(index);
        this.elements[index] = element;
        size++;

        return true;
    }

    @Override
    public E get(int index) {
        validateIndex(index);

        return getElement(index);
    }

    @Override
    public E set(int index, E element) {
        validateIndex(index);

        E oldElement = getElement(index);
        this.elements[index] = element;

        return oldElement;
    }

    @Override
    public E remove(int index) {
        validateIndex(index);

        E elementToRemove = getElement(index);

        shiftLeft(index);
        size--;

        if (this.size < this.capacity / 3) {
            shrink();
        }

        return elementToRemove;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean contains(E element) {
        return this.indexOf(element) != -1;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    private void grow() {
        this.capacity *= 2;

        Object[] tmp = new Object[this.capacity];

        for (int i = 0; i < this.elements.length; i++) {
            tmp[i] = this.elements[i];
        }

        this.elements = tmp;
    }

    private void shrink() {
        this.capacity = this.capacity / 2;

        Object[] tmp = new Object[this.capacity];

        for (int i = 0; i < this.size; i++) {
            tmp[i] = this.elements[i];
        }

        this.elements = tmp;

//        this.elements = Arrays.copyOf(this.elements, this.capacity / 2);
    }

    private void validateIndex(int index) {
         if (index < 0 || index >= this.size) {
             throw new IndexOutOfBoundsException("Index out of bounds: " + index + " for size " + this.size);
        }
    }

    private void shiftRight(int index) {
        for (int i = this.size - 1; i >= index; i--) {
            this.elements[i + 1] = this.elements[i];
        }
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
    }

    private E getElement(int index) {
        return (E) this.elements[index];
    }
}
