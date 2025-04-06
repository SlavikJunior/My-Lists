package src;

import java.util.*;

public class MyArrayListIterator<E> implements Iterator<E> {

    private int index;
    private MyArrayList<? extends E> mal;

    public MyArrayListIterator(MyArrayList<? extends E> mal) {
        this.mal = mal;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index < mal.size())
            return true;
        return false;
    }

    @Override
    public E next() {
        if (hasNext()) {
            E value = mal.get(index);
            index++;
            return value;
        }
        return null;
    }
}