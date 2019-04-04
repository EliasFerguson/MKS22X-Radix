public class Node<E> {
  private E data;
  private Node<E> next, prev;
  public Node(E in, Node<E> nextIn, Node<E> prevIn) {
    data = in;
    next = nextIn;
    prev = prevIn;
  }
  public Node<E> next() {
    return next;
  }
  public Node<E> prev() {
    return prev;
  }
  public boolean hasNext() {
    if (next == null) return false;
    return true;
  }
  public void setNext(Node<E> other) {
    next = other;
  }
  public void setPrev(Node<E> other) {
   prev = other;
  }
  public E getData() {
    return data;
  }
  public E setData(E i) {
    E old = data;
    data = i;
    return old;
  }
  public String toString() {
    return "" + data;
  }
}
