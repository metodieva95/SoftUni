package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {

    private Node<E> head;
    private int size;

    private static class Node<E> {
        private final E value;
        private Node<E> next;

        public Node(E element) {
            this.value = element;
        }
    }

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void addFirst(E element) {
        Node<E> newElement = new Node<>(element);

        newElement.next = this.head;
        this.head = newElement;

        this.size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> lastElement = new Node<>(element);

        if (this.size == 0) {
            this.head = lastElement;
        } else {
            Node<E> current = this.head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = lastElement;
        }

        this.size++;
    }

    @Override
    public E removeFirst() {
        ensureNonEmpty();

        Node<E> elementToRemove = this.head;

        this.head = elementToRemove.next;
        size--;

        return elementToRemove.value;
    }

    @Override
    public E removeLast() {
        ensureNonEmpty();

        if (this.size == 1) {
            E value = this.head.value;
            this.head = null;
            this.size--;

            return value;
        }

        Node<E> secondToLast = this.head;
        Node<E> last = this.head.next;

        while (last.next != null) {
            secondToLast = last;
            last = last.next;
        }

        secondToLast.next = null;

        return last.value;
    }

    @Override
    public E getFirst() {
        ensureNonEmpty();

        return this.head.value;
    }

    @Override
    public E getLast() {
        ensureNonEmpty();

        Node<E> current = this.head;

        while (current.next != null) {
            current = current.next;
        }

        return current.value;
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
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E value = current.value;

                current = current.next;

                return value;
            }
        };
    }

    private void ensureNonEmpty() {
        if (this.isEmpty()) {
            throw new IllegalStateException("No such element");
        }
    }
}
