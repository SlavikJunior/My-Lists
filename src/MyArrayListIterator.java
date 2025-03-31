package src;

import java.util.*;

public class MyArrayListIterator<E> implements Iterator<E> {
	
	private int index;
	private MyArrayList<? extends E> mal;
	
	public MyArrayListIterator(MyArrayList<? extends E> mal) {
		this.mal = mal;
		this.index = mal.getLeftPointer();
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