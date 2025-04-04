package src;

import java.util.Iterator;
import java.util.List;

public class MyLinkedList<E> extends MyAbstractCollection<E> implements List<E>{

    private Node<E> head;
    private int size;

    public Node<E> getHead() {
        return head;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIterator<>(this);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        head = new Node<>(e, head);
        size++;
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean remove(Object o) {
        if (head.getValue() == o) {
            head = head.getNext();
        }
        boolean isNotDeleted = true;
        for (Node<E> p = head; p != null; p = p.getNext()) {
            Node<E> p2 = p.getNext();
            if (p2 != null && p2.getValue().equals(o) && isNotDeleted) {
                p.setNext(p2.getNext());
                isNotDeleted = false;
            }
        }
        if (!isNotDeleted) size--;
        return !isNotDeleted;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        int i = 0;
        Node<E> p  = head;
        for (; i < index; i++, p = p.getNext());
        return p.getValue();
    }

    @Override
    public E set(int index, E element) {
        if (!isValidIndex(index))
            return null;

        E oldValue = get(index);
        int i = 0;
        Node<E> p = head;
        for (; i < index; i++, p = p.getNext());
        p.setValue(element);

        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        if (isValidIndex(index)) {
            int i = 0;
            Node<E> p = head;
            for (; i < index - 1; i++, p = p.getNext());
            Node<E> newNode = new Node<>(element, p.getNext());
            p.setNext(newNode);
            size++;
        }
    }

    @Override
    public E remove(int index) {
        if (!isValidIndex(index))
            return null;

        E oldValue = get(index);

        if (index == 0) {
            head = head.getNext();
        } else {
            int i = 0;
            Node<E> p = head;
            for (; i < index - 1; i++, p = p.getNext());
            // перекидываем ссылку через ноду
            p.setNext(p.getNext().getNext());
        }

        size--;
        return oldValue;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }
}
