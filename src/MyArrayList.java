package src;

import java.util.*;

public class MyArrayList<E> extends MyAbstractCollection<E> implements List<E>{

    private int capacity = 50;
    protected int size = 0;
    protected Object[] storage = new Object[capacity];
    private List<MyArrayList<E>> subLists = new ArrayList<>();

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        MyArrayList<E> sub = new MyArraySubList<>(this, fromIndex, toIndex);
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
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
        for(MyArrayList<E> sub : subLists) {
            sub.clear();
        }
    }

    private void ensureCapacity() {
        if (size >= capacity * 2/3) {
            capacity = capacity * 3/2;
            storage = Arrays.copyOf(storage, capacity);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator<>(this);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            return (T[]) Arrays.copyOf(storage, size, a.getClass());
        System.arraycopy(storage, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
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

    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) {
        E oldValue = (E) storage[index];
        if (!isValidIndex(index))
            return null;
        for (int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
        size--;
        return oldValue;
    }
}
