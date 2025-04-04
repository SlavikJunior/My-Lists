package src;

import java.util.Iterator;

public class MyLinkedListIterator<E> implements Iterator<E> {

    private MyLinkedList<E> self;
    private int index = 0;
    private Node<E> cur;

    public MyLinkedListIterator(MyLinkedList<E> self) {
        this.self = self;
        cur = self.getHead();
    }

    @Override
    public boolean hasNext() {
        return index < self.size();
    }

    @Override
    public E next() {
        E value = null;
        if (hasNext()) {
            value = cur.getValue();
            cur = cur.getNext();
            index++;
        }
        return value;
    }
}
