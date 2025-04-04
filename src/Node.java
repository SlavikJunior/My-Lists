package src;

public class Node<E> {

    private E value;
    private Node<E> next;

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    void setValue(E value) {
        this.value = value;
    }

    public Node<E> getNext() {
        return next;
    }

    void setNext(Node<E> next) {
        this.next = next;
    }
}
