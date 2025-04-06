package src;

class MyArraySubList<E> extends MyArrayList<E> {

    private int offset;
    private Object[] storage;
    private int size;
    private MyArrayList<E> parent;

    MyArraySubList(MyArrayList<E> parent, int fromIndex, int toIndex) {
        offset = fromIndex;
        this.storage = parent.storage;
        this.size = toIndex - fromIndex;
        this.parent = parent;
    }

    @Override
    public E get(int index) {
        if (isValidIndex(index)) {
            return parent.get(offset + index);
        }
        return null;
    }

    @Override
    public void clear() {
        for (int i = offset; i < size + offset; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean add(E e) {
        Object oldValue = storage[offset + size];
        for (int i = offset + size + 1; i < parent.size(); i++) {
            Object curValue = storage[i];
            storage[i] = oldValue;
            oldValue = curValue;
        }
        storage[offset + size] = e;
        size++;
        storage[size] = oldValue;
        parent.size++;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

}
