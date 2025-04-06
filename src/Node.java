package src;

public class Node<E> {

    private E value;
    private Node<E> next;
    private Node<E> prev;

    public Node(Node<E> prev,E value, Node<E> next) {
        this.value = value;
        this.next = next;
        this.prev = prev;
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

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }
}
