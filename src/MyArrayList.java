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
        MyArrayList<E> sub = new MySubList<>(this, fromIndex, toIndex);
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
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
        for(MyArrayList<E> sub : subLists) {
            sub.clear();
        }
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
        for(Object temp : storage) {
            if (temp.equals(o))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator<>(this);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(storage, size);
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

    @Override
    public boolean containsAll(Collection<?> c) {
        if (size < c.size()) {
            return false;
        }
        if (!(c instanceof List<?> otherList))
            return false;
        for (int i = 0; i < c.size(); i++) {
            if (!this.contains(otherList.get(i)))
                return false;
        }
        return true;
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

    @Override
    public int indexOf(Object o) {
        int id = 0;
        for (Object temp : storage) {
            if (temp.equals(0)) {
                return id;
            }
            id++;
        }
        return - 1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(o))
                return i;
        }
        return - 1;
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
