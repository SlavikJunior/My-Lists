package src;

import java.util.*;

public class MyArrayList<E> implements List<E> {
	private int size = 0;
	private int leftPointer = 0;
	private int rightPointer = size;
	private int capacity = 1000;
	private Object[] storage = new Object[capacity];
	private MyArrayList<E> parent = null;
	private List<MyArrayList<E>> mySubLists = new ArrayList<>();

	public MyArrayList() {}

	private MyArrayList(MyArrayList<E> parent, int leftPointer, int rightPointer) {
		this.parent = parent;
		this.leftPointer = leftPointer;
		this.rightPointer = rightPointer;
		this.size = rightPointer - leftPointer;
		this.storage = parent.storage;
	}

	private void ensureCapacity() {
		if (size >= capacity * 2/3) {
			capacity = capacity * 3/2;
			storage = Arrays.copyOf(storage, capacity);
		}
	}

	public int getLeftPointer() {
		return leftPointer;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		MyArrayList<E> sub = new MyArrayList<>(this, fromIndex, toIndex);
		mySubLists.add(sub);
		return sub;
	}

	@Override
	public boolean add(E element) {
		if (parent == null) {
			ensureCapacity();
			storage[size++] = element;
			rightPointer = size;
			return true;
		} else {
			parent.ensureCapacity();

			System.arraycopy(parent.storage, rightPointer,
					parent.storage, rightPointer + 1,
					parent.size - rightPointer);

			parent.storage[rightPointer] = element;
			parent.size++;

			rightPointer++;
			size++;
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		return (E) (parent != null ? parent.storage[index + leftPointer] : storage[index]);
	}

	@Override
	public Iterator<E> iterator() {
		return new MyArrayListIterator<>(this);
	}

	@Override
	public int size() {
		return size;
	}

	@Override public void add(int index, E element) {}

	@Override public boolean addAll(Collection<? extends E> c) { return false; }

	@Override public boolean addAll(int index, Collection<? extends E> c) { return false; }

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		size = 0;
		for (MyArrayList<E> temp : mySubLists) {
			temp.size = 0;
		}
	}

	@Override public boolean contains(Object o) {
		for (int i = leftPointer; i < rightPointer; i++) {
			if (storage[i].equals(o)) return true;
		} return false;
	}

	@Override public boolean containsAll(Collection<?> c) { return false; }

	@Override public boolean equals(Object o) {
		if (!(o instanceof List<?> otherList) || otherList.size() != size) return false;
		for (int i = leftPointer; i < rightPointer; i++) {
			if (storage[i] != otherList.get(i)) return false;
		}
		return true;
	}

	@Override public int hashCode() { return 0; }
	@Override public int indexOf(Object o) { return 0; }
	@Override public boolean isEmpty() { return size == 0; }
	@Override public int lastIndexOf(Object o) { return 0; }
	@Override public ListIterator<E> listIterator() { return null; }
	@Override public ListIterator<E> listIterator(int index) { return null; }
	@Override public E remove(int index) { return null; }
	@Override public boolean remove(Object o) { return false; }
	@Override public boolean removeAll(Collection<?> c) { return false; }
	@Override public boolean retainAll(Collection<?> c) { return false; }
	@Override public E set(int index, E element) { return element; }

	@Override public Object[] toArray() {
		return Arrays.copyOf(storage, size);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {
		if (a == null) throw new NullPointerException();

		Object[] src = (parent != null) ? parent.storage : storage;
		int srcPos = (parent != null) ? leftPointer : 0;

		if (a.length < size) {
			return (T[]) Arrays.copyOfRange(src, srcPos, srcPos + size, a.getClass());
		}

		System.arraycopy(src, srcPos, a, 0, size);

		if (a.length > size) {
			a[size] = null;
		}

		return a;
	}
}