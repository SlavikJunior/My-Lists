package src;

import java.util.Iterator;
import java.util.List;

public class MyLinkedList<E> extends MyAbstractCollection<E> implements List<E>{

	private Node<E> head = new Node<>(null, null, null);
	private Node<E> end = new Node<>(head, null, null);
	private int size;
	MyLinkedList<E> parent = null;

	public MyLinkedList(){}

	private MyLinkedList(Node<E> head, Node<E> end, int size, MyLinkedList<E> parent){
		this.head = head;
		this.end = end;
		this.size = size;
		this.parent = parent;
	}


	// sublist не реализован в этом классе
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		int newSize = toIndex - fromIndex;

		MyLinkedList<E> sub = new MyLinkedList<>(null, null, newSize, this);

		return sub;
	}

	public Node<E> getHead() {
		return head;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyLinkedListIterator<>(this);
	}



	@Override
	public boolean add(E e) {
		if (size == 0) {
			end = new Node<>(head, e, null);
			head.setNext(end);
			head = end;
			size++;
			return true;
		}
		Node<E> newNode = new Node<>(null, e, head);
		head.setPrev(newNode);
		head = newNode;
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		if (head.getValue() == o) {
			head = head.getNext();
		}

		if (head.getValue().equals(o)) {
			head = head.getNext();
			size--;
			return true;
		}

		for (Node<E> p = head; p != null; p = p.getNext()) {
			if (p.getValue().equals(o)) {
				Node<E> prev = p.getPrev();
				Node<E> next = p.getNext();
				prev.setNext(next);
				next.setPrev(prev);
				size--;
				return true;
			}
		}
		return false;
	}

	@Override
	public void clear() {
		head = new Node<>(null, null, null);
		size = 0;
	}

	@Override
	public E get(int index) {
		int i = 0;
		Node<E> p  = head;
		for (; i < index; i++, p = p.getNext());
		return p.getValue();
	}

	@Override
	public E set(int index, E element) {
		if (!isValidIndex(index))
			return null;

		E oldValue = get(index);
		int i = 0;
		Node<E> p = head;
		for (; i < index; i++, p = p.getNext());
		p.setValue(element);

		return oldValue;
	}

	@Override
	public void add(int index, E element) {
		if (isValidIndex(index)) {
			int i = 0;
			Node<E> p = head;
			for (; i < index - 1; i++, p = p.getNext());
			Node<E> newNode = new Node<>(p, element, p.getNext());
			p.setNext(newNode);
			size++;
		}
	}

	@Override
	public E remove(int index) {
		if (!isValidIndex(index))
			return null;

		E oldValue = get(index);

		if (index == 0) {
			head = head.getNext();
		} else {
			int i = 0;
			Node<E> p = head;
			for (; i < index - 1; i++, p = p.getNext());
			// перекидываем ссылку через ноду
			p.setNext(p.getNext().getNext());
		}

		size--;
		return oldValue;
	}

}