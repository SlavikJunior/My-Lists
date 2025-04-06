package src;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public abstract class MyAbstractCollection<E> {


    public boolean contains(Object o) {
        Iterator<E> it = iterator();
        if (o == null){
            while(it.hasNext()) {
                if (it.next() == null)
                    return true;
            }
        } else {
            while (it.hasNext()) {
                if (o.equals(it.next()))
                    return true;
            }
        }
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o))
                return false;
        }
        return true;
    }

    public abstract Iterator<E> iterator();

    public abstract int size();

    public boolean isEmpty(){
        return size() == 0;
    }

//  шаблонно заглушил два метода
//  наверное они должны быть абстрактными (но это не точно)
    public ListIterator<E> listIterator() {
        return null;
    }

    public ListIterator<E> listIterator(int index) {
        return null;
    }

    public abstract boolean add(E e);

    public abstract void add(int index, E e);

    public abstract boolean remove(Object o);

    public abstract E remove(int index);

    public boolean addAll(Collection<? extends E> c) {
        if (c == null)
            return true;
        boolean isAdded = false;
        for (E e : c) {
            if (add(e))
//                isAdded = add(e) || isAdded;
                isAdded = true;
        }
        return isAdded;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    public int indexOf(Object o) {
        Iterator<E> it = iterator();
        int index = 0;
        while (it.hasNext()) {
            if (it.next().equals(o))
                return index;
            index++;
        }
        return - 1;
    }

    public int lastIndexOf(Object o) {
        Iterator<E> it = iterator();
        int index = 0;
        int curIndex = - 1;
        while (it.hasNext()) {
            if (it.next().equals(o))
                curIndex = index;
            index++;
        }
        return curIndex;
    }

    public boolean removeAll(Collection<?> c) {
        if (c == null)
            return true;

        boolean isModified = false;
        for (Object o : c) {
            if (contains(o)) {
                remove(o);
                isModified = true;
            }
        }

        return isModified;
    }

    public boolean retainAll(Collection<?> c) {
        if (c == null)
            return false;

        boolean isModified = false;
        Iterator<E> it = iterator();
        while(it.hasNext()) {
            E curValue = it.next();
            if (!c.contains(curValue)) {
                remove(curValue);
                isModified = true;
            }
        }

        return isModified;
    }

    @Override
    public String toString() {
        Iterator it = iterator();
        StringBuilder sb = new StringBuilder("[");
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext())
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public Object[] toArray(){
        Iterator<E> it = iterator();
        Object[] res = new Object[size()];
        int i = 0;
        while(it.hasNext()) {
            res[i] = it.next();
            i++;
        }
        return res;
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a == null) {
            return null;
        }

        if (a.length < size()) {
            return (T[]) Arrays.copyOf(toArray(), size(), a.getClass());
        }

        System.arraycopy(toArray(), 0, a, 0, size());

        if (a.length > size()) {
            a[size()] = null;
        }

        return a;
    }

    protected boolean isValidIndex(int index) {
        return index >= 0 && index < size();
    }
}
