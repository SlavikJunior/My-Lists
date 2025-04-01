package src;

import java.util.*;

public class MyArrayListTest<E> implements List<E> {

    private int capacity = 50;
    protected int size = 0;
    protected Object[] storage = new Object[capacity];
    private List<MyArrayListTest<E>> subLists = new ArrayList<>();

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        MyArrayListTest<E> sub = new MySubListTest<>(this, fromIndex, toIndex);
        subLists.add(sub);
        return sub;
    }

    @Override
    public boolean add(E e) {
        ensureCapacity();
        storage[size++] = e;
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        if (isValidIndex(index))
            return (E)storage[index];
        return null;
    }

    protected boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public E set(int index, E element) {
        if (isValidIndex(index)) {
            E oldValue = get(index);
            storage[index] = element;
            return oldValue;
        }
        return null;
    }

    @Override
    public void add(int index, E element) {
        if (index == size) {
            storage[size++] = element;
        }
        else if (isValidIndex(index)) {
            Object oldValue = storage[index];
            for (int i = index + 1; i < size; i++) {
                Object curValue = storage[i];
                storage[i] = oldValue;
                oldValue = curValue;
            }
            storage[index] = element;
            storage[size++] = oldValue;
        }
    }

    @Override
    public void clear() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(E x : this) {
            sb.append(x + " ");
        }
        return sb.toString();
    }

    private void ensureCapacity() {
        if (size >= capacity * 2/3) {
            capacity = capacity * 3/2;
            storage = Arrays.copyOf(storage, capacity);
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListTestIterator<>(this);
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        if (storage[size - 1].equals(o)) {
            size--;
            return true;
        }
        int index = - 1;
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(o)) {
                index = i;
                break;
            }
        }
        if (index != - 1) {
            for (int i = index; i < size - 1; i++) {
                storage[i] = storage[i + 1];
            }
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }
}
