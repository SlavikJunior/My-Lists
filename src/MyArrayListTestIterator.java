package src;

import java.util.*;

public class MyArrayListTestIterator<E> implements Iterator<E> {

    private int index;
    private MyArrayListTest<? extends E> mal;

    public MyArrayListTestIterator(MyArrayListTest<? extends E> mal) {
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
            return mal.get(index++);
        }
        return null;
    }
}