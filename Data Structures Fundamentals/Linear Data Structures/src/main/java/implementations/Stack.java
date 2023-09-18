package implementations;

import interfaces.AbstractStack;

import java.util.Iterator;

public class Stack<E> implements AbstractStack<E> {

    private Node<E> top;
    private int size;

    private static class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E element) {
            this.value = element;
        }
    }

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(E element) {
        Node<E> toInsert = new Node<>(element);

        toInsert.next = this.top;
        this.top = toInsert;

        this.size++;
    }

    @Override
    public E pop() {
        if(isEmpty()) {
            throw new IllegalStateException("No such element");
        }

        Node<E> tmp = this.top;
        this.top = tmp.next;

        this.size--;

        return tmp.value;
    }

    @Override
    public E peek() {
        if(isEmpty()) {
            throw new IllegalStateException("No such element");
        }

        return this.top.value;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

           private Node<E> currentElement = top;

            @Override
            public boolean hasNext() {
                return this.currentElement != null;
            }

            @Override
            public E next() {
                E value = this.currentElement.value;
                this.currentElement = this.currentElement.next;

                return value;
            }
        };
    }
}
